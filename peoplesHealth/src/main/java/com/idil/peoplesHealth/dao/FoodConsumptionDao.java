package com.idil.peoplesHealth.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
		
		consumptionKey.setItemAmount(foodConsumption.getAmount());
		
		consumptionKey.setDateTime(foodConsumption.getDate());
		
		User_FoodItem consumption = new User_FoodItem();
		consumption.setUserConsumptionKey(consumptionKey);
		
		sessionFactory.getCurrentSession().save(consumption);
	}
	
	
}
