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
import com.idil.peoplesHealth.domain.Message;
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
	@RequestMapping(value = "/newUser" , method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"}, produces={"tetx/html"})
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
	 * This method is used for updating user details - This is only used for existing users
	 * @param userDetail holds the data client side application has collected from the user
	 * @return
	 */
	@RequestMapping(value = "/updateUserInformation" , method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<User> updateUser(@RequestBody User userDetail){

		
		if(userDao.updateUser(userDetail)){
			ResponseEntity<User> response = new ResponseEntity<User>(userDetail, HttpStatus.OK);
			return response;
		}
		else{
			ResponseEntity<User> response = new ResponseEntity<User>(userDetail, HttpStatus.BAD_REQUEST);
			return response;
		}
		
		
	}
	
	/**
	 * This method is used for user forgot password, a mail with login details will be forwarded 
	 * @param email holds the user's email who forgot password
	 * @return
	 */
	@RequestMapping(value = "/forgotPassword" , method = RequestMethod.GET)
	public ResponseEntity<Message> sendPasswordMail(@RequestParam String email){
		
		try{
			User user = userDao.getUserDetails(email);
			
			if(user == null){
				ResponseEntity<Message> response = new ResponseEntity<Message>(new Message("This email is not registered to People's Health"), HttpStatus.BAD_REQUEST);
				return response;
			}
			
			MailSender ms = new MailSender();
			
			try {
				ms.sendForgottenPasswordMailTo(user, javaMailSender);
				ResponseEntity<Message> response = new ResponseEntity<Message>(new Message("Your password has been sent to your mail"), HttpStatus.OK);
				return response;
			} catch (MessagingException e) {
				ResponseEntity<Message> response = new ResponseEntity<Message>(new Message("Please try again"), HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
				return response;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Message>(new Message("Please try again"), HttpStatus.UNAUTHORIZED);
		}
		
	}
	
	/**
	 * This method is used for user authorization -password user inputs is compared with the password we have in database
	 * @param email is user's unique identifier
	 * @param password is user's password
	 * @return
	 */
	@RequestMapping(value = "/authorizeUser" , method = RequestMethod.GET)
	public ResponseEntity<User> authorizeUser(@RequestParam String email, @RequestParam String password){
		
		User user = userDao.getUserDetails(email);
		
		if(user == null){
			ResponseEntity<User> response = new ResponseEntity<User>(new User(), HttpStatus.BAD_REQUEST);
			return response;
		}
		if(user.getPassword().equals(password)){
			ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.OK);
			return response;
		}
		else{
			ResponseEntity<User> response = new ResponseEntity<User>(new User(), HttpStatus.UNAUTHORIZED);
			return response;
		}
		
	}
	
}
