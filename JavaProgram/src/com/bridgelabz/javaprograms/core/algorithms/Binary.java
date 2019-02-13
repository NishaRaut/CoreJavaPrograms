package com.bridgelabz.javaprograms.core.algorithms;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Conversion of Decimal to Binary. 
 *           Performing following functiionalities:
 *           i. Swap nibbles and find the new number.
 *           ii. Check the resultant number is a power of 2.
 *        
 * I/P    :  a positive integer
 * O/P    :  binary number
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 15-09-2019
 *****************************************************************************************/
public class Binary {
	public static void main(String[] args) {
		int decimal;
		do {
			System.out.println("Enter a positive number...!");
			decimal = Utility.getPositiveInt();
		}while(decimal <= 0);

		//convert to  binary
		System.out.println("Decimal Number  : "+decimal);
		char[] temp  = Utility.toBinary(decimal);
		String  binary = new String(temp);
		StringBuffer sb = new StringBuffer(binary);
		sb.reverse();
		binary = sb.toString();
		System.out.println("Binary equivalent of " +decimal+" : "+ binary);
		int swapped = Utility.swapNibbles(decimal);
		temp = Utility.toBinary(swapped);
		binary = new String(temp);	
		sb = new StringBuffer(binary);
		sb.reverse();
		binary = sb.toString();
		int toInt = Integer.parseInt(binary,2);
		System.out.println("After swapping nibble binary equivalent :"+binary);
		System.out.println("After swapping nibble decimal equivalent :"+toInt);
		boolean isPowerOf2 = Utility.isPowerTwo(toInt);
		if(isPowerOf2)
			System.out.println(toInt + " is  power 2");
		else
			System.out.println(toInt + " is  not a power 2");
	}

}
