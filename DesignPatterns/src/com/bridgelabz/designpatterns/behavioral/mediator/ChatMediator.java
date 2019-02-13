package com.bridgelabz.designpatterns.behavioral.mediator;

public interface ChatMediator {
	void addUser(User user);
	public void sendMessage(String msg, User user);
}
