package com.idil.peoplesHealth.util;

import java.util.ArrayList;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.idil.peoplesHeath.USDA.response.Item;
import com.idil.peoplesHeath.USDA.response.SearchByNameResponse;

public class USDAResponseUtil {

	public static void filterFoodsByGroup(SearchByNameResponse response, final String group){
		
		if(response.getList()==null){
			return;
		}
		
		ArrayList<Item> foods = response.getList().getItems();
		
		Predicate<Item> isDesiredGroup = new Predicate<Item>() {
	        @Override public boolean apply(Item food) {
	            return (food.getGroup().equalsIgnoreCase(group));
	        }               
	    };
	    
	    ArrayList<Item> desiredFoods = new ArrayList<Item>(Collections2.filter(foods, isDesiredGroup));
	    
	    response.getList().setItems(desiredFoods);
	}
	
}
