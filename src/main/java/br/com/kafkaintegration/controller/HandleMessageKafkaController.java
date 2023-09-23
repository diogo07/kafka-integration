package br.com.kafkaintegration.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kafkaintegration.dto.KafkaMessageRequestDTO;
import br.com.kafkaintegration.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/handle-message-kafka")
public class HandleMessageKafkaController {

	private final KafkaProducer kafkaProducer;
	
	@PostMapping(value = "/send")
	public void sendMessageToKafkaTopic(@Valid @RequestBody KafkaMessageRequestDTO kafkaMessageRequest) {
		this.kafkaProducer.send(kafkaMessageRequest.getMessage(), kafkaMessageRequest.getKey(), kafkaMessageRequest.getTopic());
	}
}
