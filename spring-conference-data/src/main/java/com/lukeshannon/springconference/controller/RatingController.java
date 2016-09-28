package com.lukeshannon.springconference.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lukeshannon.springconference.model.Rating;
import com.lukeshannon.springconference.model.Session;
import com.lukeshannon.springconference.service.RatingService;

@RestController
@RequestMapping("/v1")
public class RatingController {
	
	private RatingService ratingService;

	public RatingController(RatingService ratingService) {
		this.ratingService = ratingService;
	}

	@RequestMapping(value="/ratings/{sessionId}", method = RequestMethod.GET)
	public List<Rating> getRatingsForSession(@PathVariable Long sessionId) {
		return null;
	}
	
	@RequestMapping(value="/ratings/{token}/{score}/{sessionId}", method = RequestMethod.POST) 
	public ResponseEntity<HttpStatus> saveRating(@PathVariable String token, Integer score, Long sessionId) {
		Session response = ratingService.setRating(token, score, sessionId);
		if (response == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
