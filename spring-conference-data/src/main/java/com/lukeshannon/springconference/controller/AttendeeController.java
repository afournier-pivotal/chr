package com.lukeshannon.springconference.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukeshannon.springconference.model.Attendee;
import com.lukeshannon.springconference.service.AttendeeService;

@RestController
@RequestMapping("/v1")
public class AttendeeController {
	
	private AttendeeService attendeeService;
	
	public AttendeeController(AttendeeService attendeeService) {
		this.attendeeService = attendeeService;
	}



	@RequestMapping("/getAttendees")
	public ResponseEntity<List<Attendee>> getAttendees() {
		return null;
	}
	
}
