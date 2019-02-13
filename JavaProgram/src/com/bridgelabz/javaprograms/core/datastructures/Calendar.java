package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose :  This program takes the month and year as command-line arguments
 *             and prints the calendar for the month.
 *
 *  I/P     : month and year
 *  O/P     : calendor of the given month
 *  
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   19-01-2019
 *  
 *******************************************************************************/
public class Calendar {
	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);    // month (Jan = 1, Dec = 12)
		int year = Integer.parseInt(args[1]);     // year

		// months[i] = name of month i
		String[] months = {
				"",// leave empty so that months[1] = "January"
				"January", "February", "March",
				"April", "May", "June",
				"July", "August", "September",
				"October", "November", "December"
		};

		// days[i] = number of days in month i
		int[] days = {
				0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
		};

		// check for leap year
		if (month == 2 && Utility.isLeapYear(year))
			days[month] = 29;

		// starting day
		int d = Utility.getStartingDay(month, 1, year);

		// print the calendar
		System.out.println("   " + months[month] + " " + year);
		System.out.println(" S  M Tu  W Th  F  S");
		for (int i = 0; i < d; i++)
			System.out.print("   ");
		for (int i = 1; i <= days[month]; i++) {
			System.out.printf("%2d ", i);
			if (((i + d) % 7 == 0) || (i == days[month])) 
				System.out.println();
		}

	}

}
