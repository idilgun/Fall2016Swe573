package com.idil.peoplesHealth.controller;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.idil.peoplesHealth.dao.UserDao;
import com.idil.peoplesHealth.dao.UserDao;
import com.idil.peoplesHealth.domain.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * This method is used for user sign up
	 * @param userDetail holds the data client side application has collected from the user
	 * @return
	 */
	@RequestMapping(value = "/newUser" , method = RequestMethod.POST)
	public @ResponseBody User createNewUser(@RequestBody User userDetail){
		userDetail.getDateOfBirth();
		userDao.createNewUser(userDetail);
		
		return userDetail;
	}
}
