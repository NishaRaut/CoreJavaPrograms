package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: Finding the number of Binary Search Trees could be constructed for a given no. of distinct nodes.
 *
 *  I/P     : number of nodes
 *  O/P     : number of BSTs50
 *  
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   21-01-2019
 *******************************************************************************/
public class BinarySearchTree {

	public static void main(String[] args) {
		System.out.println("Enter the number of nodes...!");
		int nodes = Utility.getPositiveInt();
		//formula : BSTs = 2nCn / (n+1))
		
			double numOfBSTs = 0;
			//numOfBSTs = Utility.factorial(2*nodes)/(Utility.factorial(nodes)*Utility.factorial(nodes)*(nodes+1));
			double numerator = Utility.factorial(2*nodes);
			double denominator = Utility.factorial(nodes) * Utility.factorial(nodes);
			try {
			numOfBSTs = numerator / denominator;
			numOfBSTs = numOfBSTs / (nodes + 1);
            if(((Double)numOfBSTs).isNaN())
            	throw new Exception("Undefined value");
			 System.out.printf("No. of BSTs for %d nodes = %.0f\n",nodes,numOfBSTs);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
