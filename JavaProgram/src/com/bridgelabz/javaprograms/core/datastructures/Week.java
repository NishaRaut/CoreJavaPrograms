package com.bridgelabz.javaprograms.core.datastructures;

/******************************************************************************
 *  Purpose: To hold the dates of a week of a month
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   23-01-2019
 * 
 ******************************************************************************/
public class Week {
	private int[] dates;

	/**
	 * getter of dates
	 * @return
	 */
	public int[] getDates() {
		return dates;
	}
	
	/**
	 * setter of dates
	 * @param dates
	 */
	public void setDates(int[] dates) {
		this.dates = dates;
	}
}
