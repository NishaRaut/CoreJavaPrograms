package com.bridgelabz.jdbc.controllers;

import java.util.List;

import com.bridgelabz.jdbc.models.User;
import com.bridgelabz.jdbc.services.LoginByPreparedStmt;
import com.bridgelabz.jdbc.util.Utility;

public class TestPerparedStatement {

	public static void main(String[] args) {
		LoginByPreparedStmt loginObj = new LoginByPreparedStmt();
		String firstname = null;
		String lastname = null;
		String mobile = null;
		String username = null;
		String password = null;
		String result = null;
		int choice;
		do {
			System.out.println();
			System.out.println("Enter 1 : Registraion");
			System.out.println("Enter 2 : Login");
			System.out.println("Enter 3 : List all users");
			System.out.println("Enter 4 : Exit/n");

			choice = Utility.getPositiveInt(5);

			switch (choice) {
			case 1: // *********** Registration **************************** /
				System.out.println("Enter first name");
				firstname = Utility.getString();
				while (!Utility.validateStringForAlphanumericOflength20(firstname)) {
					System.out.println("First name should be 3-20 characters long and starts with letter...!");
					firstname = Utility.getString();
				}
				System.out.println("Enter last name");
				lastname = Utility.getString();
				while (!Utility.validateStringForAlphanumericOflength20(lastname)) {
					System.out.println("Last name should be 3-20 characters long and starts with letter...!");
					lastname = Utility.getString();
				}
				System.out.println("Enter 10 digit mobile number");
				mobile = Utility.getString();
				while (!Utility.validateMobileNumber(mobile)) {
					System.out.println("Mobile number should be 10-digits and starts with 7/8/9...!");
					mobile = Utility.getString();
				}
				System.out.println("Enter username");
				username = Utility.getString();
				while (!Utility.validateStringForAlphanumericOflength20(username)) {
					System.out.println("Username should be 3-20 characters long and starts with letter...!");
					username = Utility.getString();
				}
				System.out.println("Enter password");
				password = Utility.getString();
				while (!Utility.validateStringForAlphanumericOflength20(password)) {
					System.out.println("Password should be 3-20 characters long and starts with letter...!");
					password = Utility.getString();
				}
				while(loginObj.isDuplicateUSer(username).equals("SUCCESS")) { // check for duplicate username
					System.out.println("Username already exists, enter another username....!");
					username = Utility.getString();
					while (!Utility.validateStringForAlphanumericOflength20(username)) {
						System.out.println("Username should be 3-20 characters long and starts with letter...!");
						username = Utility.getString();
					}
				}
				Object obj = loginObj.register(firstname, lastname, mobile, username, password);
				if(obj instanceof User) {
					System.out.println("Successfully Registered the user.");
					System.out.println((User)obj);
				}
				else if(obj == null)
				System.out.println("Registration failed...!");
				else
					System.out.println(obj);
				break;

			case 2: // *********** Login **************************** /
				System.out.println("Enter username");
				username = Utility.getString();
				while (!Utility.validateStringForAlphanumericOflength20(username)) {
					System.out.println("Username should be 3-20 characters long and starts with letter...!");
					username = Utility.getString();
				}
				System.out.println("Enter password");
				password = Utility.getString();
				while (!Utility.validateStringForAlphanumericOflength20(password)) {
					System.out.println("Password should be 3-20 characters long and starts with letter...!");
					password = Utility.getString();
				}
				result = loginObj.login(username, password);
				if(result.equals("SUCCESS"))
					System.out.println("Successfully logged in.");
				else
					System.out.println(result);
				break;
				
			case 3 : //*********** List all users **************************** /
				List<User> allUsers = loginObj.getAllUsers(); 
				if(allUsers != null)
				{
					System.out.println("Id\t Firstname\t Lastname\t Mobile\t Username\t Password");
					System.out.println("-----------------------------------------------------------------");
					for(User user : allUsers) {
						System.out.println(user.getId()+"\t "+user.getFirstname()+"\t "+user.getLastname()+"\t "+user.getMobile()+"\t "+
					    user.getUsername()+"\t "+user.getPassword());
					}
				}
				else
					System.out.println("There are no users exists...!");
				break;
			}// end of switch
		} while (choice != 4);
		System.out.println("\nProgram ended...!");
	}// end of main
}