package com.lukeshannon.springconference.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		List<Attendee> values = attendeeService.getAttendees();
		if (values != null) {
			return ResponseEntity.ok(values);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping("/getAttendee")
	public ResponseEntity<Attendee> getAttendee(Long id) {
		Attendee value = attendeeService.getAttendee(id);
		if (value != null) {
			return ResponseEntity.ok(value);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/newAttendee/{company}/{email}")
	public void submitAttendee(@PathVariable String company, @PathVariable String email) {
		attendeeService.saveAttendee(email, company);
		
	}
	
}
