package com.producer.kafka.app;

import java.util.concurrent.CompletableFuture;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import com.producer.kafka.event.TestEvent;

@Service
public class ProducerKafka {
	
	private final KafkaTemplate<String, TestEvent> kafkaTemplate;
	
	public ProducerKafka(KafkaTemplate<String, TestEvent> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendEvent(TestEvent event) {
		// Capture the asynchronous Future object
		CompletableFuture<SendResult<String, TestEvent>> future = 
				kafkaTemplate.send("test-event", event.getTestId(), event);
		
		// Add async success/failure logging callbacks
		future.whenComplete((result, exception) -> {
			if (exception != null) {
				System.err.println("❌ Failed to send event to Kafka: " + exception.getMessage());
			} else {
				System.out.println("✅ Event successfully sent! Partition: " 
						+ result.getRecordMetadata().partition() 
						+ " | Offset: " + result.getRecordMetadata().offset());
			}
		});
	}
}
