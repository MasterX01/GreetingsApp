package com.bridgelabz.greetingapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gId;
	private String message;
	
	public Greeting() {	}
	
	public Greeting(long gId, String message) {
		this.gId = gId;
		this.message = message;
	}
	
	public long getgId() {
		return gId;
	}
	public String getMessage() {
		return message;
	}
	

}
