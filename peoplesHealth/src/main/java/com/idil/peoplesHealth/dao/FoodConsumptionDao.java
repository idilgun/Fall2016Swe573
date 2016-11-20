package com.idil.peoplesHealth.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idil.peoplesHealth.domain.FoodItem;
import com.idil.peoplesHealth.domain.FoodItem.ndbno_itemUnit;
import com.idil.peoplesHealth.domain.User;

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
	
	
}
