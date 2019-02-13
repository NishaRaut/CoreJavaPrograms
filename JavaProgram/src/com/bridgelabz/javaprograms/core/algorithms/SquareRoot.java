package com.bridgelabz.javaprograms.core.algorithms;

import java.text.DecimalFormat;
import com.bridgelabz.javaprograms.core.util.Utility;

/**
 * Finding the roots of a quadratic equation
 *
 * I/P    :  a positive number
 * O/P    :  square root of the given +ve number
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 12-09-2019
 * 
 */
public class SquareRoot {
	public static void main(String[] args) {
		double num;
		double sqrtVal;
		do {
			System.out.println("Enter a non- negative number...!");
			num = Utility.scanner.nextDouble();
		}while(num < 0);
		sqrtVal = Utility.sqrtNewtons(num);
		DecimalFormat df = new DecimalFormat(".###");
		System.out.println("Square root of "+num + " : "+df.format(sqrtVal));
	}

}
