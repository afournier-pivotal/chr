package com.lukeshannon.springconference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lukeshannon.springconference.model.Attendee;
import com.lukeshannon.springconference.model.Rating;
import com.lukeshannon.springconference.model.Session;
import com.lukeshannon.springconference.model.Speaker;
import com.lukeshannon.springconference.repo.AttendeeRepo;
import com.lukeshannon.springconference.repo.RatingRepo;
import com.lukeshannon.springconference.repo.SessionRepo;
import com.lukeshannon.springconference.repo.SpeakerRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringConferenceDataApplicationTests {
	
	private static final Long ID = Long.valueOf("0");
	private static final String PETER_INNOTECH_COM = "peter@innotech.com";
	private static final String INNOTECH = "Innotech";

	private List<Attendee> attendees = new ArrayList<Attendee>();
	private List<Speaker> speakers = new ArrayList<Speaker>();
	private List<Session> sessions = new ArrayList<Session>();
	private List<Rating> ratings = new ArrayList<Rating>();
	
	@Autowired
	private AttendeeRepo attendeeRepo;
	
	@Autowired
	private RatingRepo ratingRepo;
	
	@Autowired
	private SessionRepo sessionRepo;
	
	@Autowired
	private SpeakerRepo speakerRepo;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void SpeakerCrudTest() {
		Speaker speaker = new Speaker();
		speaker.setName("The Grand Puba");
		speaker.setTwitter("thegreatpoba");
		speaker.setWebsite("http://www.poba.com");
		speakerRepo.save(speaker);
		assertNotNull(speakerRepo.findOne(speaker.getId()));
	}
	
	@Test
	public void SessionCrudTest() {
		
	}
	
	@Test
	public void AttendeeCrudTest() {
		Attendee attendee = new Attendee();
		attendee.setCompany(INNOTECH);
		attendee.setEmail(PETER_INNOTECH_COM);
		attendeeRepo.save(attendee);
		assertNotNull(attendeeRepo.findOne(attendee.getId()));
		assertEquals(attendeeRepo.findOne(attendee.getId()).getCompany(),INNOTECH);
	}
	
	@Test
	public void RatingCrudTest() {
		
	}
	
	

}
