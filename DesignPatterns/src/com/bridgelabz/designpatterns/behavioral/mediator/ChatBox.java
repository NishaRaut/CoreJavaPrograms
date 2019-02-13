package com.bridgelabz.designpatterns.behavioral.mediator;

public class ChatBox {

	public static void main(String[] args) {
		ChatMediator mediator = new ChatMediatorImpl();
		User albert = new UserImpl(mediator, "Albert");
		User elon = new UserImpl(mediator, "Elon");
		User ram = new UserImpl(mediator, "Ram");
		User rao = new UserImpl(mediator, "Rao");
		mediator.addUser(albert);//adding user to the chatbox via mediator
		mediator.addUser(elon);
		mediator.addUser(ram);
		mediator.addUser(rao);
		
		albert.send("Hi All");

	}

}
