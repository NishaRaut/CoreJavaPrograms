package com.bridgelabz.javaprograms.core.oops;

import java.util.List;

/******************************************************************************
 *  Purpose :  Inventory class to create various inventories
 *  
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   31-01-2019
 *  
 *******************************************************************************/
public class Inventory {
	private String name;
	private List<Product> products;

	//setters and getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
