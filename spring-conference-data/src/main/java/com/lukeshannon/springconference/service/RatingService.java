package com.lukeshannon.springconference.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lukeshannon.springconference.model.Rating;
import com.lukeshannon.springconference.model.Session;
import com.lukeshannon.springconference.repo.SessionRepo;

@Service
public class RatingService {

	private SessionRepo sessionRepo;

	public RatingService(SessionRepo sessionRepo) {
		this.sessionRepo = sessionRepo;
	}
	
	public List<Rating> getRatings(Long sessionId) {
		Session session =sessionRepo.findOne(sessionId);
		return session.getRatings();
	}
	
	public Session setRating(String token, int score, Long sessionId) {
		//get the session
		Session session = sessionRepo.findOne(sessionId);
		//create the rating
		Rating rating = new Rating(score,token,session);
		//add rating to the session
		session.getRatings().add(rating);
		return sessionRepo.save(session);
	}
	
}
