/**
 * 
 */
package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose : Checking the given arithmetic operation is balnced or not
 *
 *  I/P     : An arithmetic expression having brackets
 *  O/P     : true or false indicating expression is balanced or not
 *  
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   18-01-2019
 *  
 *******************************************************************************/

public class BalancedParentheses {

	public static void main(String[] args) {

		String expression;
		do {
			System.out.println("Enter an arithmetic expression");
			expression = Utility.getString();
		}while(expression.equals("") || expression == null);

		Stack<Character> expStack = new Stack<>();
		char ch;
		int index = 0;
		while(index < expression.length())
		{
			ch = expression.charAt(index);
			if(ch == '(' || ch == ')')
			{
				if(ch == '(' && expStack.size() < expStack.getStackCapacity()) 
					expStack.push(ch);
				else if(ch == ')' && !expStack.isEmpty())  {
					expStack.pop();
				}
				else if(expStack.size() == expStack.getStackCapacity()){
					System.out.println("Stack is full..Remove some items before pushing...!");
					break;
				}
				else if(expStack.isEmpty()) {
					System.out.println("Stack is empty..Push some items before removing...!");
					break;
				}
			}
			index++;
		}
		//check stack still it contains items or not
		if(expStack.isEmpty())
			System.out.println("Given expression is balanced...!");
		else
			System.out.println("Given expression is not balanced...!");
	}

}
