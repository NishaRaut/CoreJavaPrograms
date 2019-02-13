package com.bridgelabz.javaprograms.core.datastructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;

import com.bridgelabz.javaprograms.core.util.NodeFactory;
import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: Implementation of generic singly linked list whose items are in ascending order
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   18-01-2019
 *  @param <T> type of the items
 *  
 *******************************************************************************/
public class OrderedList<T> {
	private Node<T> first;
	private Node<T> last;

	//default constructor
	public OrderedList(){
		first  = null;
		last = null;
	}

	//public add 
	public void add(T item) {
		if(isEmpty())
		{
			first = NodeFactory.getNode(item);
			last = first;
			return;
		}
		if(!search(item)) {
			Node<T> newNode = NodeFactory.getNode(item);
			Node<T> curr = first;
			Node<T> prev = null;
			while(curr != null && curr.compareTo(item) < 0) {
				prev = curr;
				curr = curr.getNext();
			}
			if(curr != null && curr == first) {//at first position
				newNode.setNext(curr);
				first = newNode;
			}
			else if(curr != null) {// in-between position
				prev.setNext(newNode);
				newNode.setNext(curr);
			}
			else {//last position
				last.setNext(newNode);
				last = newNode;
			}
		}
		else
			System.out.printf("Item already exits in the list...!");
	}

	//remove item
	public void remove(T item) {
		Node<T>	temp = null;
		Node<T> curr = null;
		if(isEmpty())
			System.out.println("List is empty...!");
		else if(first.getData().equals(item) && first.getNext() == null)// one item list
		{
			first = null;
			last = null;
			//System.out.println(item + " removed from the list...!");
		}
		else if(first.getData().equals(item) && first.getNext() != null)
		{
			//update only first
			temp = first;
			first = first.getNext();
			temp = null;
			System.out.println(item + " removed from the list...!");
		}
		else {
			temp = first;
			curr = first.getNext();
			while(curr != null) {
				if(curr.getData().equals(item))
				{
					temp.setNext(curr.getNext());
					curr.setNext(null);
					System.out.println(item + " removed from the list...!");
					break;
				}
				else {
					temp = curr;
					curr = curr.getNext();
				}
			}
		}
	}
	//check the item is present in the list
	public boolean search(T item) {
		if(first == null)
			return false;
		Node<T> temp = first;
		while(temp != null) {
			if(temp.getData().equals(item))
				return true;
			temp = temp.getNext();
		}
		return false;
	}

	//remove and return the last item in the list
	public T pop() {
		if(isEmpty())
		{
			System.out.println("List is empty...!");
			return null;
		}
		if(first == last) {//remove the only item in the list
			Node<T> temp = first;
			first = last = null;
			return temp.getData();
		}
		Node<T> curr = first;
		Node<T> prev = first;
		while(curr.getNext() != null) {//traverse to reach the last item in the list
			prev = curr;
			curr = curr.getNext();
		}
		//remove the curr item which is the last item in the list
		last = prev;
		last.setNext(null);
		return curr.getData();
	}

	//remove and return item at the given position
	public T pop(int pos) {
		if(isEmpty())
		{
			System.out.println("List is empty...!");
			return null;
		}
		Node<T> curr = first;
		Node<T> prev = first;

		int  count = -1;
		while(curr != null) {//traverse to reach to reach the given position
			count++;
			if(count == pos && count == 0)// removal at 0th position, update first
			{
				first = curr.getNext();
				curr.setNext(null);
				return curr.getData();
			}
			else if(count == pos && curr == last) {// remoavl at the last position
				last = prev;
				last.setNext(null);
				return curr.getData();
			}
			else if(count == pos){//removal in-between
				prev.setNext(curr.getNext());
				curr.setNext(null);
				return curr.getData();
			}
			prev = curr;
			curr = curr.getNext();
		}
		System.out.println("Given position is not found in the lsit...!");
		return null;
	}
	//check  empty
	public boolean isEmpty() {
		if(first == null)
			return true;
		else
			return false;
	}
	//size of list
	public int size() {
		int count = 0;
		Node<T> temp = first;
		while(temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	public int index(T item) {
		if(isEmpty())
		{
			System.out.println("List is empty...!");
			return -1;//error case
		}
		Node<T> curr = first;
		int  count = -1;
		while(curr != null) {
			count++;
			if(curr.getData() == item)
				return  count;
		}
		System.out.println(item + "not found in the list...!");
		return -1;
	}
	//display the nodes of the UnorderedList
	public void printOrderedList() {
		Node<T> curr = first;
		while(curr != null) {
			System.out.print("  " +curr.getData());
			curr = curr.getNext();
		}
		System.out.println();
	}

	//
	public void writeToFile(OrderedList<T> list, String filePath) {
		if(list == null)
			return;

		Node<T> curr = first;
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,false))){
			while(curr != null) {
				bw.write(curr.getData().toString()+",");
				curr = curr.getNext();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String path = "resource/numbers.txt";
		String[] numbers;
		String line= "";
		int key;

		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String temp = null;
			while((temp = br.readLine())!= null)
			{
				line += temp;
			}
			numbers = line.split(",");
			//create a linked list for the words
			OrderedList<Integer> list = new OrderedList<>();
			for(int i = 0; i < numbers.length ; i++) {
				list.add(Integer.parseInt(numbers[i]));
			}
			System.out.println("***************** Numbers list : *****************************");
			//display data of each node in the list
			list.printOrderedList();
			//read the key to be searched
			System.out.println("************** Enter the key...! **********************");
			try {
				key = Utility.getInt();
				boolean isKeyPresent = list.search(key);
				if(isKeyPresent) {
					System.out.printf("key '%s' is present in the list\n",key);
					list.remove(key);
				}
				else {
					System.out.printf("key '%s' is not present in the list\n",key);
					list.add(key);
				}
				//display data of each node in the list
				list.printOrderedList();
			}
			catch(InputMismatchException e) {
				System.out.println("Key must be a number ...!");
			}
			//write back the list to file
			list.writeToFile(list,path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
  
	/**
	 * gives the first pointer
	 * @return
	 */
	public Node<T> getFirst(){
		return this.first;
	}
}
