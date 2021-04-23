package com.bridgelabz.greetingapp.service;

import java.util.List;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

public interface IGreetingService {
	public Greeting addGreeting(User user);

	public List<Greeting> getGreetings();

}
