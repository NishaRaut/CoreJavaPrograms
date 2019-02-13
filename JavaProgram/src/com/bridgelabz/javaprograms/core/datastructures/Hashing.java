package com.bridgelabz.javaprograms.core.datastructures;

import java.io.File;
import java.util.HashMap;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose :  Implementation of hashing function to search a key.
 *
 *  I/P     : number of slots
 *  
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   22-01-2019
 *  
 *******************************************************************************/
public class Hashing {

	public static void main(String[] args) {
		//Read the numbers from a file
		File file = new File("resource/HashingInput.txt");  
		String[] strNumbers = Utility.readFromFile(file);
		int[] numbers = Utility.stringToIntArray(strNumbers);

		//create hash table of ordered link list
		HashMap<Integer,OrderedList<Integer>> hashTable = new HashMap<>();
		for(int i = 0; i < 11 ; i++) {
			hashTable.put(i, null);
		}
		//add all the numbers to appopriate slot in hash table
		for (int i = 0; i < numbers.length; i++) {
			addToHashTable(hashTable,numbers[i]);
		}
		//print the numbers in the hash table
		printHashTable(hashTable);
		//read key to search
		System.out.println("\nEnter a key to be searched");
		int key = Utility.getInt();
		if(searchKey(hashTable,key)) {
			System.out.println(key + "  is present, so removed from the hash table...!");
			System.out.println("Numbers in the hash table after removing the key...!");
		}
		else {
			System.out.println(key + "  is not present, so added to the hash table...!");
			System.out.println("Numbers in the hash table after adding the key...!\n");
		}
		printHashTable(hashTable);
		//writing the hashtable to a file
		int[] tempArr = toArray(hashTable);
		Utility.writeToFile(tempArr, file);
	}

	/**
	 * adding a number to slot
	 * @param hashTable hash table of N slots
	 * @param num number to be added
	 */
	public static void addToHashTable(HashMap<Integer,OrderedList<Integer>> hashTable, int num) {
		int slot = num % hashTable.size();
		OrderedList<Integer> list = hashTable.get(slot);
		if(list == null)
			list = new OrderedList<Integer>();
		list.add(num);
		hashTable.put(slot, list);
	}

	/**
	 * searches a key is present in the hash table; if present removes it otherwise adds to the table
	 * @param hashTable hash table of N slots
	 * @param key the key to be searched
	 * @return true if key present else false
	 */
	public static boolean searchKey(HashMap<Integer,OrderedList<Integer>> hashTable, int key) {
		boolean isPresent = false;
		int slot = key % hashTable.size();
		OrderedList<Integer> list = hashTable.get(slot);
		if(list == null) {
			isPresent = false;
			list = new OrderedList<Integer>();
			list.add(key);
		}
		else if(list.search(key)){
			isPresent = true;
			list.remove(key);
		}
		else {
			isPresent = false;
			list.add(key);
		}
		hashTable.put(slot, list);
		return isPresent;
	}
    
	/**
	 * printing all the numbers in the hash table
	 * @param hashTable hash table of numbers
	 */
	public static void printHashTable(HashMap<Integer,OrderedList<Integer>> hashTable) {
		System.out.println("Keys \t\t Values ");
		System.out.println("===========================");
		for(Integer key : hashTable.keySet()) {
			OrderedList<Integer> list = hashTable.get(key);
			System.out.printf("%d\t\t",key);
			if(list != null)
			     list.printOrderedList();
		}
	}
	
	/**
	 * converting the hashtable to array
	 * @param hashTable
	 * @return array of hash table data
	 */
	public static int[] toArray(HashMap<Integer,OrderedList<Integer>> hashTable) {
		String nums = "";
		for(Integer key : hashTable.keySet()) {
			OrderedList<Integer> list = hashTable.get(key);
		    while(list != null && list.getFirst() != null) {
		    	nums = nums + list.pop()+",";
		    }
		}
		String[] arr = nums.split(",");
		return Utility.stringToIntArray(arr);
	}
}

