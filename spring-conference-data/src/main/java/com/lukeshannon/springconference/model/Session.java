package com.lukeshannon.springconference.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NaturalId;

@Entity
public class Session implements Serializable {

	private static final long serialVersionUID = -8037868603663337495L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToOne(optional = false)
	@NaturalId
	private List<Speaker> speakers;
	
	@ManyToOne(optional = false)
	@NaturalId
	private List<Rating> ratings;
	
	private Date startTime;
	
	private Date endTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Speaker> getSpeakers() {
		return speakers;
	}
	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "session")
	public List<Rating> getRatings() {
		return ratings;
	}
	
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
}
