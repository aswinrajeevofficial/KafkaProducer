package com.messaging.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("kafka")
public class ProducerController {

	@Autowired
	KafkaTemplate<String, String> template;
	private static final String topic = "DISCHARGE_TOPIC";
	
	@GetMapping("/publish/{message}")
	public String produceMessage(@PathVariable("message")String message) {
		template.send(topic, message);
		return "Message pushed to topic successfully";
	}
}
