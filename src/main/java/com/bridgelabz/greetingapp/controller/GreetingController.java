package com.bridgelabz.greetingapp.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IGreetingService;

@RestController
public class GreetingController {
	
	// UC-3 method
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
	
	
	
	private static final String template = "Hello, %s !!!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/addgreeting")
	public Greeting addGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);
	}
	
	@GetMapping(" ")
	public String blankGreeting() {
		return "Hello Stranger!!!";
	}	
	
	@Autowired
	public IGreetingService greetingService;
	
	@GetMapping("/allgreetings")
	public ResponseEntity<List<Greeting>> allGreetings(){
		List<Greeting> messageList = greetingService.getGreetings();
		return new ResponseEntity<>(messageList, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findgreeting/{id}")
	public Greeting findGreeting(@PathVariable(name = "id") long id) {
		return greetingService.findGreeting(id);
	}

}
