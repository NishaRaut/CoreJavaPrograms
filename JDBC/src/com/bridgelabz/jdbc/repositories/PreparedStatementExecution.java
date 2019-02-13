package com.bridgelabz.jdbc.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.jdbc.models.User;
import com.bridgelabz.jdbc.util.JDBCHelper;

public class PreparedStatementExecution {
	/**
	 * check the username is present in the databse
	 * @param username username
	 * @return "SUCCESS" if username exists else some message
	 */
	public String checkUserExistance(String username) {
		String result = "";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCHelper.getConnection();
			ps = con.prepareStatement("Select * from User where username = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next())
				result = "SUCCESS";
			else
				result = "Username doesn't exists.";
		} catch (SQLException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		finally {
			JDBCHelper.close(rs);
			JDBCHelper.close(ps);
			JDBCHelper.close(con);
		}
		return result;
	}

	/**
	 * insert a new user 
	 * @param user new user instance
	 * @return new user instance with the its id
	 */
	public Object insertNewUSer(User user) {
		Object result = null;
		int count = -1;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "Insert into User(firstname,lastname,mobile,username,password)" +
				"Values(?,?,?,?,?)";
		try {
			con = JDBCHelper.getConnection();
			ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getMobile());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			count = ps.executeUpdate();
			if (count > 0) {
				rs = ps.getGeneratedKeys();
				rs.next();
				user.setId(rs.getInt(1));
				result = user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		finally {
			JDBCHelper.close(rs);
			JDBCHelper.close(ps);
			JDBCHelper.close(con);
		}
		return result;
	}
	
	/**
	 * check login credentials are correct
	 * @param username username of the user
	 * @param password password of the user
	 * @return "SUCCESS" if credentials are correct else some error message
	 */
	public String logIn(String username, String password) {
		String result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "Select * from User where username = ? and password = ?";
		try {
			con = JDBCHelper.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = "SUCCESS";
			}
			else
				result = "Invalid login credentials...!";
		} catch (SQLException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		finally {
			JDBCHelper.close(rs);
			JDBCHelper.close(ps);
			JDBCHelper.close(con);
		}
		return result;
	}
	
	/**
	 * retrieves all users
	 * @return list of all users
	 */
	public List<User> getAllUsers(){
		List<User> users = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "Select * from User";
		try {
			con = JDBCHelper.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(users == null)
					users = new ArrayList<>();
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setMobile(rs.getString("mobile"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCHelper.close(rs);
			JDBCHelper.close(ps);
			JDBCHelper.close(con);
		}
		return users;
	}
}
