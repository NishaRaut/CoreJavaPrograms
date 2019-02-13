package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.Constants;

/******************************************************************************
 *  Purpose: Implementation of a generic stack
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   18-01-2019
 *  @param <T> Item type
 *******************************************************************************/

public class Stack<T> {
	T[] items;
	int top;
    final int capacity = Constants.STACKSIZE;
	@SuppressWarnings("unchecked")
	public Stack() {
		items = (T[]) new Object[capacity];
		top = -1;
	}

	/**
	 * pushes an item on to the stack
	 * @param item item to be pushed
	 */
	public void push(T item) {
		items[++top] = item;
	}

	/**
	 * removes and returns the top most item from the stack
	 * @return top most item
	 */
	public T pop() {
		return items[top--];
	}

	/**
	 * checks the stack is empty
	 * @return true if empty otherwise false
	 */
	public boolean isEmpty() {
		if(top < 0)
			return true;
		else
			return false;
	}

	/**
	 * gives current size of the stack
	 * @return the no. of items in the stack
	 */
	public int size()
	{
		if(!isEmpty())
			return top + 1;
		else
			return 0;
	}
	
	/**
	 * returns the top most item in the stack
	 * @return top most item
	 */
	public T peak() {
		return items[top];
	}
	
	/**
	 * returns the position of the top most item
	 * @return top
	 */
	public int getStackCapacity() {
		return capacity;
	}
}
