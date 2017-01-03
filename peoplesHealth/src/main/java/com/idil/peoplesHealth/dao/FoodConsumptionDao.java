package com.idil.peoplesHealth.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idil.peoplesHealth.domain.Activity;
import com.idil.peoplesHealth.domain.CalorieHistory;
import com.idil.peoplesHealth.domain.FoodConsumption;
import com.idil.peoplesHealth.domain.FoodItem;
import com.idil.peoplesHealth.domain.FoodItem.ndbno_itemUnit;
import com.idil.peoplesHealth.domain.User;
import com.idil.peoplesHealth.domain.User_FoodItem;
import com.idil.peoplesHealth.domain.User_FoodItem.User_FoodItemPK;

@Component
public class FoodConsumptionDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void persistFoodByUnits(FoodItem[] foodByUnits) {
		
		for(int i=0; i<foodByUnits.length; i++){
			sessionFactory.getCurrentSession().save(foodByUnits[i]);
		}
		
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public String[] getUnitsOfItem(String ndbno) {
		String sql = "SELECT * FROM poeplesHealth.ITEM where ndbno = " + ndbno;

		List<FoodItem> items = (List<FoodItem>)sessionFactory.getCurrentSession()
				.createSQLQuery(sql).addEntity(FoodItem.class).list();
		
		if(items == null || items.size()==0){
			return null;
		}
		
		String [] units = new String[items.size()];
		for(int i=0; i<items.size(); i++){
			units[i] = items.get(i).getNdbno_unit().getItemUnit();
		}
		
		return units;
	}

	@Transactional
	public FoodItem getFoodItem(String ndbno, String unit) {
		
		ndbno_itemUnit id = new ndbno_itemUnit();
		id.setItemUnit(unit);
		id.setNdbno(ndbno);
		
		FoodItem foodItem = (FoodItem) sessionFactory.getCurrentSession().get(FoodItem.class, id);
		return foodItem;

	}
	
	@Transactional
	public void addFoodConsumption(FoodConsumption foodConsumption) {
		
		ndbno_itemUnit id = new ndbno_itemUnit();
		id.setItemUnit(foodConsumption.getItemUnit());
		id.setNdbno(foodConsumption.getNdbno());
		
		FoodItem foodItem = (FoodItem) sessionFactory.getCurrentSession().get(FoodItem.class, id);
		
		User user = (User) sessionFactory.getCurrentSession().get(User.class, foodConsumption.getEmail());
		
		User_FoodItemPK consumptionKey = new User_FoodItemPK();
		
		consumptionKey.setUser(user);
		
		consumptionKey.setFoodItem(foodItem);
		
		consumptionKey.setDateTime(foodConsumption.getDate());
		
		User_FoodItem consumption = new User_FoodItem();
		consumption.setUserConsumptionKey(consumptionKey);
		consumption.setItemAmount(Double.valueOf(foodConsumption.getAmount().replace(",", ".")));
		
		sessionFactory.getCurrentSession().save(consumption);
	}

	@Transactional
	public ArrayList<FoodItem> getFoodConsumptionForUserDate(String email, String date) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User_FoodItem.class,
				"userFoodConsumption");
		criteria.add(Restrictions.eq("userFoodConsumption.userConsumptionKey.user.email", email));
		criteria.add(Restrictions.eq("userFoodConsumption.userConsumptionKey.dateTime", date));

		List<User_FoodItem> userConsumptionList = criteria.list();

		 ArrayList<FoodItem> foodList = new  ArrayList<FoodItem>();
		 
		 for(int i=0; i<userConsumptionList.size(); i++){
			 FoodItem foodItem = userConsumptionList.get(i).getUserConsumptionKey().getFoodItem();
			 foodItem.setAmount(userConsumptionList.get(i).getItemAmount());
			 foodItem.setUnit(userConsumptionList.get(i).getUserConsumptionKey().getFoodItem().getNdbno_unit().getItemUnit());
			 foodList.add(foodItem);
		 }
		 	
		return foodList;
	}

	@Transactional
	public ArrayList<CalorieHistory> getFoodConsumptionForUserDate(String email) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User_FoodItem.class,
				"userFoodConsumption");
		criteria.add(Restrictions.eq("userFoodConsumption.userConsumptionKey.user.email", email));		
		
		List<User_FoodItem> userConsumptionList = criteria.list();

		 ArrayList<CalorieHistory> calorieConsumptionHistory = new  ArrayList<CalorieHistory>();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		 
		 for(int i=0; i<userConsumptionList.size(); i++){
			 Date dateTime;
			try {
				dateTime = formatter.parse(userConsumptionList.get(i).getUserConsumptionKey().getDateTime());
//				CalorieHistory ch = new CalorieHistory();
//				 ch.setDateTime(dateTime);
//				 FoodItem foodItem = userConsumptionList.get(i).getUserConsumptionKey().getFoodItem();
//				 foodItem.setAmount(userConsumptionList.get(i).getUserConsumptionKey().getItemAmount());
//				 foodItem.setUnit(userConsumptionList.get(i).getUserConsumptionKey().getFoodItem().getNdbno_unit().getItemUnit());
//				 foodItem.adjustByAmount(foodItem.getAmount());
//				 ch.setCalorieValue(foodItem.getCalorie());
//				 calorieConsumptionHistory.add(ch);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
		 }
		return calorieConsumptionHistory;
		
	}

	@Transactional
	public void updateFoodConsumption(FoodConsumption foodConsumption) {
		
		ndbno_itemUnit id = new ndbno_itemUnit();
		id.setItemUnit(foodConsumption.getItemUnit());
		id.setNdbno(foodConsumption.getNdbno());
		
		FoodItem foodItem = (FoodItem) sessionFactory.getCurrentSession().get(FoodItem.class, id);
		
		User user = (User) sessionFactory.getCurrentSession().get(User.class, foodConsumption.getEmail());
		
		User_FoodItemPK consumptionKey = new User_FoodItemPK();
		
		consumptionKey.setUser(user);
		
		consumptionKey.setFoodItem(foodItem);
		
		consumptionKey.setDateTime(foodConsumption.getDate());
		
		User_FoodItem consumption = (User_FoodItem)sessionFactory.getCurrentSession().get(User_FoodItem.class, consumptionKey);
		consumption.setItemAmount(consumption.getItemAmount() + Double.valueOf(foodConsumption.getAmount().replace(",", ".")));
		
		sessionFactory.getCurrentSession().update(consumption);
		
	}
	
	
}
