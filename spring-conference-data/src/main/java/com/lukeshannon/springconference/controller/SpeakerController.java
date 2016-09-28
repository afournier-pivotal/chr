package com.lukeshannon.springconference.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukeshannon.springconference.model.Speaker;
import com.lukeshannon.springconference.service.SpeakerService;

@RestController
@RequestMapping("/v1")
public class SpeakerController {
	
	private SpeakerService speakerService;
	
	
	
	@Autowired
	public SpeakerController(SpeakerService speakerService) {
		this.speakerService = speakerService;
	}

	@RequestMapping("/speakers")
	public ResponseEntity<List<Speaker>> speakers() {
		List<Speaker> response = speakerService.getSpeakers();
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping("/speaker/{id}")
	public ResponseEntity<Speaker> speaker(@PathVariable Long id) {
		Speaker response = speakerService.getSpeaker(id);
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
