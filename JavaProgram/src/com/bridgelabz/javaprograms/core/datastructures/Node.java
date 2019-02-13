package com.bridgelabz.javaprograms.core.datastructures;

/******************************************************************************
 *  Purpose: Used to create a generic node of a singly linked list 
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   17-01-2019
 * @param <T> type of the items
 *  
 *******************************************************************************/
public class Node<T> implements Comparable<T>{

	private T data;
	private Node<T> next;

	/**
	 * assigns the item to the node
	 * @param item data of the node
	 */
	public void setData(T item)
	{
		this.data = item;
	}

	/**
	 * gives the data of the node
	 * @return data of the node
	 */
	public T getData() {
		return data;
	}

	/**
	 * updates the nodes next link
	 * @param node next node
	 */
	public void setNext(Node<T> node) {
		this.next = node;
	}

	/**
	 * returns the next link of the node
	 * @return next node reference
	 */
	public Node<T> getNext(){
		return this.next;
	}

	/**
	 * compares the two items for the equality
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object item) 
	{
		if(this.getData().equals((T)item))
			return true;
		else
			return false;
	}

	/**
	 * compares the two items
	 * @return 0 if equal, + value if greater than passed arg, else - value
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(T otherItem) {
		return ((Comparable<T>) this.getData()).compareTo(otherItem);
	}
}
