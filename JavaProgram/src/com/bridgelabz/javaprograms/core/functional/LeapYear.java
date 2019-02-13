package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: Program to check the year is Leap Year or Not
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   09-01-2019
 *
 ******************************************************************************/
public class LeapYear {

	public static void main(String[] args) {
		int year = getYear();
		if(Utility.isLeapYear(year))
			System.out.println(year + " is a leap year");
		else
			System.out.println(year +" is not a leap year");
	}

	/**
	 * to read the 4-digit year
	 * @return
	 */
	public static int getYear()
	{
		int year = 0;
		boolean flag = false;
		System.out.println("Enter a 4-digits number...!");
		while(!flag)
		{
			year = Utility.scanner.nextInt();
			if(Integer.toString(year).length() < 4 || year <= 0)
				System.out.println("Enter a 4-dgit +ve number...!");
			else
				flag = true;
		}
		return year;
	}


}
