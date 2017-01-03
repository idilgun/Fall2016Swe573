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
@Table(name = "poeplesHealth.USER_ACTIVITY")
@AssociationOverrides({
	@AssociationOverride(name = "userActivityKey.activity",
		joinColumns = { @JoinColumn(name = "activityId")}),
	@AssociationOverride(name = "userActivityKey.user",
		joinColumns = @JoinColumn(name = "email")) })
public class User_Activity {
	
	@Embeddable
	public static class User_ActivityPK implements Serializable {
				
	    private User user;

	    private Activity activity;
	    
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
		public Activity getActivity() {
			return activity;
		}

		public void setActivity(Activity activity) {
			this.activity = activity;
		}

		public String getDateTime() {
			return dateTime;
		}

		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}

	}
	
	private User_ActivityPK userActivityKey;
	
    private Double hours;
	
	@EmbeddedId
	public User_ActivityPK getUserActivityKey() {
		return userActivityKey;
	}

	public void setUserActivityKey(User_ActivityPK userActivityKey) {
		this.userActivityKey = userActivityKey;
	}
	@Column(name = "hours")
	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}
	
	

}
