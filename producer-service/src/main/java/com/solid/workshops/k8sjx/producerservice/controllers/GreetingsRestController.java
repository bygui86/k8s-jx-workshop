package com.solid.workshops.k8sjx.producerservice.controllers;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(value = AccessLevel.PROTECTED)
@RestController("greetingsRestController")
@RequestMapping("/greetings")
class GreetingsRestController {

	@Value("${spring.application.name}")
	String appName;

	@GetMapping
	public String greet() {

		return "Greetings from " + getAppName() + " ;)";
	}

}
