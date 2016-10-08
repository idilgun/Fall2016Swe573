package com.idil.peoplesHealth.controller;

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
import com.idil.peoplesHeath.USDA.response.List;

@Controller
public class SearchController {

	@RequestMapping(value = "/searchFood/{searchString}" , method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> searchFood(@PathVariable(value="searchString") String searchString){
		ResponseEntity<String> response = new ResponseEntity<String>("ok", HttpStatus.OK);

		String url = "http://api.nal.usda.gov/ndb/search?format=json&api_key=sI0yVwgif7DGbueKoG3ZGeh4umIrt5unA3QWvDnY&q=";
		url+=searchString;
		url+="&ds=Standard%20Reference&sort=n";

		String jsonResponse = "";
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			    HttpGet request = new HttpGet(url.toString());
			    HttpResponse result = httpClient.execute(request);

			    jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");
			    
			    Gson gson = new Gson();
			    
			    List usdaResponse = gson.fromJson(jsonResponse, List.class);
			    
			    usdaResponse.getItems();
			    
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return response;
		
	}
}
