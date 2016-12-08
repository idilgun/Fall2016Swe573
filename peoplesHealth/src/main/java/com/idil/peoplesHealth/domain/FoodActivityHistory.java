package com.idil.peoplesHealth.domain;

import java.util.List;

public class FoodActivityHistory {

	private List<FoodItem> foodConsumptionHistory;
	
	private List<ActvityHistoryItem> activityHistory;
	
	private Double totalCalorieConsumption;
	
	private Double totalCalorieBurn;

	public List<FoodItem> getFoodConsumptionHistory() {
		return foodConsumptionHistory;
	}

	public void setFoodConsumptionHistory(List<FoodItem> foodConsumptionHistory) {
		this.foodConsumptionHistory = foodConsumptionHistory;
	}

	public List<ActvityHistoryItem> getActivityHistory() {
		return activityHistory;
	}

	public void setActivityHistory(List<ActvityHistoryItem> activityHistory) {
		this.activityHistory = activityHistory;
	}

	public Double getTotalCalorieConsumption() {
		return totalCalorieConsumption;
	}

	public void setTotalCalorieConsumption(Double totalCalorieConsumption) {
		this.totalCalorieConsumption = totalCalorieConsumption;
	}

	public Double getTotalCalorieBurn() {
		return totalCalorieBurn;
	}

	public void setTotalCalorieBurn(Double totalCalorieBurn) {
		this.totalCalorieBurn = totalCalorieBurn;
	}
	
	
	
	
}
