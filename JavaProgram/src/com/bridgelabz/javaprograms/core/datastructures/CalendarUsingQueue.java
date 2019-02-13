package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: To print the calendar of a month using the queue of nodes
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   23-01-2019
 * 
 ******************************************************************************/
public class CalendarUsingQueue {

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
		int startDay = Utility.getStartingDay(month, 1, year);//0=>Sun,1=>Mon,etc
		
		//find the no.of weeks 
		int numOfWeeeks = (startDay + days[month]) / 7;
		if((startDay + days[month]) % 7 != 0)
			numOfWeeeks++;
		
		LinkedListQueue<Week> weeks = new LinkedListQueue<>();
		//get first week of the month
		Week first = getFirstWeekOfMonth(startDay);
		weeks.enqueue(first);
		int nextStartDate = (7 - startDay) + 1;
		for(int i = 2 ; i <= numOfWeeeks ; i++) {
			Week otherweek = getOtherWeekOfMonth(days[month], nextStartDate);
			weeks.enqueue(otherweek);
			nextStartDate = nextStartDate + 7;
		}
		Week[] weeksArr = new Week[numOfWeeeks];
		int weekCount = -1;
		// print the Month Calendar by poping off the weeks from the queue
		System.out.println("\nCalendar using Queue...!\n");
		System.out.println("   " + months[month] + " " + year);
		System.out.println(" S  M Tu  W Th  F  S");
		while(weeks.size() > 0) {
			Week wk = weeks.dequeue();
			weeksArr[++weekCount] = wk;			//add to week array
			int[] arr = wk.getDates();
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == 0)
					System.out.print("   ");
				else
					System.out.printf("%2d ", arr[i]);
			}
			System.out.println();
		}
		
		//stack version of calendar
		LinkedListStack<Week> weekStack = new LinkedListStack<>();
		for (int i = weeksArr.length -1; i >= 0; i--) {
			weekStack.push(weeksArr[i]);
		}
		//pop off the weeks from the stack and display the calendar
		System.out.println("\nCalendar using stack...!\n");
		System.out.println("   " + months[month] + " " + year);
		System.out.println(" S  M Tu  W Th  F  S");
		while(weekStack.getSize() > 0) {
			Week wk = weekStack.pop();
			int[] arr = wk.getDates();
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == 0)
					System.out.print("   ");
				else
					System.out.printf("%2d ", arr[i]);
			}
			System.out.println();
		}
	}

	/**
	 * get the first week of the month
	 * @param startDay first day of the month
	 * @return first week of the month
	 */
	public static Week getFirstWeekOfMonth(int startDay) {
		Week wk =null;
		switch(startDay){
		case 0 : wk = new Week();
		wk.setDates(new int[]{1,2,3,4,5,6});
		break;

		case 1 : wk = new Week();
		wk.setDates(new int[]{0,1,2,3,4,5,6});
		break;

		case 2 : wk = new Week();
		wk.setDates(new int[]{0,0,1,2,3,4,5});
		break;

		case 3 : wk = new Week();
		wk.setDates(new int[]{0,0,0,1,2,3,4});
		break;

		case 4 : wk = new Week();
		wk.setDates(new int[]{0,0,0,0,1,2,3});
		break;

		case 5 : wk = new Week();
		wk.setDates(new int[]{0,0,0,0,0,1,2});
		break;

		case 6 : wk = new Week();
		wk.setDates(new int[]{0,0,0,0,0,0,1});
		break;
		}
		return wk;
	}

	/**
	 * gives the week other than first week of the month
	 * @param days number of days in the month
	 * @param startDateOfWeek starting date of the week
	 * @return a week other than first week
	 */
	public static Week getOtherWeekOfMonth(int days, int startDateOfWeek) {
		int[] dates = new int[7];
		int count = 0;
		for(int i = startDateOfWeek; i <= days && count < 7; i++) {
			dates[count++] = i;
		}
		Week week = new Week();
		week.setDates(dates);
		return week;
	}
}
