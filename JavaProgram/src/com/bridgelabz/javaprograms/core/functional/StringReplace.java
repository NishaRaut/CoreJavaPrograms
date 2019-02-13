package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: replace a template string in greeting template with user name
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   08-01-2019
 *
 ******************************************************************************/
public class StringReplace {
	public static void main(String[] args) {
		String template  = "Hello <<UserName>>, How are you?";
		String name = getName();
		template  = template.replace("<<UserName>>", name);
		System.out.println(template);
	}

	/**
	 * reading the username
	 * @return user name
	 */
	public static String getName() {
		String input = null;
		boolean flag = false;
		while(!flag)
		{
			System.out.println("Enter your name...!");
			input = Utility.scanner.next().trim().toUpperCase();
			if(input.equals("")||input == null)
				System.out.println("Plz enter a valid name ...!");
			else if(input.length()< 3)
				System.out.println("Plz enter name of min 3 chars length...!");
			else
				flag = true;
		}
		return input;
	}
}
