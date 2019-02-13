package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Simulates a stop watch and prints the time elapsed between start and stop.
 *           
 * I/P    : start , stop as integers
 * O/P    : elapsed time in hh:mm:sec format
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 11-09-2019
 *****************************************************************************************/
public class StopWatch {
	private long startTime;
	private long endTime;

	/**
	 * starts the stopwatch
	 */
	public void start() {
		startTime = System.currentTimeMillis();
	}

	/**
	 * stops the stopwatch
	 */
	public void stop() {
		endTime = System.currentTimeMillis();
	}

	/**
	 * calculate the time taken
	 * @return elapsed time
	 */
	public long timeElapsed() {
		return (endTime - startTime);
	}

	public static void main(String[] args) {
		StopWatch sw = new StopWatch();
		int start;
		int end;
        long timeTaken ;
		//starting the stop watch
		do {
			System.out.println("Enter 1 to start the stopwatch...!");
			start = Utility.getPositiveInt();
		}while(start!=1);
		sw.start();

		//stopping the stop watch 
		do {
			System.out.println("Enter 2 to stop the stopwatch...!");
			end = Utility.getPositiveInt();
		}while(end!=2);
		sw.stop();

		//display elpased time
		timeTaken = sw.timeElapsed();
		Utility.printTime(timeTaken);

	}

}
