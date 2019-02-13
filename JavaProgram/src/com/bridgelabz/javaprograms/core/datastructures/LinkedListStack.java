package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.NodeFactory;

/******************************************************************************
 *  Purpose: Implementation of stack data structure using linked list 
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   22-01-2019
 * 
 ******************************************************************************/
public class LinkedListStack<T> {
	private Node<T> top;
	private int size;
	public LinkedListStack() {
		this.top = null;
		this.size = 0;
	}

	/**
	 * pushes an item on the stack
	 * @param item item to be pushed
	 */
	public void push(T item) {
		Node<T> node = NodeFactory.getNode(item);
		node.setNext(top);
		top = node;
		size++;
	}

	/**
	 * pops the top most item from the stack
	 * @return top most item in the stack
	 */
	public T pop() {
		T item = null;
		try {
			item = top.getData();
			top = top.getNext();
			size--;
		}
		catch(Exception e) {
			System.out.println("Stack Underflow...!");
		}
		return item;
	}

	/**
	 * gives the reference of the top most item 
	 * @return top 
	 */
	public Node<T> getTop(){
		return top;
	}

	/**
	 * gives the current no. of items in the stack
	 * @return
	 */
	public int getSize() {
		return size;
	}
}
