package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : A program that takes two integer command-line arguments x and y and prints 
 *           the Euclidean distance from the point (x, y) to the origin (0, 0). 
 *           The formulae to calculate distance = sqrt(x*x + y*y).

 * I/P    : A point (X,Y)
 * O/P    : Euclidean distance from origin to the point (X,Y)
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 10-09-2019
 *****************************************************************************************/
public class Distance {

	public static void main(String[] args) {
       try {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		double distance = Utility.euclidianDistance(x, y);
		System.out.println("Euclidian distance of point p("+x+","+y+") = "+distance);
	} catch (Exception e) {
		System.out.println("Enter valid input arguments");
		System.out.println(e.getMessage());
	}
	}

}
