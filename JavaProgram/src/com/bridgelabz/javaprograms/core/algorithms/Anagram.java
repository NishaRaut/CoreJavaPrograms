

package com.bridgelabz.javaprograms.core.algorithms;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Checking whether two input strings are anagram or not.
 *           
 * I/P    :  str1 , str2
 * O/P    :  true or false
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 12-09-2019
 *****************************************************************************************/
public class Anagram {
	public static void main(String[] args) {
		System.out.println("Enter two strings to be checked for anagram ...!");
		String str1 = Utility.getString();
		String str2 = Utility.getString();
		boolean isAnagaram = Utility.checkAnagram(str1, str2);
		if(isAnagaram)
			System.out.println("'"+str1+"' and '" + str2+ "' are anagram...!");
		else
			System.out.println("'"+str1+"' and '" + str2+ "' aren't anagram ...!");
	}
}
