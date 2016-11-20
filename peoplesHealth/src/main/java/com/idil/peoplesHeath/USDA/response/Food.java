package com.idil.peoplesHeath.USDA.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Food {
	
	@JsonProperty("ndbno")
	private String ndbno;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("nutrients")
	private Nutrient[] nutrients;

	public String getNdbno() {
		return ndbno;
	}

	public void setNdbno(String ndbno) {
		this.ndbno = ndbno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Nutrient[] getNutrients() {
		return nutrients;
	}

	public void setNutrients(Nutrient[] nutrients) {
		this.nutrients = nutrients;
	}
	
	

}
