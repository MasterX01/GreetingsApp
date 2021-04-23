package com.bridgelabz.greetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.model.Greeting;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s !!!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));		
	}
	
	@GetMapping(" ")
	public String blankGreeting() {
		return "Hello Stranger!!!";
	}
	
	@GetMapping("/greeting/")
	public Greeting greetingForName(@RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName) {
		if(firstName == null && lastName == null) {
			return new Greeting(counter.incrementAndGet(),String.format(template, "World"));
		}
		if(firstName == null) {
			return new Greeting(counter.incrementAndGet(),String.format(template, lastName));
		}
		if(lastName == null) {
			return new Greeting(counter.incrementAndGet(),String.format(template, firstName));
		}
		return new Greeting(counter.incrementAndGet(), String.format(template, firstName + " " + lastName));
	}
	

}
