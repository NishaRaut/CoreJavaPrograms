package com.bridgelabz.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCHelper {
	
	/**
	 * get the connection instance to the the db server
	 * @return connection instance
	 */
	public static Connection getConnection()
	{
		try
		{
			Class.forName(Constants.DRIVER);
			return DriverManager.getConnection(Constants.URL,Constants.UID,Constants.PWD);
		}
		catch(ClassNotFoundException e)
		{
		  e.printStackTrace();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
  
	/**
	 * close the ResultSet instance
	 * @param rs ResultSet instance
	 */
	public static void close(ResultSet rs)
	{
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * close the Statement instance
	 * @param rs Statement instance
	 */
	public static void close(Statement st)
	{
		if(st!=null)
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * close the Connection instance
	 * @param rs Connection instance
	 */
	public static void close(Connection con)
	{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}


