package com.bridgelabz.javaprograms.core.algorithms;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Conversion of Decimal to Binary
 *           
 * I/P    :  a positive integer
 * O/P    :  binary number
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 15-09-2019
 *****************************************************************************************/
public class DecimalToBinary {
	public static void main(String[] args) {
		int decimal;
		do {
			System.out.println("Enter a positive number...!");
			decimal = Utility.getPositiveInt();
		}while(decimal <= 0);

		System.out.println("Decimal Number  : "+decimal);
		char[] result = Utility.toBinary(decimal);
		System.out.print("Binary Number  : ");
		for(int i = result.length -1; i>= 0;i--)
			System.out.print(result[i]);
	}
}
