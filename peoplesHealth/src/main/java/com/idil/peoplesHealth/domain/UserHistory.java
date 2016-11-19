package com.idil.peoplesHealth.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "poeplesHealth.USER_HISTORY")
public class UserHistory {
	
	@Embeddable
	public static class email_dateTimeId implements Serializable {
		@Column(name="email")
	    private String email;

	    @Column(name="dateTime", columnDefinition="DATETIME")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date dateTime;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getDateTime() {
			return dateTime;
		}

		public void setDateTime(Date dateTime) {
			this.dateTime = dateTime;
		}
	    
	    

	}
	
	@EmbeddedId
	email_dateTimeId id;
	
	@Column(name = "height")
	private Integer height;
	
	@Column(name = "weight")
	private Integer weight;
	
	@Column(name = "notes")
	private String notes;

	

	public email_dateTimeId getId() {
		return id;
	}

	public void setId(email_dateTimeId id) {
		this.id = id;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
