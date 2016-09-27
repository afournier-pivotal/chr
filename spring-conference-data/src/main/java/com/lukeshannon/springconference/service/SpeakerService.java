package com.lukeshannon.springconference.service;

import org.springframework.stereotype.Service;

import com.lukeshannon.springconference.repo.SpeakerRepo;

@Service
public class SpeakerService {

	private SpeakerRepo speakerSession;

	public SpeakerService(SpeakerRepo speakerSession) {
		this.speakerSession = speakerSession;
	}
	
	
	
}
