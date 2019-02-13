package com.bridgelabz.javaprograms.core.oops;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose :  Regular Expression Demonstration.
 *
 *  I/P     : A message with some patterns
 *  
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   27-01-2019
 *  
 *******************************************************************************/
public class RegularExpression {

	public static void main(String[] args) {
		String input = "Hello <<name>>, We have your full name as <<full name>> in our system."+
				"\nyour contact number is <<91-xxxxxxxxxx>>."+
				"\nPlease,let us know in case of any clarification."+ 
				"\nThank you BridgeLabz <<xx/xx/xxxx>>.";

		Pattern  pattern;
		Matcher matcher;
		String result = "";


		System.out.println("Enter your name...!");
		String name = Utility.getString();
		pattern = Pattern.compile("<<name>>");
		matcher = pattern.matcher(input);
		result = matcher.replaceAll(name.toUpperCase());

		System.out.println("Enter your full name...!");
		String fullName = Utility.getStringsWithSpaces();
		pattern = Pattern.compile("<<full name>>");
		matcher = pattern.matcher(result);
		result = matcher.replaceAll(fullName.toUpperCase());

		System.out.println("Enter your contact number...!");
		String contactNum = Utility.getLong().toString();
		pattern = Pattern.compile("<<91-xxxxxxxxxx>>");
		matcher = pattern.matcher(result);
		result = matcher.replaceAll(contactNum);

		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(currentDate);
		pattern = Pattern.compile("<<xx/xx/xxxx>>");
		matcher = pattern.matcher(result);
		result = matcher.replaceAll(date);
		System.out.println(result);
	}

}
