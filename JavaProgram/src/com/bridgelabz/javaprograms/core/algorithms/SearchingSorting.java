package com.bridgelabz.javaprograms.core.algorithms;

import java.util.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bridgelabz.javaprograms.core.functional.StopWatch;
import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Performing the searching and sorting for Integers and Strings list using, 
 *           Binary Search, Insertion Search and Bubble Sort.
 *           Also checking the performance of each functions.
 *           
 * I/P    :  array of strings and integers
 * O/P    :  position of key, sorted lists
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 12-09-2019
 *****************************************************************************************/
public class SearchingSorting {
	public static void main(String[] args) {
		StopWatch watch = new StopWatch();


		int num;// number of input elements you want to have in your list
		int[] numbers;
		String[] strings;
		int key;
		String strKey;
		int searchResult;
		int[] insertionSortedInts;
		int[] bubbleSortedInts;
		String[] insertionSortedStrings;
		String[] bubbleSortedStrings;
		long timeForBinarySearchOfInts = 0;
		long timeForBinarySearchOfStrings = 0;
		long timeForInsertionSortOfInts = 0;
		long timeForInsertionSortOfStrings = 0;
		long timeForBubbleSortOfInts = 0;
		long timeForBubbleSortOfStrings = 0;

		//binary searching for integers
		System.out.println("***************************** Binary searching of integers **********************");
		System.out.println("\tEnter no. of integers (N) you want to search in for a key...!");
		num = Utility.getPositiveInt();
		System.out.println("\t Enter '" + num + "' integers.");
		numbers = new int[num];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Utility.getInt();
		}
		System.out.println("\t Enter the key to be searched in.");
		key = Utility.getInt();
		// create a temporary array and Copy elements of numbers[] to it and supply it as input 
		int[] temp = new int[numbers.length];
		temp = Utility.copyArrayOfInts(numbers, temp);
		Arrays.sort(temp);
		watch.start();
		searchResult = Utility.binarySearchOfInt(temp, key);
		watch.stop();
		timeForBinarySearchOfInts = watch.timeElapsed();
		//Utility.printTime(timeForBinarySearchOfInts);
		if(searchResult != -1)
			System.out.println("\t Key found at position no. "+ searchResult);
		else
			System.out.println("\t Key '"+key + "' not found...!");

		//binary search for strings
		System.out.println("***************************** Binary searching of strings **********************");
		System.out.println("\tEnter no. of strings (N) you want to search in for a key...!");
		num = Utility.getPositiveInt();
		System.out.println("\t Enter '" + num + "' Strings.");
		strings = new String[num];
		for (int i = 0; i < strings.length; i++) {
			strings[i] = Utility.getString();
		}
		System.out.println("\t Enter the key to be searched in.");
		strKey = Utility.getString();
		// create a temporary array and Copy elements of strings[] to it and supply it as input 
		String[] strTemp = new String[strings.length];
		strTemp = Utility.copyArrayOfStrings(strings, strTemp);
		strTemp = Utility.insertionSortOfStrings(strTemp);//sorting
		watch.start();
		searchResult = Utility.binarySearchOfString(strTemp, strKey);
		watch.stop();
		timeForBinarySearchOfStrings = watch.timeElapsed();
		if(searchResult != -1)
			System.out.println("\t Key found at position no. "+ searchResult);
		else
			System.out.println("\t Key '"+strKey + "' not found...!");

		//sorting integers by insertion sort
		System.out.println("***************************** Sorting integers by insertion sort **********************");
		System.out.println("\t Before Sorting...!");
		Utility.printIntArray(numbers);
		insertionSortedInts = new int[numbers.length];
		insertionSortedInts = Utility.copyArrayOfInts(numbers, insertionSortedInts);
		watch.start();
		Utility.insertionSortOfInts(insertionSortedInts);
		watch.stop();
		timeForInsertionSortOfInts = watch.timeElapsed();
		System.out.println("\t After Sorting...!");
		Utility.printIntArray(insertionSortedInts);

		//sorting of strings by insertion sort
		System.out.println("***************************** Sorting strings by insertion sort **********************");
		System.out.println("\t Before Sorting...!");
		insertionSortedStrings = new String[strings.length];
		insertionSortedStrings = Utility.copyArrayOfStrings(strings, insertionSortedStrings);
		Utility.printStringArray(insertionSortedStrings);
		watch.start();
		insertionSortedStrings = Utility.insertionSortOfStrings(insertionSortedStrings);
		watch.stop();
		timeForInsertionSortOfStrings = watch.timeElapsed();
		System.out.println("\t After Sorting...!");
		Utility.printStringArray(insertionSortedStrings);

		//sorting integers by bubble sort
		System.out.println("***************************** Sorting integers by bubble sort **********************");
		System.out.println("\t Before Sorting...!");
		Utility.printIntArray(numbers);
		bubbleSortedInts = new int[numbers.length];
		bubbleSortedInts = Utility.copyArrayOfInts(numbers, bubbleSortedInts);
		watch.start();
		Utility.bubbleSortOfIntegers(bubbleSortedInts);
		watch.stop();
		timeForBubbleSortOfInts = watch.timeElapsed();
		System.out.println("\t After Sorting...!");
		Utility.printIntArray(bubbleSortedInts);

		//sorting of strings by insertion sort
		System.out.println("***************************** Sorting strings by Bubble sort **********************");
		System.out.println("\t Before Sorting...!");
		bubbleSortedStrings = new String[strings.length];
		bubbleSortedStrings = Utility.copyArrayOfStrings(strings, bubbleSortedStrings);
		Utility.printStringArray(bubbleSortedStrings);
		watch.start();
		bubbleSortedStrings = Utility.bubbleSortOfStrings(bubbleSortedStrings);
		watch.stop();
		timeForBubbleSortOfStrings = watch.timeElapsed();
		System.out.println("\t After Sorting...!");
		Utility.printStringArray(bubbleSortedStrings);

		//elapsed time for all the functionalities

		HashMap<String,Long> elapsedTimes = new HashMap<String,Long>();
		elapsedTimes.put("timeForBinarySearchOfInts", timeForBinarySearchOfInts);
		elapsedTimes.put("timeForBinarySearchOfStrings", timeForBinarySearchOfStrings);
		elapsedTimes.put("timeForInsertionSortOfInts", timeForInsertionSortOfInts);
		elapsedTimes.put("timeForInsertionSortOfStrings", timeForInsertionSortOfStrings);
		elapsedTimes.put("timeForBubbleSortOfInts", timeForBubbleSortOfInts);
		elapsedTimes.put("timeForBubbleSortOfStrings", timeForBubbleSortOfStrings);
		displayElapsedTimeInDescendingOrder(elapsedTimes);
	}

	/**
	 * printing the performance of each algorithms in descending order
	 * @param times
	 */
	public static void displayElapsedTimeInDescendingOrder(HashMap<String, Long> times) {
		//Create a list from elements of HashMap 
		List<Map.Entry<String, Long> > list = 
				new LinkedList<Map.Entry<String, Long> >(times.entrySet()); 

		// Sort the list 
		Collections.sort(list, new Comparator<Map.Entry<String, Long> >() { 
			public int compare(Map.Entry<String, Long> o1,  
					Map.Entry<String, Long> o2) 
			{ 
				return (o2.getValue()).compareTo(o1.getValue()); 
			} 
		}); 

		//display in descending order
		for(Map.Entry<String, Long> e : list) {
			System.out.println(e.getKey() + "  " + e.getValue());
		}
	}

}
