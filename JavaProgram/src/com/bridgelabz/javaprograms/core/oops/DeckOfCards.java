package com.bridgelabz.javaprograms.core.oops;

/******************************************************************************
 *  Purpose: Implementation of a deck of playing cards
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   27-01-2019
 * 
 ******************************************************************************/
public class DeckOfCards {
	private int size = 52;
	private String[] suite = {"Club","Diamond", "Heart", "Spade"};
	private String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
	private String[] cards = new String[size];

	public DeckOfCards() {
		this.initializeCards();
	}

	/**
	 * initializing the cards in the deck
	 */
	public void initializeCards() {
		int count = 0;
		for (int i = 0; i < rank.length; i++) {
			for(int j = 0; j<suite.length ; j++) {
				cards[count++] = new String(rank[i] + "_" + suite[j]);
			}
		}
	}
	/**
	 * shuffle the cards
	 */
	public void shuffle() {
		for (int i = 0; i < cards.length; i++) {
			String temp = cards[i];
			int shufflePosition = (int)(Math.random()*cards.length);
			cards[i] = cards[shufflePosition];
			cards[shufflePosition] = temp;
		}
	}

	/**
	 * get a card from the deck
	 * @param position
	 * @return
	 */
	public String getACard(int position) {
		return cards[position];
	}
	

	/**
	 * get the rank of a card
	 * @param card a playing card
	 * @return rank
	 */
	public static int rankOfCard(String card) {
		int rank = -1;
		String strValue = card.split("_")[0];
		switch(strValue) {
		case "2" : rank = 2;
		break;
		
		case "3" : rank = 3;
		break;  
		
		case "4" : rank = 4;
		break;
		
		case "5" : rank = 5;
		break;
		
		case "6" : rank = 6;
		break;
		case "7" : rank = 7;
		break;
		case "8" : rank = 8;
		break;
		
		case "9" : rank = 9;
		break;
		
		case "10" : rank = 10;
		break;
		
		case "Jack" : rank = 11;
		break;
		
		case "Queen" : rank = 12;
		break;
		
		case "King" : rank = 13;
		break;
		
		case "Ace" : rank = 14;
		break;
		}
		return rank;
	}
	
}
