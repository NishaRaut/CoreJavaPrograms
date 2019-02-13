package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Finding the roots of a quadratic equation.
 *           
 * I/P    : variable a,b and c
 * O/P    : prints two roots
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 11-09-2019
 *****************************************************************************************/
public class Quadratic {
	public static void main(String[] args) {
		System.out.println("Enter 3 inputs for 'a' , 'b', and 'c'...!" );
		double a = Utility.getDouble();
		double b = Utility.getDouble();
		double c = Utility.getDouble();
		
		System.out.println("Roots of "+a+"x*x + "+b+"x +"+c);
		double[] roots = quadraticRoots(a, b, c);
		if(roots != null) {
			for(double root : roots) {
				System.out.println(root);
			}
		}
	}
	
	/**
	 * computes and returns the two roots of a quadratic equation 
	 * 
	 * @param a variable 
	 * @param b variable
	 * @param c constant
	 * @return array of roots
	 */
	public static double[] quadraticRoots(double a, double b, double c) {
		double[] roots = new double[2];
		//check for division by zero
		if(a == 0.0) {
			System.out.println("can't find the quadritc roots for an equation of degree less than 2...!");
			return roots = null;
		}

		double delta = b*b-4*a*c;
		roots[0] = (-b+Math.sqrt(delta))/(2*a);
		roots[1] = (-b-Math.sqrt(delta))/(2*a);
		return roots;
	}
}
