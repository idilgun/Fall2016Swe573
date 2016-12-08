package com.idil.peoplesHealth.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "poeplesHealth.ACTIVITY")
public class Activity {

	private Integer activityId;
	
	private String activityName;
	
	private String activityType;
	
	private Integer cal_hour_58kg;
	
	private Integer cal_hour_70kg;
	
	private Integer cal_hour_81kg;
	
	private Integer cal_hour_92kg;
	
	@JsonIgnore
	private Set<User_Activity> userActivityList = new HashSet<User_Activity>();

	@Id
	@Column(name = "activityId")
	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	@Column(name = "activityName")
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Column(name = "activityType")
	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	@Column(name = "cal_hour_58kg")
	public Integer getCal_hour_58kg() {
		return cal_hour_58kg;
	}

	public void setCal_hour_58kg(Integer cal_hour_58kg) {
		this.cal_hour_58kg = cal_hour_58kg;
	}

	@Column(name = "cal_hour_70kg")
	public Integer getCal_hour_70kg() {
		return cal_hour_70kg;
	}

	public void setCal_hour_70kg(Integer cal_hour_70kg) {
		this.cal_hour_70kg = cal_hour_70kg;
	}

	@Column(name = "cal_hour_81kg")
	public Integer getCal_hour_81kg() {
		return cal_hour_81kg;
	}

	public void setCal_hour_81kg(Integer cal_hour_81kg) {
		this.cal_hour_81kg = cal_hour_81kg;
	}

	@Column(name = "cal_hour_92kg")
	public Integer getCal_hour_92kg() {
		return cal_hour_92kg;
	}

	public void setCal_hour_92kg(Integer cal_hour_92kg) {
		this.cal_hour_92kg = cal_hour_92kg;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "userActivityKey.activity")
	public Set<User_Activity> getUserActivityList() {
		return userActivityList;
	}

	public void setUserActivityList(Set<User_Activity> userActivityList) {
		this.userActivityList = userActivityList;
	}
	
	
}
