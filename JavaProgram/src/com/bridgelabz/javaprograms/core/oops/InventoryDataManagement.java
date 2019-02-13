package com.bridgelabz.javaprograms.core.oops;

import java.io.File;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose :  Implementation of Inventory Data Management System.
 *
 *  I/P     : JSON file of inventory
 *  
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   26-01-2019
 *  
 *******************************************************************************/
public class InventoryDataManagement {

	public static void main(String[] args) {
		File file = new File("resource/oops/inventory.json");
        JSONObject inventory = (JSONObject)Utility.readJsonFile(file);
        
        //get the rice items
        JSONArray riceList = (JSONArray)inventory.get("Rice");
        Long totalRiceAvailble = 0L;
        System.out.println("\t=========== Rice Deatails =================");
        System.out.println("\tSL No\tName \t\t\t\t Quantity \t Price");
        System.out.println("\t-----------------------------------------------------------");
        JSONObject rice = null;
        for(int i = 0 ; i<riceList.size(); i++) {
        	rice = (JSONObject)riceList.get(i);
        	totalRiceAvailble += (Long)rice.get("weight");
        	System.out.printf("\t%d \t%s \t\t %d \t\t %d",i+1,rice.get("name"),rice.get("weight"),rice.get("price"));
        	System.out.println();
        }
        System.out.println("\n\t Total Rice Availbale = "+totalRiceAvailble+"Kgs");
        
      //get the pulses
        JSONArray pulseList = (JSONArray)inventory.get("Pulses");
        Long totalPulseAvailble = 0L;
        System.out.println("\n\t=========== Pulses Deatails =================");
        System.out.println("\tSL No\tName \t\t\t Quantity \t Price");
        System.out.println("\t-----------------------------------------------------------");
        JSONObject pulse = null;
        for(int i = 0 ; i<pulseList.size(); i++) {
        	pulse = (JSONObject)pulseList.get(i);
        	totalPulseAvailble += (Long)pulse.get("weight");
        	System.out.printf("\t%d \t%s \t\t %d \t\t %d",i+1,pulse.get("name"),pulse.get("weight"),pulse.get("price"));
        	System.out.println();
        }
        System.out.println("\n\t Total Pulses Availbale = "+totalPulseAvailble+"Kgs");
        
        //get the wheats
        JSONArray wheatsList = (JSONArray)inventory.get("Pulses");
        Long totalWheatAvailble = 0L;
        System.out.println("\n\t=========== Wheats Deatails =================");
        System.out.println("\tSL No\tName \t\t\t Quantity \t Price");
        System.out.println("\t-----------------------------------------------------------");
        JSONObject wheat = null;
        for(int i = 0 ; i<wheatsList.size(); i++) {
        	wheat = (JSONObject)wheatsList.get(i);
        	totalWheatAvailble += (Long)wheat.get("weight");
        	System.out.printf("\t%d \t%s \t\t %d \t\t %d",i+1,wheat.get("name"),wheat.get("weight"),wheat.get("price"));
        	System.out.println();
        }
        System.out.println("\n\t Total Wheats Availbale = "+totalWheatAvailble+"Kgs");
	}

}
