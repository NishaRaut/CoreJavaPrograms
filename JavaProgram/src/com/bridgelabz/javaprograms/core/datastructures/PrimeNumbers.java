package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: Generating the prime numbers in the range of  0 -1000 and finding the anangrams also.
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   21-01-2019
 *
 *******************************************************************************/
public class PrimeNumbers {
	public static void main(String[] args) {
		int range = 1000;

		int primeCount = 1;
		String str = "2";
		for(int i = 3; i <= range ; i = i+2) {
			if(Utility.isPrime(i)) {
				primeCount++;
				str = str +","+i;
			}
		}

		String[] primeStr =  str.split(",");
		System.out.println("Total no. of primes in 0-1000 range = "+primeCount);
		int[] allPrimes = Utility.stringToIntArray(primeStr);

		//store primes in a 2-D
		int[][] primes2D = getPrimes2D(allPrimes);
		//print primes2D
		System.out.println("==============================================================");
		print2DArray(primes2D);

		//get the prime anagrams
		int[][] primeAnagram = primeAnagrams(allPrimes);
		System.out.println("\nPrime Anagrams are : ");
		System.out.println("==============================================================");
		print2DArray(primeAnagram);
		//get the non-anagram primes
		int[] nonAnagramPrimes = getNonAnagramPrimes(allPrimes,primeAnagram);
		//store non-anagrams in 2D
		int[][] nonAnagramPrimes2D = getPrimes2D(nonAnagramPrimes);
		System.out.println("\nNon-anagram primes are :");
		System.out.println("==============================================================");
		print2DArray(nonAnagramPrimes2D);

		//printing the anagrams in the reverse order using Stack of Linked List 
		LinkedListStack<Integer> stack  = new LinkedListStack<>();
		for(int i =0 ; i < primeAnagram.length && primeAnagram[i] != null ; i++) {
			for(int j=0; j<primeAnagram[i].length && primeAnagram[i][j] > 0 ; j++) {
				stack.push(primeAnagram[i][j]);
			}
		}
		
		int[] reversedAnagrams = new int[stack.getSize()];
		int anagramsCount =stack.getSize();
		for(int k= 0 ; k < anagramsCount;k++) {
			reversedAnagrams[k] = stack.pop();
		}
		System.out.println("\nAnagrams after reversing ....!");
		int breakCount = 0;
		for (int i = 0; i < reversedAnagrams.length; i++) {
			System.out.print(reversedAnagrams[i] + " ");
			breakCount++;
			if(breakCount % 20 == 0)
				System.out.println();
		}
		System.out.println();
		
		//printing the anagrams in the using Queue of Linked List 
		LinkedListQueue<Integer> que = new LinkedListQueue<>();
		for(int i =0 ; i < primeAnagram.length && primeAnagram[i] != null ; i++) {
			for(int j=0; j<primeAnagram[i].length && primeAnagram[i][j] > 0 ; j++) {
				que.enqueue(primeAnagram[i][j]);
			}
		}
		System.out.println("Printing anagrams using queue ....!");
		breakCount = 0;
		while(!que.isEmpty()) {
			System.out.print(" "+que.dequeue());
			breakCount++;
			if(breakCount % 20 == 0)
				System.out.println();
		}
		System.out.println();
	}//end of main()


