package com.bridgelabz.javaprograms.core.datastructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bridgelabz.javaprograms.core.util.NodeFactory;
import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: Implementation of generic singly linked list
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   17-01-2019
 *  @param <T> type of the items
 *  
 *******************************************************************************/
public class UnOrderedList<T> {
	private Node<T> first;
	private Node<T> last;

	/**
	 * default constructor
	 */
	public UnOrderedList(){
		first  = null;
		last = null;
	}

	/**
	 * adds an item to the list if its not present
	 * @param item otem to be added
	 */
	public void add(T item) {
		if(isEmpty())
		{
			first = NodeFactory.getNode(item);
			last = first;
			return;
		}
		if(search(item))
			System.out.printf("Item already exits in the list...!");
		else
          append(item);
	}

	/**
	 * removes the specified item from the list if its present
	 * @param item
	 */
	public void remove(T item) {
		Node<T>	temp = null;
		Node<T> curr = null;
		if(isEmpty())
			System.out.println("List is empty...!");
		else if(first.getData().equals(item) && first.getNext() == null)// one item list
		{
			first = null;
			last = null;
		}
		else if(first.getData().equals(item) && first.getNext() != null)
		{
			//update only first
			temp = first;
			first = first.getNext();
			temp = null;
		}
		else {
			temp = first;
			curr = first.getNext();
			while(curr != null) {
				if(curr.getData().equals(item))
				{
					temp.setNext(curr.getNext());
					curr.setNext(null);
					break;
				}
				else {
					temp = curr;
					curr = curr.getNext();
				}
			}
		}
	}
	/**
	 * check the item is present in the list
	 * @param item key to be searched in the list
	 * @return true if key exists in the list else false
	 */
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
	/**
	 * check  for emptiness of the list
	 * @return true if empty else false
	 */
	public boolean isEmpty() {
		if(first == null)
			return true;
		else
			return false;
	}
	/**
	 * current no. of items in the list
	 * @return size
	 */
	public int size() {
		int count = 0;
		Node<T> temp = first;
		while(temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	/**
	 * adding at the end of the list 
	 * @param item item to be added
	 */
	public void append(T item) {
		if(isEmpty())
		{
			first = NodeFactory.getNode(item);
		}
		else if(search(item))
			System.out.printf("Item already exits in the list...!");
		else {
			Node<T> newNode = NodeFactory.getNode(item);
			last.setNext(newNode);
			last = newNode;
		}
	}

	/**
	 * insertion at a given position
	 * @param pos position where the item to be inserted
	 * @param item the item to be inserted
	 */ 
	public void insert(int pos,T item) {
		Node<T>	prev = first;
		Node<T> curr = first;
		Node<T> newNode = NodeFactory.getNode(item);
		int  count = -1;
		while(curr != null) {
			count++;
			if(count == pos && count == 0)// insertion at 0th position, update first
			{
				newNode.setNext(curr);
				first = newNode;
				break;
			}
			else if(count == pos) {
				newNode.setNext(curr);
				prev.setNext(newNode);
				break;
			}
			prev = curr;
			curr = curr.getNext();
		}
		if(curr == null && pos == count +1)//insertion after the last, update last
		{
			prev.setNext(newNode);
			last = newNode;
		}
		else {
			System.out.println("Given position is not found in the lsit...!");
		}
	}

	/**
	 * removes and returns the last item in the list
	 * @return last item in the last
	 */
	public T pop() {
		if(isEmpty())
		{
			System.out.println("List is empty...!");
			return null;
		}
		if(first == last) {//remove the only item in the list
			first = last = null;
			return first.getData();
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

	/**
	 * removes and returns item at the given position
	 * @param pos items position
	 * @return pos positioned item
	 */
	public T pop(int pos) {
		if(isEmpty())
		{
			System.out.println("List is empty...!");
			return null;
		}
		Node<T> curr = first;
		Node<T> prev = first;

		int  count = -1;
		while(curr != null) {//traverse to reach the last item in the list
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
	
	/**
	 * index of the specified item in the list
	 * @param item item whose positioned to be found
	 * @return position of item
	 */
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
	
	/**
	 * display the nodes of the list
	 */
	public void printList() {
		Node<T> curr = first;
		while(curr != null) {
			System.out.print("\t" +curr.getData());
			curr = curr.getNext();
		}
		System.out.println();
	}
	
	/**
	 * writing the list data to a file
	 * @param list linked list
	 * @param filePath destination file path
	 */
	public void writeToFile(UnOrderedList<T> list, String filePath) {
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
		String path = "resource/unordered.txt";
		String[] words;
		String line= "";
		String key;
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String temp = null;
			while((temp = br.readLine())!= null)
			{
				line += temp;
			}
			words = line.split(",");
			//create a linked list for the words
			UnOrderedList<String> list = new UnOrderedList<>();
			for(int i = 0; i < words.length ; i++) {
				list.add(words[i]);
			}
			System.out.println("***************** Words list : *****************************");
			//display data of each node in the list
			list.printList();
	        //read the key to be searched
			do {
				System.out.println("************** Enter the key...! **********************");
				key = Utility.getString();
			}while(key.trim().equals("") || key == null);

			boolean isKeyPresent = list.search(key);
			if(isKeyPresent) {
				System.out.printf("\nkey '%s' is present in the list\n",key);
				list.remove(key);
			}	
			else {
				System.out.printf("\nkey '%s' is not present in the list\n",key);
				list.add(key);
			}
			//display data of each node in the list
			list.printList();
			list.writeToFile(list, path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}//end of class
