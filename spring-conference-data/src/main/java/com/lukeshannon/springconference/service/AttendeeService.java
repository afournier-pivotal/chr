package com.lukeshannon.springconference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukeshannon.springconference.repo.AttendeeRepo;

@Service
public class AttendeeService {

	private AttendeeRepo attendeeRepo;
	
	@Autowired
	public AttendeeService(AttendeeRepo attendeeRepo) {
		this.attendeeRepo = attendeeRepo;
	}

	
	
	
}
