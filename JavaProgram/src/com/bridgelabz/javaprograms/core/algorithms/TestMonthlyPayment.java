package com.bridgelabz.javaprograms.core.algorithms;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Computation of a monthly payment of the principal amount of P, for an interest
 *           rate of R over a period of Y years compoundedly.
 *           
 * I/P    :  P principal amount,Y period in years,R interest rate
 * O/P    :  monthly payment
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 15-09-2019
 *****************************************************************************************/
public class TestMonthlyPayment {

	public static void main(String[] args) {
		if(args.length < 3) {
			System.out.println("Provide Prinicipal amouint(P),Year(Y) and interest rate (R) "
					+ "as command-line arguments...!");
			return;
		}
		Double p;
		Double y;
		Double r;
		Double payment;

		p = Double.parseDouble(args[0]);
		y = Double.parseDouble(args[1]);
		r = Double.parseDouble(args[2]);
		payment = Utility.monthlyPayment(p, y, r);
		System.out.println("Given Data : p = "+p+"\ty = "+y+"\t r ="+r);
		System.out.printf("Monthly Payment : %.2f", payment);
	}

}
