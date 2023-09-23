package br.com.kafkaintegration.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaConsumer {
	
	@KafkaListener(topics = "${spring.kafka.consuming-process.test.topic}", groupId = "${spring.kafka.consuming-process.test.group-id}", 
			autoStartup = "${spring.kafka.consuming-process.test.enabled}")
	 public void consume(String message) {
	        log.info("Received message: " + message);
	 }
}
