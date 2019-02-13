package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.Constants;

/******************************************************************************
 *  Purpose: Implementation of a generic dequeue
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   21-01-2019
 *  @param <T> Item type
 *******************************************************************************/
public class Deque<T> {
	private T[] items;
	private int front;
	private int rear ;
	private int size;
	private final int capacity;
	@SuppressWarnings("unchecked")
	public Deque() {
		capacity = Constants.QUEUESIZE;
		items = (T[])new Object[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}

	//Creating a queue with custom capacity
	@SuppressWarnings("unchecked")
	public Deque(int customCapacity) {
		capacity = customCapacity;
		items = (T[])new Object[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}

	/**
	 * gives the current no. of items present in the deque
	 * @return no. of items present in the deque
	 */
	public int size() {
		return size;
	}

	/**
	 * tests the deque is empty or not
	 * @return true or false
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * tests the deque is full or not
	 * @return true or false
	 */
	public boolean isFull() {
		return size == capacity;
	}

	/**
	 * enque the item from the front end
	 * @param item item to be enqueued
	 */
	public void addFront(T item) {
		if(front == -1 && rear == -1)//empty queue
		{
			items[++front] = item;
			rear = front;
			size++;
		}
		else if(rear < capacity -1) {
			front = (front -1) % capacity;
			items[front] = item;
			size++;
		}
	}

	/**
	 * enque the item from the rear end
	 * @param item item to be enqueued
	 */
	public void addRear(T item) {
		if(front == -1 && rear == -1)//empty queue
		{
			items[++rear] = item;
			front = rear;
			size++;
		}
		else {
			rear = (rear + 1) % capacity;
			items[rear] = item;
			size++;
		}
	}

	/**
	 * deque the item from the front end
	 */
	public T removeFront() {
		T item;
		if(front == rear)//single item queue
		{
			item = items[front];
			front = rear = -1;
		}
		else{
			item = items[front];
			front = (front + 1) % capacity;
		}
		size--;
		return item;
	}

	/**
	 * deque the item from the rear end
	 */
	public T removeRear() {
		T item;
		if(rear == front)//single item queue
		{
			item = items[front];
			rear = front = -1;
		}
		else{
			item = items[rear];
			rear = (rear - 1) % capacity;
		}
		size--;
		return item;
	}
}
