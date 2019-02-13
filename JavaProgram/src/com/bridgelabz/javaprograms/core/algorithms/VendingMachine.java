package com.bridgelabz.javaprograms.core.algorithms;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Implementation of Note Vending Machine to give minimum number of notes for the
 *           given input of change money.
 *        
 * I/P    :  a positive integer
 * O/P    :  number of notes required
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 16-09-2019
 *****************************************************************************************/

public class VendingMachine {
	public static void main(String[] args) {
		int[] notes = {1000,500,100,50,10,5,2,1};
		int changeRequired;
		VendingMachine vm = new VendingMachine();
		System.out.println("Enter the change required...!");
		changeRequired = Utility.getPositiveInt();
		int numOfNotes = vm.vendingMachine(notes, changeRequired);
		System.out.println("Number of minimum notes required : "+ numOfNotes);

	}

	/**
	 * computes the minimum no. of notes required for a given amount of change money.
	 * 
	 * @param notes list of notes that the machine has
	 * @param rupee change money that the user wants.
	 * @return the minimum no. of notes required
	 */
	public int vendingMachine(int[] notes, int rupee)
	{
		int notecount= 0;
		int count=0;
		if(rupee == 0 )
			return -1;
		for(int i=0;i<notes.length;i++)
		{
			if(rupee >=notes[i])		
			{
				notecount = (rupee/notes[i]);
				System.out.println(notes[i]+ "\t : "+notecount);
				rupee = (rupee % notes[i]);
				count++;
			}
		}
		return count;				
	}   
}
