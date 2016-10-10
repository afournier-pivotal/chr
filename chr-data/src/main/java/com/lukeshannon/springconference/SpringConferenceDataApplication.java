package com.lukeshannon.springconference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringConferenceDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConferenceDataApplication.class, args);
	}
}

@RestController
class HomeController {
	
	@RequestMapping("/")
	public ResponseEntity<String> home() {
		return ResponseEntity.ok("This is a simple REST service for the conference data");
	}
	
}