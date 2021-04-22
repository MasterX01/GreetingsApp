package com.bridgelabz.greetingapp.model;

public class Greeting {

	private String message;
	private long gId;
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
