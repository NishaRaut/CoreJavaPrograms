package com.bridgelabz.javaprograms.core.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/******************************************************************************
 *  Purpose: Contains utility functions and other stuffs that can be reused in the project
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   08-01-2019
 * 
 ******************************************************************************/
public class Utility {
	//static Scanner instance to read input from the keyboard
	public static Scanner scanner = new Scanner(System.in);

	/**
	 * calculates percentage of getting head, for a given number of
	 * times the coin flipped
	 * 
	 * @param trials the number of times the coin to be flipped
	 * @return a double value of percentage of head appeared
	 */
	public static double percentageOfHeads(int trials)
	{
		int heads = 0;
		for(int i = 0; i < trials; i++)
		{
			if(Math.random() >= 0.5)
				heads++;
		}
		if(heads == 0)
			return 0;
		return (heads*1.0)/trials*100;
	}

	/**
	 * checks for a given year is leap year or not
	 * 
	 * @param year the year to check for leap year
	 * @return true if year is leap year else false
	 */
	public static boolean isLeapYear(int year) {
		if  ((year % 4 == 0) && (year % 100 != 0)) 
			return true;
		if  (year % 400 == 0) 
			return true;
		return false;
	}

	/**
	 * prints power of 2 until the specified number
	 * 
	 * @param num upper limit(inclusive) to print the powers of 2
	 */
	public static void print2sTable(int num)
	{
		for (int i = 0; i <= num; i++) {
			System.out.println("2^"+i+ " = "+(int)Math.pow(2, i));
		}
	}

	/**
	 * reads a positive integer from keyboard
	 * 
	 * @return a positive integer number
	 */
	public static int getPositiveInt() {
		int n = scanner.nextInt();
		while(n <= 0) {
			System.out.println("Enter a proper positive number...!");
			n = scanner.nextInt();
		}
		return n;
	}

	/**
	 * reads an integer from keyboard
	 * 
	 * @return an integer number
	 */
	public static int getInt() {
		int n = scanner.nextInt();
		return n;
	}

	/**
	 * computes nth harmonic number
	 * 
	 * @param n integer value to compute the nth harminc number
	 * @return a nth harmonic number 
	 */
	public static double getNthHarmonicNumber(int n) {
		double harmonic = 0;
		for (int i = 1; i <= n; i++) {
			harmonic += 1.0 / i;
		}
		return harmonic;
	}

	/**
	 * print the prime factors of a given number
	 * 
	 * @param number the number whose prime factors need to be printed
	 */
	public static void primeFactors(int number) {
		// print the number of 2s that divide n 
		while (number%2 == 0) 
		{ 
			System.out.println(2);
			number = number/2; 
		} 

		// number must be odd at this point.
		for (int i = 3; i <= Math.sqrt(number); i = i+2) 
		{ 
			while (number%i == 0) 
			{ 
				System.out.println(i);
				number = number/i; 
			} 
		} 
		// This condition is to handle the case when number is a prime number greater than 2 
		if (number > 2) 
			System.out.println(number);
	}

	/**
	 * returns the number of random numbers generated to get N number of distinct values
	 * 
	 * @param num is the number of distinct values to be generated
	 * @return number of random numbers have been generated to get N distinct values
	 */
	public static int distinctCoupons(int num) {
		int distinctCount = 0;
		int randCount = 0;
		boolean[] isDistinct = new boolean[num];
		while(distinctCount < num) {

			int random = (int)(Math.random()*num);
			randCount++;
			if(!isDistinct[random]) {
				System.out.println("Random = "+random);
				isDistinct[random] = true;
				distinctCount++;
			}
		}
		return randCount;
	}

