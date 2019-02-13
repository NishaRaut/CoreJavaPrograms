package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: prints prime factors of a given number
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   09-01-2019
 *
 ******************************************************************************/
public class PrimeFactors {
	public static void main(String[] args) {
	   System.out.println("Enter a positive integer number");
       int number = Utility.getPositiveInt();
       Utility.primeFactors(number);
	}

}
