package com.solid.workshops.k8sjx.consumerservice.controllers;

import com.solid.workshops.k8sjx.consumerservice.feign.clients.ProducerServiceClient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(value = AccessLevel.PROTECTED)
@RestController("greetingsRestController")
@RequestMapping("/greetings")
class GreetingsRestController {

	@Value("${spring.application.name}")
	String appName;

	@Autowired
	private ProducerServiceClient producerServiceClient;

	@GetMapping
	public String greet() {

		log.info("Getting greetings from current service {}",
				getAppName());

		return "Greetings from " + getAppName() + " ;)";
	}

	@GetMapping("/all")
	public List<String> allGreet() {

		log.info("Getting greetings from current service {} and from another service {}",
				getAppName(), "producer-service");

		final List<String> greetings = new ArrayList<>();
		// add current greeting
		greetings.add(
				greet()
		);
		// add producer-service greeting
		greetings.add(
				getProducerServiceClient().greet()
		);

		return greetings;
	}

}
