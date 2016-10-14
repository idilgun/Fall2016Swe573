package com.idil.peoplesHeath.USDA.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class List {
	
	@JsonProperty("q")
	private String q;
	
	@JsonProperty("item")
	private ArrayList<Item> item;
	
	public ArrayList<Item> getItems() {
		return item;
	}

	public void setItems(ArrayList<Item> items) {
		this.item = items;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	
	
	
}
