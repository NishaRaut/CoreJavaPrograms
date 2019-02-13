package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/********************************************************************************************
 * Purpose : A program N no. of times and finding the percentage of heads and tails 
 *           
 * I/P    : No. of flipping the coin N
 * O/P    : % of heads and % of tails
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 19-09-2019
 *********************************************************************************************/
public class FlipCoin {

	public static void main(String[] args) {
		int trials = getNumOfTrials();
		double headsPercentage = Utility.percentageOfHeads(trials);
		double tailsPercentage = 100-headsPercentage;
		System.out.print("% of Heads = ");
		System.out.printf("%.2f\n", headsPercentage);
		System.out.print("% of Tails = ");
		System.out.printf("%.2f\n", tailsPercentage);
	}

	//get no. of trials
	public static int getNumOfTrials()
	{
		int trials = 0;
		boolean flag = false;
		while(!flag)
		{
			System.out.println("Enter number of times the coin to be flipped...!");
			trials = Utility.scanner.nextInt();
			if(trials <= 0)
				System.out.println("Enter a positive number...!");
			else
				flag = true;
		}
		return trials;
	}


}
