package com.bridgelabz.cliniqueManagement.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.bridgelabz.cliniqueManagement.services.AppData;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Utility {
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * reads in the user choice
	 * @return user choice value
	 */
	public static int getCliniqueMenuChoice() {
		int choice;
		String error = "";
		do {
			System.out.println(error);
			choice = Utility.getPositiveInt();
			if (choice < 0 || choice > 6)
				error = "Enter a number between 1 - 6";
			else
				error = "";
		} while (!error.equals(""));
		return choice;
	}
	/**
	 * reads a positive integer from keyboard
	 * 
	 * @return a positive integer number
	 */
	public static int getPositiveInt() {
		int n = scanner.nextInt();
		while(n <= 0) {
			System.out.println("Enter a proper positive number...!");
			n = scanner.nextInt();
		}
		return n;
	}
	
	/**
	 * reads a string input from input device
	 * @return a string
	 */
	public static String getString() {
		String str = scanner.next();
		while(str.trim().equals("") || str == null) {
			System.out.println("Enter a valid string...!");
			str = scanner.next();
		}
		return str;
	}
	
	public static int getDoctorSearchMenuChoice() {
		int choice;
		String error = "";
		do {
			System.out.println(error);
			choice = Utility.getPositiveInt();
			if (choice < 0 || choice > 5)
				error = "Enter a number between 1 - 5";
			else
				error = "";
		} while (!error.equals(""));
		return choice;
	}
	
	public static int getPatientSearchMenuChoice() {
		int choice;
		String error = "";
		do {
			System.out.println(error);
			choice = Utility.getPositiveInt();
			if (choice < 0 || choice > 4)
				error = "Enter a number between 1 - 4";
			else
				error = "";
		} while (!error.equals(""));
		return choice;
	}
	
	public static boolean validateMobileNumber(String mobileNumber) {
		String regex = "^[7-9][0-9]{9}$";
		return mobileNumber.matches(regex);
	}
	
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = sdf.format(new Date());
		return strDate;
	}
	
	public static String getNextDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//add 1 to given date
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DATE, 1);
		Date nextDate = c.getTime();
		return sdf.format(nextDate);
	}
	
	public static void saveAppData(AppData appData) {
		File file = new File("resource/appData.json");
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(file, appData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static AppData getAppData() {
		File file = new File("resource/appData.json");
		if (file.length() == 0)
			return null;
		ObjectMapper mapper = new ObjectMapper();
		AppData appData = null;
		try {
			appData = mapper.readValue(file, AppData.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return appData;
	}
}
