package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/**
 * Purpose : A program that takes a string as input and gives all its possible permutations by
 *           the iterative and recursive methods.
 *           
 * I/P    : string
 * O/P    : array of strings 
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 10-09-2019
 */
public class StringPermutations {

	public static void main(String[] args) {
		System.out.println("Enter a string...!");
		String input = Utility.getString();
		
		System.out.printf("Permutations of %s by iterative...!", input);

		String[] iterativePerms = Utility.stringPermutationsByIterative(input);
		System.out.printf("\nNumber of permuations : %d\n",iterativePerms.length);
		Utility.displayStringArray(iterativePerms);
		
		System.out.printf("Permutations of %s by recursive...!\n", input);
		Utility.stringPermutationsByRecursion(input,0,input.length()-1);
	}

}
