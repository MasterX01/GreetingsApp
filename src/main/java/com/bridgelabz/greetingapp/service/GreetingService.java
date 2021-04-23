package com.bridgelabz.greetingapp.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService{
	private static final String template = "Hello, %s !";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingRepository greetingRepository;

	public Greeting addGreeting(User user) {
		String message = String.format(template, (user.getFirstName().isEmpty()) ? " World" : user.getFirstName());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
	}
	
	public List<Greeting> getGreetings(){
		return greetingRepository.findAll();
	}
	
	public Greeting findGreeting(long id) {
		return greetingRepository.findById(id).get();
	}
	
	public Greeting updateGreeting(User user, long id) {
		return greetingRepository.save(new Greeting(id, String.format(template, (user.getFirstName().isEmpty())? " World" : user.getFirstName())));
	}

	public void deleteGreetingById(long id) {
		greetingRepository.deleteById(id);
	}

}
