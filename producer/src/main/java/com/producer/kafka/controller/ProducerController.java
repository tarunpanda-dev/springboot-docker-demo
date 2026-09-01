package com.producer.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producer.kafka.event.TestEvent;
import com.producer.kafka.service.ProducerService;

@RestController
@RequestMapping("/kafka")
public class ProducerController {
	
	private final ProducerService service;
	
	public ProducerController(ProducerService service) {
		
		this.service = service;
	}
	
	
	@PostMapping("/produce")
	public ResponseEntity<?> testEvent(@RequestBody TestEvent event) {
	    // Prevent bad data from entering the message queue
	    if (event.getTestId() == null || event.getTestId().trim().isEmpty()) {
	        return ResponseEntity.badRequest().body("Error: testId cannot be null or empty!");
	    }
	    
	    return ResponseEntity.ok(service.sendEvent(event));
	}

	

}
