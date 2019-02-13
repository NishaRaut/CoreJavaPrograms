package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: prints prime factors of a given number
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   09-01-2019
 *
 ******************************************************************************/
public class Gambler {
	public static void main(String[] args) {
		System.out.println("Enter initial stake...!");
		int stake = Utility.getPositiveInt();
		System.out.println("Enter your goal...!");
		int goal = Utility.getPositiveInt();
		System.out.println("Enter No. of times you want to play...!");
		int trials = Utility.getPositiveInt();
		playGame(stake, goal, trials);
	}

	/**
	 * plays the gambling i.e betting and return no. of wins
	 *  
	 * @param stake initial money 
	 * @param goal target for the win
	 * @param trials no. of times you wanna play the game
	 * @return no. of wins you made
	 */
	public static void playGame(int stake, int goal, int trials) {
		int wins = 0;
		int bets = 0;
		for(int i = 1; i <= trials ; i++) {
			int cash = stake;
			//play until he/she wins/loose the game
			while( cash > 0 && cash < goal) {
				bets++;
				if(Math.random() >= 0.5)// $1 per bet
					cash++;
				else
					cash--;		   
			}
			if(cash == goal)
				wins++;
		}
		System.out.println("Total no. of bets made  = "+bets);
		System.out.println("Total no. of wins = "+ wins);
		double winPercentage = (wins*100.0)/trials;
		System.out.println("Win % = "+winPercentage);
		System.out.println("Loss % = "+(100-winPercentage));
	}

}
