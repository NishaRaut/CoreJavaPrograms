package com.bridgelabz.javaprograms.core.algorithms;

/****************************************************************************************
 * Purpose : Compute the day of the week for a given date
 *           
 * I/P    :  date
 * O/P    :  day (0-6)
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 15-09-2019
 *****************************************************************************************/
public class DayOfDate {

	public static void main(String[] args) {
		if(args.length == 0 || args.length < 3) {
			System.out.println("Provide Month, Day, year as command-line arguments...!");
			return;
		}
		
		int month;
		int day;
		int year;
		int weekDay;
		
		month = Integer.parseInt(args[0]);
		day = Integer.parseInt(args[1]);
		year = Integer.parseInt(args[2]);
		weekDay = dayOfWeek(month, day, year);
		System.out.println("Given Date : "+month+":"+day+":"+year);
		System.out.println("Day of the given date : " + weekDay);
	}
	
	/**This method find day of the given date 
	 * @param m month of the date
	 * @param d day of the date
	 * @param y year
	 * @return day week day of the given date
	 */
	public static int dayOfWeek(int m, int d, int y) 
	{			
		int y0=y-(14-m)/12;;
		int x = y0+(y0/4)-y0/100+y0/400;
		int m0 = m+12*((14-m)/12)-2;
		int d0 = (d+x+31*m0/12)%7;
		return d0;
	}	
}
