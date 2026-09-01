package com.consumer.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.consumer.kafka.event.TestEvent;
import com.consumer.kafka.service.ConsumerService;

@Service
public class ConsumerKafka {

    private final ConsumerService consumerService;

    // Injecting the service layer
    public ConsumerKafka(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @KafkaListener(topics = "test-event", groupId = "my-group")
    public void consumeEvent(TestEvent event) {
        System.out.println("========================================");
        System.out.println("Received raw bytes from Kafka broker!");
        System.out.println("========================================");
        
        // Pass it to the service layer for processing
        consumerService.processAndStore(event);
    }
}
