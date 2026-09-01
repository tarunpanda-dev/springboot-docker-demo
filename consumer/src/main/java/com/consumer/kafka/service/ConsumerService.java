package com.consumer.kafka.service;

import java.util.List;
import com.consumer.kafka.event.TestEvent;

public interface ConsumerService {
    void processAndStore(TestEvent event);
    List<TestEvent> getAllConsumedEvents();
}
