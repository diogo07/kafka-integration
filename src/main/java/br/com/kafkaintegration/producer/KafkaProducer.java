package br.com.kafkaintegration.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaProducer {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void send(String message, String key, String topic) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, message);		
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				log.info("Sent message key={} with offset=[{}]", key, result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				log.info("Unable to send message key={} due to: {}", key, ex.getMessage());
			}
		});

	}
}
