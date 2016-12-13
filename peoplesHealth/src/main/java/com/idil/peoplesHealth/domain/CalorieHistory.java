package com.idil.peoplesHealth.domain;

import java.util.Date;

public class CalorieHistory {

	private Date dateTime;
	private Double calorieValue;
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Double getCalorieValue() {
		return calorieValue;
	}
	public void setCalorieValue(Double calorieValue) {
		this.calorieValue = calorieValue;
	}
	
	
	
}
