package com.bridgelabz.javaprograms.core.oops;

import com.bridgelabz.javaprograms.core.datastructures.LinkedListQueue;
import com.bridgelabz.javaprograms.core.datastructures.Node;

/******************************************************************************
 *  Purpose: Tester class to test the DeckOfCards and Players classes
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   27-01-2019
 * 
 ******************************************************************************/
public class TestDeckOfCards {

	public static void main(String[] args) {
		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		String[][] players = distributeCards(deck, 4, 9);  //distributing cards to 4 players to get 9 each
		printCardsOfAllPlayers(players);   //print the cards of each player

		//<--------------Queue version of Deck of Cards -------------------->
		Player p1 = new Player();
		p1.setPlayerNumber(1);
		LinkedListQueue<String> p1Cards = new LinkedListQueue<>();
		getCardsQueueOfPlayer(1,p1Cards,players);
		p1.setCards(p1Cards);
		p1.sortCards();

		Player p2 = new Player();
		p2.setPlayerNumber(2);
		LinkedListQueue<String> p2Cards = new LinkedListQueue<>();
		getCardsQueueOfPlayer(2,p2Cards,players);
		p2.setCards(p2Cards);
		p2.sortCards();

		Player p3 = new Player();
		p3.setPlayerNumber(3);
		LinkedListQueue<String> p3Cards = new LinkedListQueue<>();
		getCardsQueueOfPlayer(3,p3Cards,players);
		p3.setCards(p3Cards);
		p3.sortCards();

		Player p4 = new Player();
		p4.setPlayerNumber(4);
		LinkedListQueue<String> p4Cards = new LinkedListQueue<>();
		getCardsQueueOfPlayer(4,p4Cards,players);
		p4.setCards(p4Cards);
		p4.sortCards();

		LinkedListQueue<Player> playersQue = new LinkedListQueue<>();
		playersQue.enqueue(p1);
		playersQue.enqueue(p2);
		playersQue.enqueue(p3);
		playersQue.enqueue(p4);
		System.out.println("\n\nPlayers and their cards with sorting...!");
		System.out.println("=======================================================================================");
		printAllPlayersInQueue(playersQue);
	}
	public static void printAllPlayersInQueue(LinkedListQueue<Player> playersQue) {
		Node<Player> curr = playersQue.front;
		while(curr != null) {
			Player player = curr.getData();
			printCardsOfAPlayer(player);
			curr = curr.getNext();
		}
	}
	public static void printCardsOfAPlayer(Player p) {
		LinkedListQueue<String> cards = p.getCards();
		System.out.print(p.getPlayerNumber()+"    ");
		Node<String> curr = cards.front;
		while(curr != null) {
			System.out.print("   "+curr.getData());
			curr = curr.getNext();
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * distribute the cards from the deck to each player
	 * @param deck a fresh deck of 52 cards
	 */
	public static String[][] distributeCards(DeckOfCards deck, int numOfPlayers, int numOfCards) {
		String players[][] = new String[numOfPlayers][numOfCards];
		int cardCount = 0;
		for (int i = 0; i < numOfCards; i++) {//no. of cards each player has to get
			for (int j = 0; j < numOfPlayers; j++) {//no. of players
				players[j][i] = deck.getACard(cardCount++); 
			}
		}
		return players;
	}

	/**
	 * print the cards of each player
	 */
	public static void printCardsOfAllPlayers(String[][] players) {
		System.out.println("Player \t Cards");
		System.out.println("=========================================================================");
		for(int i = 0 ; i < players.length; i++) {//no. of playres
			System.out.print(i+1+"   \t");
			for(int j=0 ; j< players[i].length ; j++) {//no. of cards
				System.out.print(players[i][j]+"   ");
			}
			System.out.println("\n");
		}
	}

	/**
	 * getting the cards of a player in a queue from a 2D array
	 * @param playerNum player number
	 * @param cardsQueue queue of cards
	 * @param players 2D array of cards of all players
	 */
	public static void getCardsQueueOfPlayer(int playerNum,LinkedListQueue<String> cardsQueue,String[][] players){
		for(int i = 0; i < players[playerNum -1].length;i++) {
			String card = new String(players[playerNum -1][i]);
			cardsQueue.enqueue(card);
		}
	}

}
