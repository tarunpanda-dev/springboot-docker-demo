package com.consumer.kafka.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.consumer.kafka.event.TestEvent;
import com.consumer.kafka.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    // A simple thread-safe in-memory storage for our microservice
    private final List<TestEvent> storage = new ArrayList<>();

    @Override
    public void processAndStore(TestEvent event) {
        // Business logic goes here
        System.out.println("Service Layer: Processing Event ID -> " + event.getTestId());
        storage.add(event);
    }

    @Override
    public List<TestEvent> getAllConsumedEvents() {
        return storage;
    }
}
