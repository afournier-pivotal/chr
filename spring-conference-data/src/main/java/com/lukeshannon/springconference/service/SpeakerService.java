package com.lukeshannon.springconference.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lukeshannon.springconference.model.Speaker;
import com.lukeshannon.springconference.repo.SpeakerRepo;

@Service
public class SpeakerService {

	private SpeakerRepo speakerSession;

	public SpeakerService(SpeakerRepo speakerSession) {
		this.speakerSession = speakerSession;
	}
	
	public List<Speaker> getSpeakers() {
		Iterable<Speaker> source = speakerSession.findAll();
		List<Speaker> target = new ArrayList<>();
		source.forEach(target::add);
		return target;
	}
	
	public Speaker getSpeaker(Long id) {
		return speakerSession.findOne(id);
	}
	
	
	
}
