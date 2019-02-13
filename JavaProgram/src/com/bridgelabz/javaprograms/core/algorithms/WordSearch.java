
package com.bridgelabz.javaprograms.core.algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Searching a word in agiven list of words read from a file.
 *           
 *           
 * I/P    :  list of comma separated words
 * O/P    :  prints the position of the word in the list if it is found
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 14-09-2019
 *****************************************************************************************/
public class WordSearch {
	public static void main(String[] args) {
		String path = "/home/admin1/Desktop/sample.txt";
		String[] words;
		String line= "";
		String key;
		int result;
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String temp = null;
			while((temp = br.readLine())!= null)
			{
				line += temp;
			}
			words = line.split(",");
			Arrays.sort(words);
			System.out.println("Words list :");
			Utility.printStringArray(words);
			do {
				System.out.println("Enter the key...!");
				key = Utility.getString();
			}while(key.trim().equals("") || key == null);

			result = Utility.binarySearchOfString(words, key);
			if(result > 0)
				System.out.println("Key '"+ key+"' found at position "+result);
			else
				System.out.println("Key '"+key+"' not found...!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
