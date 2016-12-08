package com.idil.peoplesHealth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idil.peoplesHealth.dao.FoodConsumptionDao;
import com.idil.peoplesHealth.domain.FoodConsumption;
import com.idil.peoplesHealth.domain.Message;
import com.idil.peoplesHealth.domain.User;
import com.idil.peoplesHealth.util.MailSender;

@Controller
public class FoodActivityController {

	@Autowired
	private FoodConsumptionDao foodConsumptionDao;
	
	/**
	 * This method is used for adding food consumption of a user
	 * @param foodConsumption holds the data client side application has collected from the user
	 * @return
	 */
	@RequestMapping(value = "/addFoodConsumption" , method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"})
	public @ResponseBody ResponseEntity<Message> createNewFoodConsumption(@RequestBody FoodConsumption foodConsumption){

		try{
			foodConsumptionDao.addFoodConsumption(foodConsumption);
		}
		catch(Exception e){
			ResponseEntity<Message> response = new ResponseEntity<Message>(new Message("Couldn't add food item for user"), HttpStatus.BAD_REQUEST);
			return response;
		}
		
		ResponseEntity<Message> response = new ResponseEntity<Message>(new Message("Food Item Successfully Added"), HttpStatus.OK);
		return response;
	}
}
