package com.lukeshannon.springconference.service;

import org.springframework.stereotype.Service;

import com.lukeshannon.springconference.repo.SessionRepo;

@Service
public class RatingService {

	private SessionRepo sessionRepo;

	public RatingService(SessionRepo sessionRepo) {
		this.sessionRepo = sessionRepo;
	}
	
}
