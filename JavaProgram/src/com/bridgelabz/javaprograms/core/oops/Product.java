package com.bridgelabz.javaprograms.core.oops;

/******************************************************************************
 *  Purpose :  Product class to create various products in an inventory
 *  
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   31-01-2019
 *  
 *******************************************************************************/
public class Product {
	private String name;
	private double quantity;
	private double price;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double d) {
		this.quantity = d;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double inputPropertyprice) {
		this.price = inputPropertyprice;
	}

}
