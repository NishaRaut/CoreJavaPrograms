package com.bridgelabz.jdbc.services;

import java.util.List;

import com.bridgelabz.jdbc.models.User;
import com.bridgelabz.jdbc.repositories.PreparedStatementExecution;

public class LoginByPreparedStmt {
	PreparedStatementExecution executePSQuery = new PreparedStatementExecution();
   
	/**
	 * Adds a new user to the users list
	 * @param firstname firstname of the user
	 * @param lastname lastname of the user
	 * @param mobile mobile number of the user
	 * @param username unique username of the user
	 * @param password password of the user
	 * @return SUCCESS if the user registered successfully else some error message
	 */
	public Object register(String firstname, String lastname, String mobile,String username,String password) {
		User newUser = new User();
		newUser.setFirstname(firstname);
		newUser.setLastname(lastname);
		newUser.setMobile(mobile);
		newUser.setUsername(username);
		newUser.setPassword(password);
		return executePSQuery.insertNewUSer(newUser);
   }
   
	/**
	 * log in the user
	 * @param username username of the user
	 * @param password password of the user
	 * @return "SUCCESS" if the user logged in successfully else some error message 
	 */
   public String login(String username, String password) {
	   return executePSQuery.logIn(username.trim(), password.trim());
   }
   
   /**
    * get all the registered users
    * @return list of users
    */
   public List<User> getAllUsers(){
	   List<User> allUsers = executePSQuery.getAllUsers();
	   return allUsers;
   }
   
   /**
    * checks whether a username is present or not in the database
    * @param username username
    * @return "SUCCESS" if username exists else some appropriate message
    */
   public String isDuplicateUSer(String username) {
	   String result = executePSQuery.checkUserExistance(username.trim());
	   return result;
   }
}