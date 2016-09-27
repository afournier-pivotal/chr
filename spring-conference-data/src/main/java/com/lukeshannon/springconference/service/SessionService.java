package com.lukeshannon.springconference.service;

import org.springframework.stereotype.Service;

import com.lukeshannon.springconference.repo.SessionRepo;

@Service
public class SessionService {

	private SessionRepo sessionRepo;

	public SessionService(SessionRepo sessionRepo) {
		this.sessionRepo = sessionRepo;
	}
	
	
}
