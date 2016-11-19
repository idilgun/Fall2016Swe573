package com.idil.peoplesHealth.controller;

import javax.mail.MessagingException;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.idil.peoplesHealth.dao.UserDao;
import com.idil.peoplesHealth.dao.UserDao;
import com.idil.peoplesHealth.domain.User;
import com.idil.peoplesHealth.util.MailSender;
import com.idil.peoplesHeath.USDA.response.SearchByNameResponse;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	/**
	 * This method is used for user sign up
	 * @param userDetail holds the data client side application has collected from the user
	 * @return
	 */
	@RequestMapping(value = "/newUser" , method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> createNewUser(@RequestBody User userDetail){

		try{
			userDao.createNewUser(userDetail);
		}
		catch(Exception e){
			ResponseEntity<String> response = new ResponseEntity<String>("User Already Exists", HttpStatus.BAD_REQUEST);
			return response;
		}
		
		
		ResponseEntity<String> response = new ResponseEntity<String>("User Successfully Added", HttpStatus.OK);
		return response;
	}
	
	/**
	 * This method is used for updating user details
	 * @param userDetail holds the data client side application has collected from the user
	 * This is only used for existing users
	 * @return
	 */
	@RequestMapping(value = "/updateUserInformation" , method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> updateUser(@RequestBody User userDetail){

		
		if(userDao.updateUser(userDetail)){
			ResponseEntity<String> response = new ResponseEntity<String>("User Updated", HttpStatus.OK);
			return response;
		}
		else{
			ResponseEntity<String> response = new ResponseEntity<String>("User Doesn't Exist", HttpStatus.BAD_REQUEST);
			return response;
		}
		
		
	}
	
	/**
	 * This method is used for user forgot password
	 * @param email holds the user's email who forgot password, 
	 * a mail with login details will be forwarded 
	 * @return
	 */
	@RequestMapping(value = "/forgotPassword" , method = RequestMethod.GET)
	public ResponseEntity<String> searchFood(@RequestParam String email){
		
		User user = userDao.getUserDetails(email);
		
		if(user == null){
			ResponseEntity<String> response = new ResponseEntity<String>("user doesn't exist", HttpStatus.BAD_REQUEST);
			return response;
		}
		
		MailSender ms = new MailSender();
		
		try {
			ms.sendForgottenPasswordMailTo(user, javaMailSender);
			ResponseEntity<String> response = new ResponseEntity<String>("mail sent", HttpStatus.OK);
			return response;
		} catch (MessagingException e) {
			ResponseEntity<String> response = new ResponseEntity<String>("try again", HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}
}
