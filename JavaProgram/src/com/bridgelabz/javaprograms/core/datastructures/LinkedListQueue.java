package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.NodeFactory;

/******************************************************************************
 *  Purpose: Implementation of a generic linear queue
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   19-01-2019
 *  @param <T> Item type
 *******************************************************************************/
public class LinkedListQueue<T> {
	public Node<T> front;
	public Node<T> rear ;
	private int size;

	public LinkedListQueue() {
		front = null;
		rear = null;
		size = 0;
	}
	
	/**
	 * gives the current no. of items present in the queue
	 * @return size
	 */
	public int size() {
		return size;
	}

	/**
	 * tests whether the queue is empty or not
	 * @return true if queue is empty otherwise false
	 */
	public boolean isEmpty() {
     return (size == 0);
	}


	/**
	 * adds an item to the queue
	 * @param item
	 */
	public void enqueue(T item) {
		Node<T> node = NodeFactory.getNode(item);
		if(size==0) {//first node
			front = rear = node;
		}
		else {
			rear.setNext(node);
			rear = node;
		}
		size++;
	}

	/**
	 * removes an item from the front of the queue
	 * @return fron most item
	 */
	public T dequeue() {
		if (isEmpty()) 
		{
			System.out.println("Queue is empty...Enqueue some items before dequeuing it...!");
			System.exit(1);
		}
		T item = front.getData();
		front = front.getNext(); 
		size = size - 1; 
		return item; 
	}
	/**
	 * gives the position of the front most item
	 * @return front
	 */
	public Node<T> getFront() {
		return front;
	}
	/**
	 * gives the position of the last item
	 * @return rear
	 */
	public Node<T> getRear() {
		return rear;
	}
	
	
}
