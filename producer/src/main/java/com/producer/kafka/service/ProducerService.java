package com.producer.kafka.service;

import com.producer.kafka.event.TestEvent;

public interface ProducerService {
	
	TestEvent sendEvent(TestEvent event);

}
