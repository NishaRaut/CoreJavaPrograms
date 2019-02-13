package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 * Purpose : Reading (M*N) elements in 2D array and printing
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 10-01-2109 
 *****************************************************************************/
public class TwoDArray {
	public static void main(String[] args) {
       System.out.println("Enter number of rows(M)...! ");
       int rows = Utility.getPositiveInt();
       System.out.println("Enter number of columns(N)...!");
       int cols = Utility.getPositiveInt();
       System.out.println("Enter" +(rows*cols)+" Two-D array elements");
       int[][] twoDIntArray = new int[rows][cols];
       Utility.read2DArrayElemets(twoDIntArray, rows, cols);
       System.out.println("2-D Array elemnts are : ");
       Utility.display2DArrayElemets(twoDIntArray,rows,cols);
	}
}

