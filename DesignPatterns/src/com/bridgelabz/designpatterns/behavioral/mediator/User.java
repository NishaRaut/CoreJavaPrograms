package com.bridgelabz.designpatterns.behavioral.mediator;

public abstract class User {
	protected String name;
	protected ChatMediator mediator;
	
	public User(ChatMediator med, String name){
		this.mediator=med;
		this.name=name;
	}
	
	public abstract void send(String msg);
	
	public abstract void receive(String msg);
}
