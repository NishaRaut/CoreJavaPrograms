package com.bridgelabz.addressbook.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	public static Scanner sc = new Scanner(System.in);

	public static boolean validateMobileNumber(String number) {
		String PATTERN = "\\d{10}";
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(number);
		return matcher.matches();
	}
	
	public static boolean validateZipCode(String zip) {
		String PATTERN = "\\d{6}";
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(zip);
		return matcher.matches();
	}
	public static int getPositiveInteger() {
		int val ;
		do {
			val = sc.nextInt();
		}while(val < 0);
		return val;
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
	//Date Validation
	public static boolean validateDate(String input) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dd = sdf.parse(input);
		Date toDay = new Date();
		if(dd.compareTo(toDay)<0)
			return false;
		return true;
	}
}
