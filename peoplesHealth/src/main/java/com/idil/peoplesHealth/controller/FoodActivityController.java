package com.idil.peoplesHealth.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idil.peoplesHealth.dao.ActivityDao;
import com.idil.peoplesHealth.dao.FoodConsumptionDao;
import com.idil.peoplesHealth.dao.UserDao;
import com.idil.peoplesHealth.domain.Activity;
import com.idil.peoplesHealth.domain.ActvityHistoryItem;
import com.idil.peoplesHealth.domain.CalorieHistory;
import com.idil.peoplesHealth.domain.CalorieInputOutput;
import com.idil.peoplesHealth.domain.FoodActivityHistory;
import com.idil.peoplesHealth.domain.FoodConsumption;
import com.idil.peoplesHealth.domain.FoodInfo;
import com.idil.peoplesHealth.domain.FoodItem;
import com.idil.peoplesHealth.domain.Message;
import com.idil.peoplesHealth.domain.User;
import com.idil.peoplesHealth.util.MailSender;

@Controller
public class FoodActivityController {

	@Autowired
	private FoodConsumptionDao foodConsumptionDao;

	@Autowired
	private ActivityDao activityDao;
	
	@Autowired
	private UserDao userDao;

	/**
	 * This method is used for adding food consumption of a user
	 * 
	 * @param foodConsumption
	 *            holds the data client side application has collected from the
	 *            user
	 * @return
	 */
	@RequestMapping(value = "/addFoodConsumption", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" })
	public @ResponseBody ResponseEntity<Message> createNewFoodConsumption(
			@RequestBody FoodConsumption foodConsumption) {

		try {
			foodConsumptionDao.addFoodConsumption(foodConsumption);
		}catch(DataIntegrityViolationException e){
			foodConsumptionDao.updateFoodConsumption(foodConsumption);
		} 
		catch (Exception e) {
			ResponseEntity<Message> response = new ResponseEntity<Message>(
					new Message("Couldn't add food item for user"), HttpStatus.BAD_REQUEST);
			return response;
		}

		ResponseEntity<Message> response = new ResponseEntity<Message>(new Message("Food Item Successfully Added"),
				HttpStatus.OK);
		return response;
	}

	/**
	 * This method is used for adding activity of a user
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/addActivity", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Message> addActivityForUser(@RequestParam(value = "email") String email,
			@RequestParam(value = "activityId") String activityId, @RequestParam(value = "date") String date,
			@RequestParam(value = "hours") String hours) {

		try {
			activityDao.addActivityForUser(activityId, email, date, hours);
		} 
		catch(DataIntegrityViolationException e){
			activityDao.updateActicityForUser(activityId, email, date, hours);
		}
		catch (Exception e) {
			ResponseEntity<Message> response = new ResponseEntity<Message>(
					new Message("Couldn't add activity for user"), HttpStatus.BAD_REQUEST);
			return response;
		}

		ResponseEntity<Message> response = new ResponseEntity<Message>(new Message("Activity Successfully Added"),
				HttpStatus.OK);
		return response;
	}

	/**
	 * This method is used for getting food consumption and activity of a user
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getFoodActivityHistory", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<FoodActivityHistory> getFoodActivityHistory(
			@RequestParam(value = "email") String email, @RequestParam(value = "date") String date) {

		FoodActivityHistory history = new FoodActivityHistory();

		ArrayList<FoodItem> foodConsumption = foodConsumptionDao.getFoodConsumptionForUserDate(email, date);

		ArrayList<ActvityHistoryItem> activities = activityDao.getActivityForUserDate(email, date);
		
		User user = userDao.getUserDetails(email);
		
		Double basalMetabolicRate;
		Integer age = 2017 - Integer.valueOf(user.getDateOfBirth().substring(0, 4));
		
		if(user.getGender().equalsIgnoreCase("F")){
			Integer weight = 65;
			Integer height = 155;
			
			if(user.getWeight()!=null){
				weight = user.getWeight();
			}
			if(user.getHeight()!=null){
				height = user.getHeight();
			}
			
			basalMetabolicRate = 10 * weight + 6.25 * height - 5 * age - 161;
		}
		else{
			Integer weight = 85;
			Integer height = 175;
			
			if(user.getWeight()!=null){
				weight = user.getWeight();
			}
			if(user.getHeight()!=null){
				height = user.getHeight();
			}
			
			basalMetabolicRate = 10 * weight + 6.25 * height - 5 * age + 5;
		}
		
		ActvityHistoryItem basalMetabolism = new ActvityHistoryItem();
		basalMetabolism.setActivityName("Basal Metabolism");
		basalMetabolism.setCalorieBurn(basalMetabolicRate);
		basalMetabolism.setHours(24.0);
		
		activities.add(basalMetabolism);

		Double calorieConsumed = 0.0;

		Double calorieBurned = 0.0;

		for (int i = 0; i < foodConsumption.size(); i++) {
			foodConsumption.get(i).adjustByAmount(foodConsumption.get(i).getAmount());
			calorieConsumed += foodConsumption.get(i).getCalorie();
		}

		for (int i = 0; i < activities.size(); i++) {
			calorieBurned += activities.get(i).getCalorieBurn();
		}

		history.setActivityHistory(activities);
		history.setFoodConsumptionHistory(foodConsumption);
		history.setTotalCalorieBurn(calorieBurned);
		history.setTotalCalorieConsumption(calorieConsumed);

		ResponseEntity<FoodActivityHistory> response = new ResponseEntity<FoodActivityHistory>(history, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/getCalorieInputOutputHistory", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<CalorieInputOutput> getCalorieInputOutputHistory(
			@RequestParam(value = "email") String email) {
		
		ArrayList<CalorieHistory> calorieConsumptionHistory = foodConsumptionDao.getFoodConsumptionForUserDate(email);

		ArrayList<CalorieHistory> calorieBurnHistory = activityDao.getActivityForUserDate(email);
		
		CalorieInputOutput cio = new CalorieInputOutput();
		cio.setCalorieInput(calorieConsumptionHistory);
		cio.setCalorieOutput(calorieBurnHistory);
		
		ResponseEntity<CalorieInputOutput> response = new ResponseEntity<CalorieInputOutput>(cio, HttpStatus.OK);
		return response;

	}
}
