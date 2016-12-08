package com.idil.peoplesHealth.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodConsumption {
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("ndbno")
	private String ndbno;
	
	@JsonProperty("itemUnit")
	private String itemUnit;
	
	@JsonProperty("amount")
	private String amount;
	
	@JsonProperty("date")
	private String date;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNdbno() {
		return ndbno;
	}

	public void setNdbno(String ndbno) {
		this.ndbno = ndbno;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
