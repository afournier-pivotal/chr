package com.lukeshannon.springconference.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lukeshannon.springconference.model.Attendee;
import com.lukeshannon.springconference.repo.AttendeeRepo;

@Service
public class AttendeeService {

	private AttendeeRepo attendeeRepo;
	
	@Autowired
	public AttendeeService(AttendeeRepo attendeeRepo) {
		this.attendeeRepo = attendeeRepo;
	}
	
	public List<Attendee> getAttendees() {
		Iterable<Attendee> source = attendeeRepo.findAll();
		List<Attendee> target = new ArrayList<>();
		source.forEach(target::add);
		return target;
	}
	
	public Attendee getAttendee(Long id) {
		return attendeeRepo.findOne(id);
	}
	
	public void saveAttendee(String email, String company) {
		attendeeRepo.save(new Attendee(email,company) );
	}

	
	
	
}
