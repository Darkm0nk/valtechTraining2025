package com.valtech.training.springsecurityjwt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
public class HelloController {
	
	@PostConstruct
	public void init()	{
		System.out.println("Init of Hello Controller ...");
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/data")
	public String data() {
		return "Data";
	}

}
