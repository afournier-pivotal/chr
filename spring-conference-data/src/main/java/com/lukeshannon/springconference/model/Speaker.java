/**
 * 
 */
package com.lukeshannon.springconference.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author lshannon
 *
 */
@Entity
public class Speaker {
	
	@Id
	private Long id;
	private String name;
	private String twitter;
	private String website;
	private List<Session> sessions;
	
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
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public List<Session> getSessions() {
		return sessions;
	}
	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	

}
