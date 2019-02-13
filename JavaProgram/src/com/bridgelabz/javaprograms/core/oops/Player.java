package com.bridgelabz.javaprograms.core.oops;

import com.bridgelabz.javaprograms.core.datastructures.LinkedListQueue;
import com.bridgelabz.javaprograms.core.datastructures.Node;
import com.bridgelabz.javaprograms.core.util.NodeFactory;

/******************************************************************************
 *  Purpose: To implement the player object of playing cards
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   27-01-2019
 * 
 ******************************************************************************/
public class Player{
	private int palyerNumber;
	private LinkedListQueue<String> cards;	

	/**
	 * setter to set the cards of a player
	 * @param a queue of cards
	 */
	public void setCards(LinkedListQueue<String> cards) {
		this.cards = cards;
	}
	
	/**
	 * returns q queue of cards of a player
	 * @return queue of cards
	 */
	public LinkedListQueue<String> getCards() {
		return this.cards;
	}
	
	/**
	 * setter for the player number
	 * @param num player number
	 */
	public void setPlayerNumber(int num) {
		palyerNumber = num;
	}
	
	/**
	 * getter for the player number
	 * @return player number
	 */
	public int getPlayerNumber() {
		return palyerNumber;
	}
	
	/**
	 * sorts the cards of a player
	 */
	public void sortCards() {
      Node<String> sourceCurr = cards.front;
      Node<String> head = null;
      Node<String> tail = null;
      
      while(sourceCurr != null) {
    	  Node<String> newNode = NodeFactory.getNode(sourceCurr.getData());
    	  if(head == null) {
    		  head = newNode;
    		  tail = head;
    	  }
    	  else {
    		  Node<String> curr = head;
    	      Node<String> prev = null;
    	      int rankOfNewNode = DeckOfCards.rankOfCard(newNode.getData());
    		  while(curr!= null) {
    			  int rankOfCurr = DeckOfCards.rankOfCard(curr.getData());
    			  if(rankOfCurr < rankOfNewNode) {
    				  prev = curr;
    				  curr = curr.getNext();
    			  }
    			  else if(prev==null){         //inserted at front
    				  newNode.setNext(head);
    				  head = newNode;
    				  break;
    			  }
    			  else { //insertion in between
    				  newNode.setNext(curr); 
    				  prev.setNext(newNode);
    				  break;
    			  }
    		  }
    		  if(curr == null) {  //insertion at the end
    			  prev.setNext(newNode);
    			  tail = newNode;
    		  }
    	  }
    	  sourceCurr = sourceCurr.getNext(); 
      }
      cards.front = head;
      cards.rear = tail;
	}
	
	/**
	 * get the ranks of a set of cards
	 * @param cards a queue of cards
	 * @return integer array of ranks
	 */
	public static int[] getRanks(LinkedListQueue<String> cards) {
		int[] ranks = new int[cards.size()]; // storing the ranks of all the cards in array
        Node<String> curr = cards.front;
        int i= -1;
        while(curr != null) {
        	ranks[++i] = DeckOfCards.rankOfCard(curr.getData());
        	curr = curr.getNext();
        }
        return ranks;
	}
}
