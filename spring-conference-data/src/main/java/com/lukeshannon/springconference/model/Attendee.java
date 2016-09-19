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
public class Attendee {
	
	@Id
	private Long id;
	private String email;
	private String company;
	private List<Session> sessions;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public List<Session> getSessions() {
		return sessions;
	}
	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	
	
	

}
