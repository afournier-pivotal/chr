package com.lukeshannon.springconference.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukeshannon.springconference.model.Session;
import com.lukeshannon.springconference.model.Speaker;

@RestController
@RequestMapping("/v1")
public class SessionController {
	
	@RequestMapping("/sessions")
	public ResponseEntity<List<Session>> getSessions() {
		List<Session> sessions = new ArrayList<Session>();
		Session s1 = new Session();
		s1.setStartTime(new Date());
		s1.setEndTime(new Date());
		List<Speaker> speakers = new ArrayList<Speaker>();
		Speaker speaker1 = new Speaker();
		speaker1.setName("Biff The Wonder Boy");
		s1.setSpeakers(speakers);
		return ResponseEntity.ok(sessions);
	}

}
