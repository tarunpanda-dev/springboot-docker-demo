package com.producer.kafka.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Kafka Producer API", version = "1.0", description = "API for publishing messages to Kafka"))
public class OpenApiConfig {
}