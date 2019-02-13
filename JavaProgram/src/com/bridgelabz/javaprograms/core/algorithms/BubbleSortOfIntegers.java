package com.bridgelabz.javaprograms.core.algorithms;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Performing the sorting of integers using bubble sort algorithm
 *           
 * I/P    :  array of strings
 * O/P    :  a sorted array of integers
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 15-09-2019
 *****************************************************************************************/
public class BubbleSortOfIntegers {
	public static void main(String[] args) {
	  int count = 0;
	  int[] nums;
      System.out.println("Enter the number of elemnts you want to have in your list");
      count = Utility.getPositiveInt();
      System.out.println("\t Enter '" + count + "' integers.");
      nums = new int[count];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Utility.getInt();
		}
      System.out.println("Elements before sorting ...!");
      Utility.printIntArray(nums);
      System.out.println("Elements after bubble sorting ...!");
      nums = Utility.bubbleSortOfIntegers(nums);
      Utility.printIntArray(nums);
	}

}
