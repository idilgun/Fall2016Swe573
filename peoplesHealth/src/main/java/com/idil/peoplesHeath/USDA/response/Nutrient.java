package com.idil.peoplesHeath.USDA.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Nutrient {

	@JsonProperty("nutrient_id")
	private String nutrient_id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("group")
	private String group;
	
	@JsonProperty("unit")
	private String unit;
	
	@JsonProperty("measures")
	private Measure[] measures;

	public String getNutrient_id() {
		return nutrient_id;
	}

	public void setNutrient_id(String nutrient_id) {
		this.nutrient_id = nutrient_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Measure[] getMeasures() {
		return measures;
	}

	public void setMeasures(Measure[] measures) {
		this.measures = measures;
	}
	
	
}
