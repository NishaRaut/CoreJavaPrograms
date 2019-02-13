package com.bridgelabz.jdbc.util;

import java.util.Scanner;

public class Utility {
 public static Scanner sc = new Scanner(System.in);
  
 /**
  * read a positive integer from the keyboard
  * @param range positive range of the value 
  * @return a positive number
  */
  public static int getPositiveInt(int range) {
	  boolean isValid = false;
	  String error = null;
	  int i; 
	  do {
		  if(error != null)
			  System.out.println(error);
		  i = sc.nextInt();
		  if(i > range || i <= 0) {
			  error = "Enter a number between 1 and "+range;
		     isValid = false;
		  }
		  else {
			  error = null;
			  isValid = true;
		  }
	  }while(!isValid);
	  return i;
  }
  
  /**
   * reads a string value from keyboard
   * @return string value
   */
  public static String getString() {
	  boolean isValid = false;
	  String error = null;
	  String  str = null; 
	  do {
		  if(error != null)
			  System.out.println(error);
		  str = sc.next().trim();
		  if(str.equals("") || str == null) {
			  error = "Enter a valid string...!";
		      isValid = false;
		  }
		  else {
			  error = null;
			  isValid = true;
		  }
	  }while(!isValid);
	  return str;
  }
  
  /**
   * read a sql query from the keyboard
   * @return sql query
   */
  public static String getQuery() {
	  String query  = null;
	  query = sc.nextLine();
	  return query;
  }
  
  /**
   * validates a string for starting with letter and length 20 chars
   * @param str input string to validate
   * @return true if valid else false
   */
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
  
  /**
   * validates a 10 digit mobile number
   * @param mobileNumber mobile number
   */
  public static boolean validateMobileNumber(String mobileNumber) {
		String regex = "^[7-9][0-9]{9}$";
		return mobileNumber.matches(regex);
	}
}