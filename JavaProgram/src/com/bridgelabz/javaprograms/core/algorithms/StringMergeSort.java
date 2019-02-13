package com.bridgelabz.javaprograms.core.algorithms;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Performing the sorting of strings using merge sort algorithm
 *           
 * I/P    :  array of strings
 * O/P    :  a sorted array of strings
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 15-09-2019
 *****************************************************************************************/
public class StringMergeSort {
	public static void main(String[] args) {
		String[] words;
		String temp;
		String line = "";
		do {
			System.out.println("enter few line of text...!");
			temp = Utility.scanner.nextLine();
			line = line + temp;
		}while(temp.trim().equals("") || temp == null);
		words = line.split(" ");
		System.out.println("Before sorting ...!");
		Utility.printStringArray(words);
		words = Utility.mergeSort(words);
		System.out.println("After sorting ...!");
		Utility.printStringArray(words);
	}
    
}
