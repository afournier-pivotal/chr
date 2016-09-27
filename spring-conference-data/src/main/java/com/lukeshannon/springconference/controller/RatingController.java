package com.lukeshannon.springconference.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukeshannon.springconference.model.Rating;
import com.lukeshannon.springconference.service.RatingService;

@RestController
@RequestMapping("/v1")
public class RatingController {
	
	private RatingService ratingSession;

	public RatingController(RatingService ratingSession) {
		this.ratingSession = ratingSession;
	}

	@RequestMapping("/getRatings/{sessionId}")
	public List<Rating> getRatingsForSession(@PathVariable Long sessionId) {
		return null;
	}
}
