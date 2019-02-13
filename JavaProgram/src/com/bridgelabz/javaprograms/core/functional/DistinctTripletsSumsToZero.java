package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/********************************************************************************************
 * Purpose : A program with cubic running time. Read in N integers and counts the   number of 
 *           triples that sum to exactly 0. 
 * I/P    : number of integer, and N integer input array
 * O/P    : One Output is number of distinct triplets as well as the second output is to print the distinct triplets.
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 10-09-2019
 *********************************************************************************************/
public class DistinctTripletsSumsToZero {
	/**
	 * main method to test the DistinctTripletsSumsToZero class
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Enter the numner(N) of integers...!");
		int num = Utility.getPositiveInt();
		System.out.println("Enter "+num+ " integers...!");
		int[] integers = new int[num];
		for (int i = 0; i < integers.length; i++) {
			integers[i] = Utility.getInt();
		}
		int noOfTripletsSumsToZero = Utility.countTripletsSumsToZero(integers);
		System.out.println("No. of distinct triplets = "+noOfTripletsSumsToZero);
	}

}
