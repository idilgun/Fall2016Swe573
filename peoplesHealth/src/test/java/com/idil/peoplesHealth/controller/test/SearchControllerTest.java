package com.idil.peoplesHealth.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;


import com.idil.peoplesHealth.controller.SearchController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class SearchControllerTest {

	@Autowired
	SearchController searchController;
	
	@Test
	public void testSearchFood() {
		assertEquals(HttpStatus.OK, searchController.searchFood("apple", "Fruits and Fruit Juices").getStatusCode());
		assertNotNull(searchController.searchFood("apple", "Fruits and Fruit Juices").getBody());
		
		assertEquals(HttpStatus.NO_CONTENT, searchController.searchFood("appdehwujasnle", "Fruits and Fruit Juices").getStatusCode());
	}
	
	@Test
	public void testFoodItemUnits() {
		assertEquals(HttpStatus.OK, searchController.getFoodItemDetails("01132").getStatusCode());
		assertNotNull(searchController.getFoodItemDetails("01132").getBody());
		assertEquals(3, searchController.getFoodItemDetails("01132").getBody().length);
	}
	
	@Test
	public void testFoodItemDetails() {
		assertEquals(HttpStatus.OK, searchController.getFoodDetailsWithUnit("01132", "cup", "1").getStatusCode());
		assertNotNull(searchController.getFoodDetailsWithUnit("01132", "cup", "1").getBody());
		assertEquals("Calorie", searchController.getFoodDetailsWithUnit("01132", "cup", "1").getBody().get(0).getName());
		assertEquals(Double.valueOf(328), searchController.getFoodDetailsWithUnit("01132", "cup", "1").getBody().get(0).getValue());

	}
	
	

}
