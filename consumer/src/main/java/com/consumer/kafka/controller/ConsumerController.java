package com.consumer.kafka.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.consumer.kafka.event.TestEvent;
import com.consumer.kafka.service.ConsumerService;

@RestController
@RequestMapping("/kafka/consumer")
public class ConsumerController {

    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    // HTTP GET endpoint to view all consumed messages
    @GetMapping("/messages")
    public ResponseEntity<List<TestEvent>> getMessages() {
        return ResponseEntity.ok(consumerService.getAllConsumedEvents());
    }
}
