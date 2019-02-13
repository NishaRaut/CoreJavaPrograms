package com.bridgelabz.javaprograms.core.oops;

import java.util.List;

/******************************************************************************
 *  Purpose :  To get the inventories object from JSON file.
 *  
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   31-01-2019
 *  
 *******************************************************************************/
public class InventoryFactory {
	String name = "inventories";
	List<Inventory> inventories;

	public List<Inventory> getInventories() {
		return inventories;
	} 
	public List<Inventory> setInventories(List<Inventory> inventories) {
		return this.inventories = inventories;
	} 
}
