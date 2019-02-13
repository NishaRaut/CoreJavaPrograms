package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: Printing the first n powers of 2
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   08-01-2019
 *
 ******************************************************************************/
public class PowerOf2 {

	public static void main(String[] args) {
		int num = 0;
		if(args.length == 0)
			System.out.println("Provide a number as command-line arg...!");
		else if((num = Integer.parseInt(args[0])) >=31)
			System.out.println("Integer overflow...!\n provide a value less than 31");
		else
			Utility.print2sTable(num);
	}

}
