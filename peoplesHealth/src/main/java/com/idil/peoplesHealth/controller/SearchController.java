package com.idil.peoplesHealth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {

	@RequestMapping(value = "/searchFood" , method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> searchFood(){
		ResponseEntity<String> response = new ResponseEntity<String>("ok", HttpStatus.OK);

		return response;
		
	}
}
