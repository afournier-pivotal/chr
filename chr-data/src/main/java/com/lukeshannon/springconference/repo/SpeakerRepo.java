package com.lukeshannon.springconference.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.lukeshannon.springconference.model.Speaker;

public interface SpeakerRepo extends PagingAndSortingRepository<Speaker, Long> {

}
