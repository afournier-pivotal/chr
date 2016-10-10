package com.lukeshannon.springconference.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.lukeshannon.springconference.model.Attendee;

public interface AttendeeRepo extends PagingAndSortingRepository<Attendee, Long> {

}
