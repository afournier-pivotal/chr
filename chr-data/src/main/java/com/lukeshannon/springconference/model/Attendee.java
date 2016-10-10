/**
 * 
 */
package com.lukeshannon.springconference.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author lshannon
 *
 */
@Entity
public class Attendee implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String company;
	
	public Attendee() {}
	
	public Attendee(String email, String company) {
		super();
		this.email = email;
		this.company = company;
	}
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
	
	
	
	

}
