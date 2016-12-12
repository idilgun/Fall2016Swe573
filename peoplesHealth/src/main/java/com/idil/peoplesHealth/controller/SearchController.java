package com.idil.peoplesHealth.controller;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.idil.peoplesHealth.dao.ActivityDao;
import com.idil.peoplesHealth.dao.FoodConsumptionDao;
import com.idil.peoplesHealth.dao.UserDao;
import com.idil.peoplesHealth.domain.Activity;
import com.idil.peoplesHealth.domain.FoodInfo;
import com.idil.peoplesHealth.domain.FoodItem;
import com.idil.peoplesHealth.domain.FoodItem.ndbno_itemUnit;
import com.idil.peoplesHealth.util.USDAResponseUtil;
import com.idil.peoplesHeath.USDA.response.FoodItemDetailResponse;
import com.idil.peoplesHeath.USDA.response.Item;
import com.idil.peoplesHeath.USDA.response.List;
import com.idil.peoplesHeath.USDA.response.Measure;
import com.idil.peoplesHeath.USDA.response.Nutrient;
import com.idil.peoplesHeath.USDA.response.SearchByNameResponse;

@Controller
public class SearchController {

	@Autowired
	private FoodConsumptionDao foodConsumptionDao;
	
	@Autowired
	private ActivityDao activityDao;

	/**
	 * This method is used for searching food by name and group
	 * 
	 * @param searchString
	 *            is what the user inputs to search for a food item
	 * @param group
	 *            is one of the food groups that the USDA api presents
	 * @return
	 */
	@RequestMapping(value = "/searchFood/{searchString}/{group}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<SearchByNameResponse> searchFood(
			@PathVariable(value = "searchString") String searchString, @PathVariable(value = "group") String group) {

		String url = "http://api.nal.usda.gov/ndb/search?format=json&api_key=sI0yVwgif7DGbueKoG3ZGeh4umIrt5unA3QWvDnY&q=";
		url += searchString;
		url += "&ds=Standard%20Reference&sort=n";

		String jsonResponse = "";
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpGet request = new HttpGet(url.toString());
			HttpResponse result = httpClient.execute(request);

			jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

			Gson gson = new Gson();

			SearchByNameResponse usdaResponse = gson.fromJson(jsonResponse, SearchByNameResponse.class);

			SearchByNameResponse unfilteredResponse = gson.fromJson(jsonResponse, SearchByNameResponse.class);
			
			USDAResponseUtil.filterFoodsByGroup(usdaResponse, group);
			
			if(usdaResponse.getList().getItems().isEmpty()){
				usdaResponse = unfilteredResponse;
			}

			ResponseEntity<SearchByNameResponse> response = new ResponseEntity<SearchByNameResponse>(usdaResponse,
					HttpStatus.OK);

			return response;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SearchByNameResponse emptyResponse = new SearchByNameResponse();
		ResponseEntity<SearchByNameResponse> response = new ResponseEntity<SearchByNameResponse>(emptyResponse,
				HttpStatus.NO_CONTENT);
		return response;

	}

