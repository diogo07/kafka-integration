package br.com.kafkaintegration.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class KafkaMessageRequestDTO {
	@NotBlank
	private String topic;
	
	@NotBlank
	private String message;
	
	@NotBlank
	private String key;
}
