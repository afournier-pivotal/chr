package com.lukeshannon.springconference.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
	
	@Id
	private Long id;
	private int score;
	private String comment;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Session getSession() {
		return session;
	}
	

	public void setSession(Session session) {
		this.session = session;
	}
	
	

}
