package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: Testing an input string is palindrome or not using a deque
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   21-01-2019
 *******************************************************************************/
public class PalindromeChecker {

	public static void main(String[] args) {
		System.out.println("Enter the string to be checked for palindrome or not...!");
		String input = Utility.getString();
		Deque<Character> dq = new Deque<>();
       
        int i=0;
        char ch;
        //insert all the characters of the string from left to right into the que from rear end
        do {
        ch = input.charAt(i);
        if(dq.isFull()) {
        	System.out.println("Queue is full...Enqueue after removing some items...!");
        	break;
        }
        dq.addRear(ch);
        i++;	
        }while(i < input.length());
        //remove all the characters from the queue from rear end
        String reverse = "";
        do {
        	if(dq.isEmpty()) {
            	System.out.println("Queue is empty...Dequeue after adding some items...!");
            	break;
            }
            ch = dq.removeRear();
            reverse = reverse + ch;
            }while(!dq.isEmpty());
        if(input.equals(reverse))
        	System.out.printf("\n%s is a palindrome.",input);
        else
        	System.out.printf("\n%s is not a palindrome.",input);
	}

}