	/**
	 * reads 2-D array elements from the console
	 * 
	 * @param arr the 2-D array whose elements to be read
	 * @param rows the number of rows of 2-D array
	 * @param cols the number of columns of 2-D array
	 */
	public static void read2DArrayElemets(int[][] arr,int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for(int j = 0; j< cols;j++) {
				arr[i][j] = Utility.getInt();
			}
		}
	}

	/**
	 * displays 2-D array elements to the console
	 * 
	 * @param arr the 2-D array whose elements to be read
	 * @param rows the number of rows of 2-D array
	 * @param cols the number of columns of 2-D array
	 */
	public static void display2DArrayElemets(int[][] arr,int rows, int cols) {
		try(PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),true)){
			for (int i = 0; i < rows; i++) {
				for(int j = 0; j< cols;j++) {
					pw.write(arr[i][j] + "  ");
				}
				pw.println();
			}//end of the outer-loop
		}//end of try-with resource
	}

	/**
	 * counts and display the number of distinct triplets that sums to zero
	 * 
	 * @param numbers is array of integers
	 * @return number of distinct triplets
	 */
	public static int countTripletsSumsToZero(int[] numbers) {
		int count = 0;
		HashSet<String> triplets = new HashSet<String>();
		for (int i = 0; i < numbers.length-2; i++) {
			for (int j = i+1; j < numbers.length-1; j++) {
				for (int k = j+1; k < numbers.length; k++) {
					if(numbers[i] + numbers[j] + numbers[k] == 0) {
						String temp = ""+numbers[i] + "@"+numbers[j] + "@" + numbers[k];
						if(isDistinctTriplet(triplets,temp)) {
							count++;
							System.out.println(numbers[i] + " "+numbers[j] + " "+numbers[k]);
						}
					}
				}
			}
		}
		return count;
	}

	/**
	 * check the given string is unique in given set of string values
	 * @param distincts set of distinct strings
	 * @param str the string to be checked unique or not
	 * @return true or false
	 */
	public static boolean isDistinctTriplet(HashSet<String> distincts, String str) {
		if(distincts.size() == 0)//first distinct string
			return distincts.add(str.toLowerCase());
		else 
			return distincts.add(str.toLowerCase());
	}

	/**
	 * coumputes Euclidian distance
	 * 
	 * @param x value of x-axis of pint p(x,y)
	 * @param y value of y-axis of pint p(x,y)
	 * @return Euclidian distance from the origin to the poin p(x,y)
	 */
	public static double euclidianDistance(double x, double y) {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	/**
	 * reads a string input from input device
	 * @return a string
	 */
	public static String getString() {
		String str = scanner.next();
		while(str.trim().equals("") || str == null) {
			System.out.println("Enter a valid string...!");
			str = scanner.next();
		}
		return str;
	}

	/**
	 * generates an array of permutations of a given string by iterative approach
	 * 
	 * @param inputStr the string for which the permutations has to be generated
	 * @return string array of permutations of inputStr
	 */
	public static String[] stringPermutationsByIterative(String inputStr) {
		List<String> results = new ArrayList<>();
		char[] chars = inputStr.toCharArray();
		results.add(new String("" + chars[0]));
		for(int j=1; j<chars.length; j++) {
			char c = chars[j];//b
			int cur_size = results.size();
			//creating new permutations by combining char 'c' with each of the existing permutations
			for(int i=cur_size-1; i>=0; i--) {
				String str = results.remove(i);//a
				for(int l=0; l<=str.length(); l++) {
					results.add(str.substring(0,l) + c + str.substring(l));
				}
			}
		}
		String[] permutations = results.toArray(new String[results.size()]);
		return permutations;
	}

	/** 
	 * permutation function 
	 * @param str string to calculate permutation for 
	 * @param stIndex starting index 
	 * @param enIndex end index 
	 */
	public static void stringPermutationsByRecursion(String str, int stIndex, int enIndex) 
	{ 
		if (stIndex == enIndex) 
			System.out.println(str);
		else
		{ 
			for (int i = stIndex; i <= enIndex; i++) 
			{ 
				str = swap(str,stIndex,i); 
				stringPermutationsByRecursion(str, stIndex+1, enIndex); 
				str = swap(str,stIndex,i); 
			} 
		} 
	} 	

	/**
	 * function to display string array elements
	 * @param str String array
	 */
	public static void displayStringArray(String[] str) {
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}

	/** 
	 * Swap Characters at position 
	 * 
	 * @param str string value 
	 * @param i position 1 
	 * @param j position 2 
	 * @return swapped string 
	 */
	public static String swap(String str, int i, int j) 
	{ 
		char temp; 
		char[] charArray = str.toCharArray(); 
		temp = charArray[i] ; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		return String.valueOf(charArray); 
	} 



	/**
	 * reads a double value
	 * @return a double value
	 */
	public static double getDouble() {
		return scanner.nextDouble();
	}

	/**
	 * computes and returns windchill(the effective temperature)
	 * Formulae : 35.74 + 0.6215t + (0.4275t - 35.75)v^0.16
	 * 
	 * @param temperature the temperature (in Fahrenheit) 
	 * @param windSpeed the wind speed (in miles per hour)
	 * @return windChill
	 */
	public static double getWindChill(double temperature, double windSpeed) {
		double windChill = 0.0;
		windChill = 35.74 + 0.6215*temperature + (0.4275*temperature - 35.75) * Math.pow(windSpeed, 0.16);
		return windChill;
	}

	//**********************************algorithm functions******************************************

	/**
	 * checks two strings are anagram or not
	 * 
	 * @param str1 first string
	 * @param str2 second string
	 * @return true or false
	 */
	public static boolean checkAnagram(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		str1 = toLowerCase(str1);
		str2 = toLowerCase(str2);
		str1 = stringSort(str1);
		str2 = stringSort(str2);
		if(str1.equals(str2))
			return true;
		else
			return false;
	}
	/**
	 * sorting a string using insertion sort
	 * @param str sorted string  
	 * @return
	 */
	public static String stringSort(String str) {
		char[] chars = new char[str.length()];
		for(int i =0; i< str.length() ; i++) {
			chars[i] = str.charAt(i);
		}
		for(int i = 1; i < chars.length ; i++) {
			for(int j = i; j > 0 ; j--) {
				if(chars[j-1] > chars[j])
				{//Swap the two elemets
					char temp = chars[j-1];
					chars[j-1] = chars[j];
					chars[j] = temp;
				}
			}
		}//end of outer loop
		return new String(chars);
	}
	/**
	 * conversion of letters from upper to lower
	 * @param str
	 * @return
	 */
	public static String toLowerCase(String str) {
		char aChar;
		String lower = "";
		for (int i = 0; i< str.length(); i++){
			aChar = str.charAt(i);
			if (65 <= aChar && aChar<=90){
				aChar = (char)( (aChar + 32) ); 
				lower = lower + aChar;
			}
			else
				lower = lower + aChar;
		}
		return lower;
	}

	/**
	 * checks whether a given number is prime or not
	 * 
	 * @param num the number to check prime or not
	 * @return true or false
	 */
	public static boolean isPrime(int num) {
		for(int i = 2 ; i <= num/2 ; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * finds and returns anagrams of a set of numbers
	 * @param nums array of numbers
	 * @return a Map having all the anagrams
	 */
	public static HashMap<String,String> anagramsOfNumbers(ArrayList<Integer> nums){
		HashMap<String,String> primeAnagrams = new HashMap<String,String>();
		boolean anagram = false;
		for(int i = 0 ;i < nums.size() - 1; i++) {
			for(int j= i+1; j < nums.size(); j++) {
				Integer p1 = nums.get(i);
				Integer p2 = nums.get(j);
				anagram = Utility.checkAnagram(p1.toString(), p2.toString());
				if(anagram) {
					if(primeAnagrams.containsKey(p1.toString()))
					{
						String oldValue = primeAnagrams.get(p1.toString());
						primeAnagrams.put(p1.toString(), oldValue+","+p2.toString());
					}
					else
						primeAnagrams.put(p1.toString(), p2.toString());
				}//end of anagram condition
			}
		}//end of i loop
		return primeAnagrams;
	}

	/**
	 * finds and returns palindromes of a set of numbers
	 * @param nums array of numbers
	 * @return a list of all the palindromes
	 */
	public static ArrayList<Integer> palindromesOfNumbers(ArrayList<Integer> nums){
		ArrayList<Integer> allPalindromes = new ArrayList<Integer>();
		boolean palindrome = false;
		Integer temp;
		for(int i = 0 ;i < nums.size() - 1; i++) {
			temp = nums.get(i);
			palindrome = Utility.checkPalindrome(temp.toString());
			if(palindrome) {
				allPalindromes.add(temp);
			}
		}//end of i loop
		return allPalindromes;
	}

	/**
	 * checks a string is palindrome or not
	 * @param str1 first string
	 * @param str2 second string
	 * @return true or false
	 */
	public static boolean checkPalindrome(String str1)
	{
		String temp = new StringBuilder(str1).reverse().toString();//reversed of str2
		if(str1.trim().toLowerCase().equals(temp))
			return true;
		return false;
	}

	/**
	 * function to implement the binary search for integers
	 * @param nums array of integers
	 * @param key the value to be searched against the nums
	 * @return position in the list if key found otherwise -1
	 */
	public static int binarySearchOfInt(int[] nums, int key) {
		int l = 0;
		int r = nums.length - 1;
		int pos = -1;

		while(l <= r) {
			pos = (l + r)/2;
			if(key < nums [pos])
				r = pos - 1;
			else if( key > nums[pos])
				l = pos + 1;
			else
				return pos;//success

		}
		return -1;
	}

	/**
	 * function to implement the binary search for strings
	 * @param nums array of strings
	 * @param key the value to be searched against the nums
	 * @return position in the list if key found otherwise -1
	 */
	public static int binarySearchOfString(String[] str, String key) {
		int l = 0;
		int r = str.length - 1;
		int pos = -1;
		//perform the searching
		while(l <= r) {
			pos = (l + r)/2;
			if(key.compareTo(str[pos]) < 0)
				r = pos - 1;
			else if(key.compareTo(str[pos]) > 0)
				l = pos + 1;
			else
				return pos;//success
		}
		return -1;
	}

	/**
	 * insertion sort function for integer values
	 * @param A list of integers to be sorted
	 * @return array of given integers in a sorted order
	 */
	public static int[] insertionSortOfInts(int[] A) {
		for(int i = 1; i < A.length ; i++) {
			for(int j = i; j > 0 ; j--) {
				if(A[j-1] > A[j])
				{//Swap the two elemets
					int temp = A[j-1];
					A[j-1] = A[j];
					A[j] = temp;
				}
			}
		}//end of outer loop
		return A;
	}

	/**
	 * function to sort the set of strings using insertion sort
	 * @param A array of strings
	 * @return a sorted array of strings
	 */
	public static String[] insertionSortOfStrings(String[] A) {
		for(int i = 1; i < A.length ; i++) {
			for(int j = i; j > 0 ; j--) {
				if(A[j-1].compareTo(A[j]) > 0)
				{//Swap the two elemets
					String temp = A[j-1];
					A[j-1] = A[j];
					A[j] = temp;
				}
			}
		}//end of outer loop
		return A;
	}

	/**
	 * function to sort the integers using bubble sort algorithm
	 * @param A array of integers
	 * @return sorted array of integers
	 */
	public static int[] bubbleSortOfIntegers(int[] A) {
		int n = A.length;
		int temp = 0;

		for(int i = 0; i < n; i++) {
			for(int j=1; j < (n-i); j++) {//number of comaparisions in each pass is n-i
				if(A[j-1] > A[j]) {
					temp = A[j-1];
					A[j-1] = A[j];
					A[j] = temp;
				}
			}
		}
		return A;
	}	

	/**
	 * function to sort the set of strings using the bubble sort algorithms
	 * @param A array of strings
	 * @return a sorted array of strings
	 */
	public static String[] bubbleSortOfStrings(String[] A) {
		int n = A.length;
		String temp = null;

		for(int i = 0; i < n; i++) {
			for(int j=1; j < (n-i); j++) {//number of comaparisions in each pass is n-i
				if(A[j-1].compareTo(A[j]) > 0) {
					temp = A[j-1];
					A[j-1] = A[j];
					A[j] = temp;
				}
			}
		}
		return A;
	}	

	/**
	 * function to copy the elements of one integer array to other
	 * @param source array of integers to be copied to destination array
	 * @param destination an empty array of integers to be copied from source
	 * @return destination array whose elements are copy of the source array
	 */
	public static int[] copyArrayOfInts(int[] source, int[] destination) {
		for (int i=0; i<source.length; i++) 
			destination[i] = source[i]; 
		return destination;
	}

	/**
	 * function to copy the elements of one string array to other
	 * @param source array of strings to be copied to destination array
	 * @param destination an empty array of strings to be copied from source
	 * @return destination array whose elements are copy of the source array
	 */
	public static String[] copyArrayOfStrings(String[] source, String[] destination) {
		for (int i=0; i<source.length; i++) 
			destination[i] = source[i]; 
		return destination;
	}

	/**
	 * function to display time from milliseconds to a HH:MM:Sec:msec
	 * @param time time in milliseconds
	 */
	public static void printTime(long time) {
		int millisec = (int)time % 1000;//millisecs
		time =  time / 1000;//converting to secs
		int secs = (int)time % 60;//compute no. of secs
		int mins = ((int)time) /60;//converting to mins 
		int hours = mins/60;//compute no. of hours
		mins = mins%60;//compute no. of mins

		System.out.println("\t Elpased Time : "+hours+":"+mins+":"+secs +":"+ millisec);
	}

	/**
	 * function to print the integer elements of an integer array
	 * @param A array of integers
	 */
	public static void printIntArray(int[] A) {
		for (int i : A) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * function to print string elements of a string array
	 * @param A array of strings
	 */
	public static void printStringArray(String[] A) {
		for (String i : A) {
			System.out.print("\t"+i);
		}
		System.out.println();
	}


	/**
	 * function to convert temperature from fahrenheit to celsius and viceversa
	 * @param temperature
	 * @param isFahrenheit
	 * @return temperature
	 */
	public static double temperaturConversion(double temperature,int isFahrenheit) {
		double result;
		if(isFahrenheit == 1)
			//fahrenheit to celsius
			result = ((temperature-32) * 5)/9 ;
		else
			//celsius to fahrenheit
			result = (temperature *9/5+32);
		return result;
	}

	/**
	 * computes a monthly payment of the principal amount of P, for a monthly compound
	 * interest of R over a period of Y years 
	 * 
	 * @param P principal amount
	 * @param Y period in years
	 * @param R interest rate
	 */
	public static double monthlyPayment( double p , double y , double r )
	{
		double n = (12 * y);
		r = r / (12*100);
		double power = Math.pow((1+r), -n);
		double payment = ((p*r)/ (1 - power));
		return payment;
	}

	/**
	 * finds square root of a nonnegative number
	 * @param c a nonnegative number
	 */
	public static double sqrtNewtons(double c)
	{
		double epsilon = 1e-15;
		double t = c;			
		while(Math.abs(t - c/t) > epsilon*t)
		{
			t=(c/t + t)/2.0;
		}
		return t;
	}

	/**
	 * converts from decimal to binary
	 * @param decimal the decimal number
	 * @return array of binary digits
	 */
	public static char[] toBinary(int decimal)
	{
		String binaryDigits = "";
		while(decimal > 0)
		{
			binaryDigits += decimal % 2;
			decimal = decimal / 2 ;
		}
		return binaryDigits.toCharArray();
	}

	/*********************Binary Nibble *******************************/

	/**This method swap the nibble of decimal number
	 * @param decimal is decimal number
	 * @return newly generated decimal after swapping number
	 */
	public static int swapNibbles(int decimal) 
	{ 
		return ((decimal & 0x0F) << 4 | (decimal & 0xF0) >> 4); 
	} 

	/**
	 * checks whether a number is power of 2 or not
	 * @param num number to check for power of 2
	 * @return true or false
	 */
	public static boolean isPowerTwo(int num) //check entered number is power of two
	{
		return (int)(Math.ceil((Math.log(num) / Math.log(2)))) ==  
				(int)(Math.floor(((Math.log(num) / Math.log(2))))); 
	}	

	/**
	 * merge sorting
	 * @param input array
	 * @return a sorted array
	 */
	public static String[] mergeSort(String[] list) {
		String [] sorted = new String[list.length];
		if (list.length == 1) {
			sorted = list;
		} else {
			int mid = list.length/2;
			String[] left = null; 
			String[] right = null;
			if ((list.length % 2) == 0) {
				left = new String[list.length/2];
				right = new String[list.length/2];
			} else { 
				left = new String[list.length/2];
				right = new String[(list.length/2)+1];
			}
			int x=0;
			int y=0;
			for ( ; x < mid; x++) {
				left[x] = list[x];
			}
			for ( ; x < list.length; x++) {
				right[y++] = list[x];
			}
			left = mergeSort(left);
			right = mergeSort(right);
			sorted = mergeArray(left,right);
		}
		return sorted;
	}

	/**
	 * merging the two sorted lists
	 * @param left
	 * @param right
	 * @return
	 */
	public static String[] mergeArray(String[] left, String[] right) {
		String[] merged = new String[left.length+right.length];
		int lIndex = 0;
		int rIndex = 0;
		int mIndex = 0;
		int comp = 0;
		while (lIndex < left.length || rIndex < right.length) {
			if (lIndex == left.length) {
				merged[mIndex++] = right[rIndex++];
			} else if (rIndex == right.length) {
				merged[mIndex++] = left[lIndex++];
			} else {  
				comp = left[lIndex].compareTo(right[rIndex]);
				if (comp > 0) {
					merged[mIndex++] = right[rIndex++];
				} else if (comp < 0) {
					merged[mIndex++] = left[lIndex++];
				} else { 
					merged[mIndex++] = left[lIndex++];
				}
			}   
		}
		return merged;
	}
	/**
	 * finding the factorial of a number
	 * @param n input number
	 * @return factorial(n)
	 */
	public static double factorial(long num) {
		if(num == 1)
			return 1;
		return num * factorial(num-1);
	}

	/**
	 * converts the string array to integer array
	 * @param arr string array
	 * @return  intger array
	 */
	public static int[] stringToIntArray(String[] arr) {
		int[] result = new int[arr.length];
		for(int i = 0; i < arr.length;i++) {
			result[i] = Integer.parseInt(arr[i]);
		}
		return result;
	}

	/**
	 * reading words from a file
	 * @param file file
	 * @return array of strings
	 */
	public static String[] readFromFile(File file) {
		String[] numbers = null;
		String line= "";

		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String temp = null;
			while((temp = br.readLine())!= null)
			{
				line += temp;
			}
			numbers = line.split(",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numbers;
	}

	/**
	 * gives the starting day of the month
	 * @param month 
	 * @param day
	 * @param year
	 * @return
	 */
	public static int getStartingDay(int month, int day, int year) {
		int y = year - (14 - month) / 12;
		int x = y + y/4 - y/100 + y/400;
		int m = month + 12 * ((14 - month) / 12) - 2;
		int d = (day + x + (31*m)/12) % 7;
		return d;
	}

	/**
	 * writing the integer array to a file
	 * @param list
	 * @param filePath
	 */
	public static void writeToFile(int[] list, File file) {
		if(list == null || list.length == 0)
			return;

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,false))){
			for (int i = 0; i < list.length; i++) {
				bw.write(list[i]+",");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//=================================================Object Oriented Static Functions===========================================

		/**
		 * reading a JSON file
		 * @param file file path
		 * @return a java JSONObject
		 */
		public static Object  readJsonFile(File file) {
			Object obj = null;
			JSONParser parser = new JSONParser();
			try(BufferedReader br = new BufferedReader(new FileReader(file))){
				obj = parser.parse(br);
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			return obj;
		}
		
		public static String getStringsWithSpaces() {
			String str = "";
			do {
				str = scanner.nextLine();
			}while(str.trim().equals("") || str == null);
			return str;
		}
		
		public static Long getLong() {
			return scanner.nextLong();
		}
		//String validation
		public static boolean validateStringForAlphanumericOflength20(String str)
		{
			if(str==null)
				return false;
			if(str.trim().equals(""))
				return false;
			if(str.trim().contains(" "))
				return false;
			if(!Character.isLetter(str.charAt(0)))
				return false;
			if(str.length()>20 || str.length()<3)
				return false;
			return true;
		}
}

