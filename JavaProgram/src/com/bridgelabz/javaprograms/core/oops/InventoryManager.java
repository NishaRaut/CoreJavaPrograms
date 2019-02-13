package com.bridgelabz.javaprograms.core.oops;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.javaprograms.core.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;

/******************************************************************************
 *  Purpose :  Implementation of Inventory Manager to manage the various inventories and 
 *             display the price of each inventory
 *
 *  I/P     :  JSON file of inventories
 *  
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   31-01-2019
 *  
 *******************************************************************************/
public class InventoryManager {

	public static void main(String[] args) {
		String path = "resource/oops/inventory2.json";
		File file = new File(path);
		ObjectMapper objMapper = new ObjectMapper();
		InventoryFactory inventoryFactory = null;
		List<Inventory> inventories = new ArrayList<Inventory>();
		try {
			if (file.length() == 0) { // no inventories present
				inventories = new ArrayList<Inventory>(); // create a empty list of inventories
				inventoryFactory = new InventoryFactory();
			} else {
				inventoryFactory = objMapper.readValue(file, InventoryFactory.class); // getting inventories from file
				inventories = inventoryFactory.getInventories();
			}

			System.out.println("\t Enter the inventory name...!");
			String error = "";
			String inventoryName;
			do {
				System.out.println("\t " + error);
				inventoryName = Utility.getString();
			} while (!Utility.validateStringForAlphanumericOflength20(inventoryName));
			addProducts(inventories, inventoryName);
			// display the price of each inventory
			printPriceOfAllInventories(inventories);
			// write back to the file
			inventoryFactory.setInventories(inventories);
			objMapper.writeValue(file, inventoryFactory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end of main function

	/**
	 * adds a product to the inventory
	 * 
	 * @param inventories   list of inventories
	 * @param inventoryName name of the inventory to which a product to be added
	 */
	public static void addProducts(List<Inventory> inventories, String inventoryName) {
		Inventory oldInventory = null;
		List<Product> products = null;
		// search for the inventoryName existence
		if (inventories.stream().filter(inv -> inv.getName().equals(inventoryName)).findFirst().isPresent()) {
			oldInventory = inventories.stream().filter(inv -> inv.getName().equals(inventoryName)).findFirst().get();
			products = oldInventory.getProducts();
		} else { // inventory doesn't exist in the inventories
			oldInventory = new Inventory(); // create a new inventory
			oldInventory.setName(inventoryName);
			products = new ArrayList<>(); // create a new product list
		}

		// get the product details
		String choice = "Y";
		String name;
		double quantity;
		double price;
		do {
			System.out.println("\t Enter name of the product");
			name = Utility.getString();
			while(isProductExists(products, name))
			{
				System.out.println("Product '"+name+"' already exists...! Enter a new product name.");
				name = Utility.getString();
			}
			System.out.println("\t Enter quantity of the product");
			quantity = Utility.getDouble();
			System.out.println("\t Enter price of the product");
			price = Utility.getDouble();
			Product product = new Product();
			product.setName(name);
			product.setQuantity(quantity);
			product.setPrice(price);
			products.add(product);
			System.out.println("\n\t Want to add another product..?(Y/N)");
			choice = Utility.getString();
		} while (choice.trim().toUpperCase().equals("Y"));
	}

	/**
	 * prints the price of all the inventories in the inventory list
	 * 
	 * @param inventories list of inventories
	 */
	public static void printPriceOfAllInventories(List<Inventory> inventories) {
		System.out.println("\n\t Name \t\t Price");
		System.out.println("--------------------------------------------------");
		if (inventories == null || inventories.size() == 0) {
			System.out.println("\t There are no inventries...!");
			return;
		}
		for (Inventory inv : inventories) {
			System.out.printf("\t %s \t\t %f", inv.getName(), getInventoryPrice(inv));
			System.out.println();

		}
	}

	/**
	 * computes the price of an inventory
	 * 
	 * @param inventory name of the inventory
	 * @return inventory price
	 */
	public static double getInventoryPrice(Inventory inventory) {
		double price = 0.0;
		for (Product p : inventory.getProducts()) {
			price += p.getQuantity() * p.getPrice();
		}
		return price;
	}
	
	/**
	 * checks whether the product exists in the product list
	 * @param products list of products
	 * @param productName name of the product 
	 * @return true if product exists else false
	 */
	public static boolean isProductExists(List<Product> products,String productName) {
		if(products == null)
			return false;
		else if(products.stream().filter(p -> p.getName().equals(productName)).findFirst().isPresent())
			return true;
		else
			return false;
	}
}