	/**
	 * converting the 1D primes to 2D array of primes
	 * @param primes input array of 1D primes
	 * @return 2D array of primes
	 */
	public static int[][] getPrimes2D(int[] primes){
		int[][] primes2D = new int[10][];
		String[] strArr;
		int row = -1;
		String temp = null;
		for (int i = 0; i < primes.length; i++) {
			if(primes[i] <= 100) {
				if(row == -1) {
					row++;
					temp = ""+primes[i];
				}
				else
					temp = temp + ","+primes[i];
			}
			else if(primes[i] > 100 && primes[i] <= 200) {
				if(row == 0) {
					strArr = temp.split(",");
					primes2D[row] = Utility.stringToIntArray(strArr);//creating the 0th row
					row++;
					temp = ""+primes[i];//create a new string
				}
				else
					temp = temp + ","+primes[i];
			}
			else if(primes[i] > 200 && primes[i] <= 300) {
				if(row == 1) {
					strArr = temp.split(",");
					primes2D[row] = Utility.stringToIntArray(strArr);//creating the 1st row
					row++;
					temp = ""+primes[i];
				}
				else
					temp = temp + ","+primes[i];
			}
			else if(primes[i] > 300 && primes[i] <= 400) {
				if(row == 2) {
					strArr = temp.split(",");
					primes2D[row] = Utility.stringToIntArray(strArr);//creating the 2nd row
					row++;
					temp = ""+primes[i];
				}
				else
					temp = temp + ","+primes[i];
			}
			else if(primes[i] > 400 && primes[i] <= 500) {
				if(row == 3) {
					strArr = temp.split(",");
					primes2D[row] = Utility.stringToIntArray(strArr);//creating the 3rd row
					row++;
					temp = ""+primes[i];
				}
				else
					temp = temp + ","+primes[i];
			}
			else if(primes[i] > 500 && primes[i] <= 600) {
				if(row == 4) {
					strArr = temp.split(",");
					primes2D[row] = Utility.stringToIntArray(strArr);//creating the 4th row
					row++;
					temp = ""+primes[i];
				}
				else
					temp = temp + ","+primes[i];
			}
			else if(primes[i] > 600 && primes[i] <= 700) {
				if(row == 5) {
					strArr = temp.split(",");
					primes2D[row] = Utility.stringToIntArray(strArr);//creating the 5th row
					row++;
					temp = ""+primes[i];
				}
				else
					temp = temp + ","+primes[i];
			}
			else if(primes[i] > 700 && primes[i] <= 800) {
				if(row == 6) {
					strArr = temp.split(",");
					primes2D[row] = Utility.stringToIntArray(strArr);//creating the 6th row
					row++;
					temp = ""+primes[i];
				}
				else
					temp = temp + ","+primes[i];
			}
			else if(primes[i] > 800 && primes[i] <= 900) {
				if(row == 7) {
					strArr = temp.split(",");
					primes2D[row] = Utility.stringToIntArray(strArr);//creating the 7th row
					row++;
					temp = ""+primes[i];
				}
				else
					temp = temp + ","+primes[i];
			}
			else if(primes[i] > 900 && primes[i] <= 1000) {
				if(row == 8) {
					strArr = temp.split(",");
					primes2D[row] = Utility.stringToIntArray(strArr);//creating the 8th row
					row++;
					temp = ""+primes[i];
				}
				else
					temp = temp + ","+primes[i];
			}
		}//end of for loop
		strArr = temp.split(",");
		primes2D[row] = Utility.stringToIntArray(strArr);//creating the 9th row
		return primes2D;
	}

	/**
	 * printing the 2D array elements
	 * @param arr 2D array
	 */
	public static void print2DArray(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] !=null ) {
				for(int j=0; j < arr[i].length; j++) {
					if(arr[i][j] > 0)
						System.out.print(arr[i][j]+"   ");
					else
						break;
				}
				System.out.println();
			}
		}
	}

	/**
	 * computing the primes numbers which are anagrams
	 * @param primes array of prime numbers
	 * @return
	 */
	public static int[][] primeAnagrams(int[] primes) {
		int[][] primeAnagrams =  new int[primes.length -1][];
		int[] temp;
		int index;
		boolean isFirst;
		int anagramCount;
		int index2 = -1;
		for(int i=0; i< primes.length -1; i++) {
			index = -1;
			isFirst = true;
			temp = new int[5];
			anagramCount = 1;
			for(int j= i+1; j < primes.length ; j++) {
				if(Utility.checkAnagram(""+primes[i], ""+primes[j])) {
					anagramCount++;
					if(isFirst) {
						temp[++index] = primes[i];
						isFirst = false;
					}
					temp[++index] = primes[j];
				}
			}
			if(anagramCount > 1) {
				primeAnagrams[++index2] = temp;
			}
		}
		//chop off the empty sub arrays
		int[][] result = new int[index2+1][5];
		for(int i =0 ; i < primeAnagrams.length && primeAnagrams[i] != null ; i++) {
			for(int j=0; j<primeAnagrams[i].length && primeAnagrams[i][j] > 0 ; j++) {
				result[i][j] = primeAnagrams[i][j];
			}
		}
		return result;
	}

	public static int[] getNonAnagramPrimes(int[] primes, int[][] anagrams) {
		String temp = "";
		for(int i=0; i< primes.length ; i++) {
			boolean flag = true;
			for(int j=0; j < anagrams.length;j++) {
				for(int k=0; k < anagrams[j].length && anagrams[j][k] > 0 ; k++)
				{
					//compare a prime with an anagram
					if(primes[i] == anagrams[j][k])
					{
						flag = false;
						break;
					}
				}
				if(!flag)
					break;//stop comparing with 2nd array elements
			}
			if(flag && i == 0)
				temp = temp + primes[i];
			else if(flag)
				temp = temp + " "+ primes[i];
		}
		String[] strArr = temp.split(" "); 
		return Utility.stringToIntArray(strArr);
	}
}