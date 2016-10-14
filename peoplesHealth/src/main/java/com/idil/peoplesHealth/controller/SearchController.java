package com.idil.peoplesHealth.controller;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.idil.peoplesHealth.util.USDAResponseUtil;
import com.idil.peoplesHeath.USDA.response.Item;
import com.idil.peoplesHeath.USDA.response.List;
import com.idil.peoplesHeath.USDA.response.SearchByNameResponse;

@Controller
public class SearchController {

	@RequestMapping(value = "/searchFood/{searchString}/{group}" , method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<SearchByNameResponse> searchFood(@PathVariable(value="searchString") String searchString,
														   @PathVariable(value="group") String group){

		String url = "http://api.nal.usda.gov/ndb/search?format=json&api_key=sI0yVwgif7DGbueKoG3ZGeh4umIrt5unA3QWvDnY&q=";
		url+=searchString;
		url+="&ds=Standard%20Reference&sort=n";

		String jsonResponse = "";
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			    HttpGet request = new HttpGet(url.toString());
			    HttpResponse result = httpClient.execute(request);

			    jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");
			    
			    Gson gson = new Gson();
			    			    
			    SearchByNameResponse usdaResponse = gson.fromJson(jsonResponse, SearchByNameResponse.class);
			    
			    USDAResponseUtil.filterFoodsByGroup(usdaResponse, group);
			    
			    ResponseEntity<SearchByNameResponse> response = new ResponseEntity<SearchByNameResponse>(usdaResponse, HttpStatus.OK);
			    
			    return response;
			    
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		SearchByNameResponse emptyResponse = new SearchByNameResponse();
	    ResponseEntity<SearchByNameResponse> response = new ResponseEntity<SearchByNameResponse>(emptyResponse, HttpStatus.NO_CONTENT);
		return response;
		
	}
}
