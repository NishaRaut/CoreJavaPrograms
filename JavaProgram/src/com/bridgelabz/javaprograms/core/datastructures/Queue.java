package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.Constants;

/******************************************************************************
 *  Purpose: Implementation of a generic linear queue
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   19-01-2019
 *  @param <T> Item type
 *******************************************************************************/
public class Queue<T> {
	private T[] items;
	private int front;
	private int rear ;
	private int size;
	private final int capacity;

	@SuppressWarnings("unchecked")
	public Queue() {
		capacity = Constants.QUEUESIZE;
		items = (T[])new Object[capacity];
		front = 0;
		rear = -1;
		size = 0;
	}
	
	//Creating a queue with custom capacity
	@SuppressWarnings("unchecked")
	public Queue(int customCapacity) {
		capacity = customCapacity;
		items = (T[])new Object[capacity];
		front = 0;
		rear = -1;
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
		if(size == 0)
			return true;
		else
			return false;
	}

	/**
	 * tests whether the Queue is full or not
	 * @return true if queue is full otherwise false
	 */
	boolean isFull() {
		return (size == capacity); 
	} 

	/**
	 * adds an item to the queue
	 * @param item
	 */
	public void enqueue(T item) {
		if (isFull()) 
		{
			System.out.println("Queue is full...Remove some items before enqueuing...!");
			return; 
		}	
		rear = (rear +1) % capacity;
		items[rear] = item;
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
		T item = items[front]; 
		front = (front + 1) % capacity; 
		size = size - 1; 
		return item; 
	}
	/**
	 * gives the position of the front most item
	 * @return front
	 */
	public int getFront() {
		return front;
	}
	/**
	 * gives the position of the last item
	 * @return rear
	 */
	public int getRear() {
		return rear;
	}
}
