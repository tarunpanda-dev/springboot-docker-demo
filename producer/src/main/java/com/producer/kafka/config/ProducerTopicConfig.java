package com.producer.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class ProducerTopicConfig {
	
	@Bean
	NewTopic testTopic() {
		return TopicBuilder
				.name("test-event").partitions(3).replicas(1).build();
	}

}
