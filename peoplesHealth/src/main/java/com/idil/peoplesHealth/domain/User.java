package com.idil.peoplesHealth.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "poeplesHealth.USER")
public class User {

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("gender")
	private String gender;
	
	// will use yyyyMMdd as format 
	@JsonProperty("dateOfBirth")
	private String dateOfBirth;
	
	@JsonProperty("height")
	private Integer height;
	
	@JsonProperty("weight")
	private Integer weight;
	
	@JsonProperty("notes")
	private String notes;
	
	@JsonProperty("name")
	private String name;
	
	@JsonIgnore
	private Set<User_FoodItem> foodConsumptionList = new HashSet<User_FoodItem>();
	
	@JsonIgnore
	private Set<User_Activity> activityList = new HashSet<User_Activity>();

	@Id
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "birthDate")
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "height")
	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	@Column(name = "weight")
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Column(name = "notes")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "userConsumptionKey.user")
	public Set<User_FoodItem> getFoodConsumptionList() {
		return foodConsumptionList;
	}

	public void setFoodConsumptionList(Set<User_FoodItem> foodConsumptionList) {
		this.foodConsumptionList = foodConsumptionList;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "userActivityKey.user")
	public Set<User_Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(Set<User_Activity> activityList) {
		this.activityList = activityList;
	}
	
	
}
