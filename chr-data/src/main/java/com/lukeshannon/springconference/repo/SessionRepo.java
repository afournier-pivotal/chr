package com.lukeshannon.springconference.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.lukeshannon.springconference.model.Session;

public interface SessionRepo extends PagingAndSortingRepository<Session, Long> {

}
