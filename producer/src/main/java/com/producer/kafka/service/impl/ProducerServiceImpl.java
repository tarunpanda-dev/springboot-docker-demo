package com.producer.kafka.service.impl;

import org.springframework.stereotype.Service;

import com.producer.kafka.app.ProducerKafka;
import com.producer.kafka.event.TestEvent;
import com.producer.kafka.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService{
	
	private final ProducerKafka kafka;
	
	public ProducerServiceImpl(ProducerKafka kafka) {
		
		this.kafka = kafka;
	}

	@Override
	public TestEvent sendEvent(TestEvent event) {
		
		kafka.sendEvent(event);
		
		return event;
	}

}
