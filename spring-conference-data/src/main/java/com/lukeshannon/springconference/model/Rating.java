package com.lukeshannon.springconference.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Rating(int score, String token, Session session) {
		super();
		this.score = score;
		this.token = token;
		this.session = session;
	}
	
	public Rating() {}
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int score;
	
	private String token;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Session session;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Session getSession() {
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
	
}
