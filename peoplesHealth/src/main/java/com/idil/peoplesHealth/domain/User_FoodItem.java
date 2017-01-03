package com.idil.peoplesHealth.domain;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "poeplesHealth.USER_CONSUMPTION")
@AssociationOverrides({
	@AssociationOverride(name = "userConsumptionKey.foodItem",
		joinColumns = { @JoinColumn(name = "itemUnit"), @JoinColumn(name = "ndbno")}),
	@AssociationOverride(name = "userConsumptionKey.user",
		joinColumns = @JoinColumn(name = "email")) })

public class User_FoodItem {
	
	@Embeddable
	public static class User_FoodItemPK implements Serializable {
				
	    private User user;

	    private FoodItem foodItem;
	    
	    @Column(name = "dateTime")
	    private String dateTime;

	    @ManyToOne
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@ManyToOne
		public FoodItem getFoodItem() {
			return foodItem;
		}

		public void setFoodItem(FoodItem foodItem) {
			this.foodItem = foodItem;
		}

		public String getDateTime() {
			return dateTime;
		}

		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}
	}
	
	private User_FoodItemPK userConsumptionKey;
	
	private Double itemAmount;
	
	@EmbeddedId
	public User_FoodItemPK getUserConsumptionKey() {
		return userConsumptionKey;
	}

	public void setUserConsumptionKey(User_FoodItemPK userConsumptionKey) {
		this.userConsumptionKey = userConsumptionKey;
	}
	
	@Column(name = "itemAmount")
	public Double getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(Double itemAmount) {
		this.itemAmount = itemAmount;
	}
}