	/**
	 * This method is used for searching food details by ndbno provided usda api
	 * at first only the units returned to client because details are based on
	 * units
	 * 
	 * @param ndbno
	 *            is the unique identifier of food items provided by usda
	 * @return
	 */
	@RequestMapping(value = "/foodItemUnits/{ndbno}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String[]> getFoodItemDetails(@PathVariable(value = "ndbno") String ndbno) {

		String[] unitsFromDB = foodConsumptionDao.getUnitsOfItem(ndbno);

		if (unitsFromDB != null) {
			ResponseEntity<String[]> response = new ResponseEntity<String[]>(unitsFromDB, HttpStatus.OK);
			return response;
		}

		String url = "http://api.nal.usda.gov/ndb/reports?format=json&api_key=sI0yVwgif7DGbueKoG3ZGeh4umIrt5unA3QWvDnY&q=b&ndbno=";
		url += ndbno;

		String jsonResponse = "";
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpGet request = new HttpGet(url.toString());
			HttpResponse result = httpClient.execute(request);

			jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

			Gson gson = new Gson();

			FoodItemDetailResponse usdaResponse = gson.fromJson(jsonResponse, FoodItemDetailResponse.class);

			String[] units = new String[0];

			// if no nutients come from usda api return and empty string array -
			// not a likely case
			if (usdaResponse.getReport().getFood().getNutrients().length > 0) {
				int unitsSize = usdaResponse.getReport().getFood().getNutrients()[0].getMeasures().length;
				units = new String[unitsSize];
				FoodItem[] foodByUnits = new FoodItem[unitsSize];

				for (int i = 0; i < unitsSize; i++) {
					String unit = usdaResponse.getReport().getFood().getNutrients()[0].getMeasures()[i].getLabel();
					units[i] = unit;

					// create the food item
					ndbno_itemUnit foodByUnitId = new ndbno_itemUnit();
					foodByUnitId.setNdbno(ndbno);
					foodByUnitId.setItemUnit(unit);
					FoodItem foodItem = new FoodItem();
					foodItem.setNdbno_unit(foodByUnitId);
					
					foodItem.setName(usdaResponse.getReport().getFood().getName());

					foodByUnits[i] = foodItem;
				}

				// for all units
				for (int i = 0; i < foodByUnits.length; i++) {
					// for all nutrients
					String currentUnit = foodByUnits[i].getNdbno_unit().getItemUnit();
					for (int j = 0; j < usdaResponse.getReport().getFood().getNutrients().length; j++) {
						Nutrient currentNutrient = usdaResponse.getReport().getFood().getNutrients()[j];

						for (int m = 0; m < currentNutrient.getMeasures().length; m++) {
							Measure currentMeasure = currentNutrient.getMeasures()[m];
							if (currentMeasure.getLabel().equalsIgnoreCase(currentUnit)) {
								switch (currentNutrient.getNutrient_id()) {
								case ("262"):
									foodByUnits[i].setCaffeine(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setCaffeineUnit(currentNutrient.getUnit());
									break;
								case ("301"):
									foodByUnits[i].setCalcium(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setCalciumUnit(currentNutrient.getUnit());
									break;
								case ("208"):
									foodByUnits[i].setCalorie(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setCalorieUnit(currentNutrient.getUnit());
									break;
								case ("205"):
									foodByUnits[i].setCarbohydrate(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setCarbohydrateUnit(currentNutrient.getUnit());
									break;
								case ("601"):
									foodByUnits[i].setCholesterol(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setCholesterolUnit(currentNutrient.getUnit());
									break;
								case ("204"):
									foodByUnits[i].setFat(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setFatUnit(currentNutrient.getUnit());
									break;
								case ("291"):
									foodByUnits[i].setFiber(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setFiberUnit(currentNutrient.getUnit());
									break;
								case ("303"):
									foodByUnits[i].setIron(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setIronUnit(currentNutrient.getUnit());
									break;
								case ("304"):
									foodByUnits[i].setMagnesium(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setMagnesiumUnit(currentNutrient.getUnit());
									break;
								case ("305"):
									foodByUnits[i].setPhosphorus(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setPhosphorusUnit(currentNutrient.getUnit());
									break;
								case ("306"):
									foodByUnits[i].setPotassium(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setPotassiumUnit(currentNutrient.getUnit());
									break;
								case ("203"):
									foodByUnits[i].setProtein(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setProteinUnit(currentNutrient.getUnit());
									break;
								case ("307"):
									foodByUnits[i].setSodium(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setSodiumUnit(currentNutrient.getUnit());
									break;
								case ("269"):
									foodByUnits[i].setSugars(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setSugarsUnit(currentNutrient.getUnit());
									break;
								case ("401"):
									foodByUnits[i].setVitaminC(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setVitaminCUnit(currentNutrient.getUnit());
									break;
								case ("255"):
									foodByUnits[i].setWater(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setWaterUnit(currentNutrient.getUnit());
									break;
								case ("309"):
									foodByUnits[i].setZinc(Double.valueOf(currentMeasure.getValue()));
									foodByUnits[i].setZincUnit(currentNutrient.getUnit());
									break;
								}
							}
						}
					}
				}

				foodConsumptionDao.persistFoodByUnits(foodByUnits);
			}

			ResponseEntity<String[]> response = new ResponseEntity<String[]>(units, HttpStatus.OK);

			return response;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// if there is an error return an empty array and HTTP 500
		String[] empty = new String[0];
		ResponseEntity<String[]> response = new ResponseEntity<String[]>(empty, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;

	}

	@RequestMapping(value = "/foodDetails/{ndbno}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ArrayList<FoodInfo>> getFoodDetailsWithUnit(
			@PathVariable(value = "ndbno") String ndbno,
			@RequestParam(value = "unit") String unit, @RequestParam(value = "amount") String amount) {
		FoodItem foodDetails = foodConsumptionDao.getFoodItem(ndbno, unit);

		amount = amount.replace(",", ".");
		foodDetails.adjustByAmount(Double.valueOf(amount));

		ArrayList<FoodInfo> foodInfos = new ArrayList<FoodInfo>();

		for (int i = 0; i < 17; i++) {
			FoodInfo foodInfo = new FoodInfo();

			switch (i) {
			case (3):
				if (foodDetails.getCaffeine() != null) {
					foodInfo.setName("Caffeine");
					foodInfo.setValue(foodDetails.getCaffeine());
					foodInfo.setUnit(foodDetails.getCaffeineUnit());
				}
				break;
			case (2):
				if (foodDetails.getCalcium() != null) {
					foodInfo.setName("Calcium");
					foodInfo.setValue(foodDetails.getCalcium());
					foodInfo.setUnit(foodDetails.getCalciumUnit());
				}
				break;
			case (0):
				if (foodDetails.getCalorie() != null) {
					foodInfo.setName("Calorie");
					foodInfo.setValue(foodDetails.getCalorie());
					foodInfo.setUnit(foodDetails.getCalorieUnit());
				}
				break;
			case (1):
				if (foodDetails.getCarbohydrate() != null) {
					foodInfo.setName("Carbohydrate");
					foodInfo.setValue(foodDetails.getCarbohydrate());
					foodInfo.setUnit(foodDetails.getCarbohydrateUnit());
				}
				break;
			case (4):
				if (foodDetails.getCholesterol() != null) {
					foodInfo.setName("Cholesterol");
					foodInfo.setValue(foodDetails.getCholesterol());
					foodInfo.setUnit(foodDetails.getCholesterolUnit());
				}
				break;
			case (5):
				if (foodDetails.getFat() != null) {
					foodInfo.setName("Fat");
					foodInfo.setValue(foodDetails.getFat());
					foodInfo.setUnit(foodDetails.getFatUnit());
				}
				break;
			case (6):
				if (foodDetails.getFiber() != null) {
					foodInfo.setName("Fiber");
					foodInfo.setValue(foodDetails.getFiber());
					foodInfo.setUnit(foodDetails.getFiberUnit());
				}
				break;
			case (7):
				if (foodDetails.getIron() != null) {
					foodInfo.setName("Iron");
					foodInfo.setValue(foodDetails.getIron());
					foodInfo.setUnit(foodDetails.getIronUnit());
				}
				break;
			case (8):
				if (foodDetails.getMagnesium() != null) {
					foodInfo.setName("Magnesium");
					foodInfo.setValue(foodDetails.getMagnesium());
					foodInfo.setUnit(foodDetails.getMagnesiumUnit());
				}
				break;
			case (9):
				if (foodDetails.getPhosphorus() != null) {
					foodInfo.setName("Phosphorus");
					foodInfo.setValue(foodDetails.getPhosphorus());
					foodInfo.setUnit(foodDetails.getPhosphorusUnit());
				}
				break;
			case (10):
				if (foodDetails.getPotassium() != null) {
					foodInfo.setName("Potassium");
					foodInfo.setValue(foodDetails.getPotassium());
					foodInfo.setUnit(foodDetails.getPotassiumUnit());
				}
				break;
			case (11):
				if (foodDetails.getProtein() != null) {
					foodInfo.setName("Protein");
					foodInfo.setValue(foodDetails.getProtein());
					foodInfo.setUnit(foodDetails.getProteinUnit());
				}
				break;
			case (12):
				if (foodDetails.getSodium() != null) {
					foodInfo.setName("Sodium");
					foodInfo.setValue(foodDetails.getSodium());
					foodInfo.setUnit(foodDetails.getSodiumUnit());
				}
				break;
			case (13):
				if (foodDetails.getSugars() != null) {
					foodInfo.setName("Sugars");
					foodInfo.setValue(foodDetails.getSugars());
					foodInfo.setUnit(foodDetails.getSugarsUnit());
				}
				break;
			case (14):
				if (foodDetails.getVitaminC() != null) {
					foodInfo.setName("VitaminC");
					foodInfo.setValue(foodDetails.getVitaminC());
					foodInfo.setUnit(foodDetails.getVitaminCUnit());
				}
				break;
			case (15):
				if (foodDetails.getWater() != null) {
					foodInfo.setName("Water");
					foodInfo.setValue(foodDetails.getWater());
					foodInfo.setUnit(foodDetails.getWaterUnit());
				}
				break;
			case (16):
				if (foodDetails.getZinc() != null) {
					foodInfo.setName("Zinc");
					foodInfo.setValue(foodDetails.getZinc());
					foodInfo.setUnit(foodDetails.getZincUnit());
				}
				break;
			}

			if(foodInfo.getName()!=null && foodInfo.getUnit()!=null && foodInfo.getValue()!=null){
				foodInfos.add(foodInfo);
			}	
		}

		ResponseEntity<ArrayList<FoodInfo>> response = new ResponseEntity<ArrayList<FoodInfo>>(foodInfos,
				HttpStatus.OK);
		return response;
	}
	
	/**
	 * This method is used for searching activity by activity type
	 * 
	 * @param activityType
	 *            is what the user inputs to search for an activity
	 * @return
	 */
	@RequestMapping(value = "/searchActivity", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ArrayList<Activity>> activitiesWithName(
			@RequestParam(value = "activityName") String activityName ) {
		
		ArrayList<Activity> activities = activityDao.getActivitiesWithNameLike(activityName);
		
		return new ResponseEntity<ArrayList<Activity>>(activities,
					HttpStatus.OK);
		
	}

}
