package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: prints nth Harmonic Number
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   09-01-2019
 *
 ******************************************************************************/
public class HarmonicNumber {
	public static void main(String[] args) 
	{
		System.out.println("Enter a positive integer number");
		int number = Utility.getPositiveInt();
		double harmonicVal = Utility.getNthHarmonicNumber(number);
		System.out.print(number+"th Harmonic Value = ");
		System.out.printf("%.2f\n", harmonicVal);
	}

}
