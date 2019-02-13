package com.bridgelabz.jdbc.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.jdbc.models.Student;
import com.bridgelabz.jdbc.util.JDBCHelper;

public class StatementExecution {
	/**
	 * checks whether a row with given id is present or not in a database table
	 * 
	 * @param id id to be searched
	 * @return true if id exists else false
	 */
	public boolean serahcId(int id) {
		boolean result = false;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = JDBCHelper.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("Select * from Student where id = " + id);
			if (rs.next())
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * insert a new student record
	 * 
	 * @param stud Student object to be inserted into table
	 * @return student object inserted with generated id
	 */
	public Student insert(Student stud) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		int id = 0;
		String query = "Insert into Student(name, age, major)" + " values('"+stud.getName() + "'," + stud.getAge() + 
				",'"+ stud.getMajor() + "')";
		try {
			con = JDBCHelper.getConnection();
			st = con.createStatement();
			count = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			rs = st.getGeneratedKeys(); 
			if (count > 0) {
				while(rs.next())
					id = rs.getInt(1);
				stud.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			stud = null;
		} finally {
			JDBCHelper.close(rs);
			JDBCHelper.close(st);
			JDBCHelper.close(con);
		}
		return stud;
	}

	/**
	 * updating a row by id
	 * @param stud student record to be updated
	 * @return no. of rows affected
	 */
	public int update(Student stud) {
		Connection con = null;
		Statement st = null;
		int count = 0;
		String query = "Update Student set ";
		String query2 = "";
		if (stud.getName() != null && stud.getAge() == 0 && stud.getMajor() == null)
			query2 = "name = " + "'"+stud.getName()+"'";
		else if (stud.getName() == null && stud.getAge() != 0 && stud.getMajor() == null)
			query2 = "age = " + stud.getAge();
		else if (stud.getName() == null && stud.getAge() == 0 && stud.getMajor() != null)
			query2 = "major = " + "'"+stud.getMajor()+"'";
		else if(stud.getName() != null && stud.getAge() != 0 && stud.getMajor() == null)
			query2 = "name = " + "'"+stud.getName()+"'," +" age = " + stud.getAge();
		else if(stud.getName() == null && stud.getAge() != 0 && stud.getMajor() != null)
			query2 = "age = " + stud.getAge() + ", major = " + "'"+stud.getMajor()+"'";
		else if(stud.getName() != null && stud.getAge() == 0 && stud.getMajor() != null)
			query2 = "name = " + "'"+stud.getName()+"'," +" major = " + "'"+stud.getMajor()+"'";
		else
			query2 = "name = " + "'"+stud.getName()+"'," +" age = " + stud.getAge()+", major = "+","+stud.getMajor()+"'";
		query = query + query2 + " where id = " + stud.getId();
		try {
			con = JDBCHelper.getConnection();
			st = con.createStatement();
			count = st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCHelper.close(st);
			JDBCHelper.close(con);
		}
		return count;
	}
	
	/**
	 * deletes record by id
	 * @param id id of the record to be deleted
	 * @return no.of records got deleted
	 */
	public int delete(int id) {
		Connection con = null;
		Statement st = null;
		int count = -1;
		String query = "Delete from Student where id = "+id;
		try {
			con = JDBCHelper.getConnection();
			st = con.createStatement();
			count = st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCHelper.close(st);
			JDBCHelper.close(con);
		}
		return count;
	}
	
	/**
	 * retrieves all the records from the Student table
	 * @return list of Students
	 */
	public List<Student> retrieveAll(){
		List<Student> students = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = "Select * from Student";
		try {
			con = JDBCHelper.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				if(students == null)
					students = new ArrayList<>();
				Student stud = new Student();
				stud.setId(rs.getInt("id"));
				stud.setName(rs.getString("name"));
				stud.setAge(rs.getInt("age"));
				stud.setMajor(rs.getString("major"));
				students.add(stud);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCHelper.close(rs);
			JDBCHelper.close(st);
			JDBCHelper.close(con);
		}
		return students;
	}
}
