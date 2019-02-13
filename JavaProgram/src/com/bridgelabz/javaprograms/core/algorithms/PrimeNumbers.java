package com.bridgelabz.javaprograms.core.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Finding a list of prime numbers in the given range.
 *           Also finding the prime numbers which are anagrams of each other.
 *           And the prime numbers which are palindrome of each other
 *           
 * I/P    :  str1 , str2
 * O/P    :  true or false
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 12-09-2019
 *****************************************************************************************/
public class PrimeNumbers {

	public static void main(String[] args) {
		System.out.println("Enter the range of prime numbers required (0 - N and N > 2)...!");
		int range = Utility.getPositiveInt();

		// finding all the prime numbers in the given range
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);//2 is the first prime number
		for(int i = 3; i<= range ; i = i+2) {
			if(Utility.isPrime(i))
				primes.add(i);
		}

		//printing all the prime numbers
		System.out.println("*****Prime numbers in the range of 0 - "+range + " are :******");
		for (Integer p : primes) {
			System.out.println(p);
		}

		//finding the prime numbers which are anagram
		HashMap<String,String> primeAnagrams = Utility.anagramsOfNumbers(primes);
		System.out.println("*******Prime numbers which are anagrams of each other are : *******");
		for(Map.Entry<String, String> entry : primeAnagrams.entrySet())
		{
			System.out.print(entry.getKey() +"\t");
			//append the value to key 
			String[] vals = entry.getValue().split(",");
			for(String s : vals) {
				System.out.print(Integer.parseInt(s) + "\t");
			}
			System.out.println();
		}

		//finding the prime numbers which are palindrome
		ArrayList<Integer> primePalindromes = Utility.palindromesOfNumbers(primes);
		System.out.println("*******Prime numbers which are Palindromes are : *******");
		for (Integer i : primePalindromes) {
			System.out.println(i);
		}
	}

}
