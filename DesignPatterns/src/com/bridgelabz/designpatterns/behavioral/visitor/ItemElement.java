package com.bridgelabz.designpatterns.behavioral.visitor;

public interface ItemElement {
	//accept a visitor
	public int accept(ShoppingCartVisitor visitor);
}
