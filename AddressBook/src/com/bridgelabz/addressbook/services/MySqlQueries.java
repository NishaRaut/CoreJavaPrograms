package com.bridgelabz.addressbook.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.util.Constants;
import com.bridgelabz.addressbook.util.JDBCHelper;

public class MySqlQueries {
	public List<String> retrieveAllAddressBooks() {
		List<String> addrBooks = null;
		String query = "Select * from AddressBook";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCHelper.getConnection();
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				if(addrBooks == null)
					addrBooks = new ArrayList<>();
				addrBooks.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCHelper.close(rs);
			JDBCHelper.close(pst);
			JDBCHelper.close(con);
		}
		return addrBooks;
	}

	/**
	 * check for the existance of an addressbook
	 * @param addressBook name of the addressbook
	 * @return true if exists else false
	 */
	public boolean checkAddressBookIsPresent(String addressBook) {
		String query = "Select * from AddressBook where name = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			con = JDBCHelper.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, addressBook);
			rs = pst.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCHelper.close(rs);
			JDBCHelper.close(pst);
			JDBCHelper.close(con);
		}
		return result;
	}

	//create a new address table
	public String creataAddressBook(String addressBook) {
		String result = "";
		String query = "CREATE TABLE "+addressBook +"(\n" + 
				       "id INT(11) NOT NULL AUTO_INCREMENT,\n" + 
				       "firstName VARCHAR(45),\n" + 
				       "lastName VARCHAR(45),\n" + 
				       "city VARCHAR(45),\n" + 
				       "state VARCHAR(45),\n"+
				       "zip INT(11),\n" + 
				       "phoneNumber BIGINT(11),\n" + 
				       "PRIMARY KEY (id)"+"\n"+
				       ");";
		String query2 = "Insert into AddressBook(name) \nvalues(?);";
				        
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		int count = -1;
		try {
			con = JDBCHelper.getConnection();
			pst = con.prepareStatement(query);
			count = pst.executeUpdate();
			if(count > -1) {
				//add addressbook name to AddressBook table
				pst2 = con.prepareStatement(query2);
				pst2.setString(1, addressBook);
				count = - 1;
				count = pst2.executeUpdate();
				if(count > 0)
				  result = Constants.SUCCSESS;
			}
			else
				result = "Address Book with name '"+ addressBook + "' not created...!";
		} catch (SQLException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		finally {
			JDBCHelper.close(pst);
			JDBCHelper.close(con);
		}
		return result;
	}
	
	//delete an address table
		public String deleteAddressBook(String addressBook) {
			String result = "";
			String query = "DROP TABLE" + addressBook + ";";
			String query2 = "DELETE FROM AddressBook WHERE name = ?;";
			Connection con = null;
			PreparedStatement pst = null;
			PreparedStatement pst2 = null;
			int count = -1;
			try {
				con = JDBCHelper.getConnection();
				pst = con.prepareStatement(query);
				count = pst.executeUpdate();
				if(count == 1) {
					result = "SUCCESS";
					//delete from the AddressBook table the name of the table deleted
					pst2 = con.prepareStatement(query2);
					pst.setString(1, addressBook);
					pst.executeUpdate();
				}
				else
					result = "Address Book with name '"+ addressBook + "' not deleted...!";
			} catch (SQLException e) {
				e.printStackTrace();
				result = e.getMessage();
			}
			finally {
				JDBCHelper.close(pst);
				JDBCHelper.close(pst2);
				JDBCHelper.close(con);
			}
			return result;
		}
		
		//search an address in a address table
		public String serachAddressById(int id, String addressBook) {
			String result = "";
			String query = "Select * from "+addressBook+ " where id = ?";
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				con = JDBCHelper.getConnection();
				pst = con.prepareStatement(query);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				if(rs.next()) {
					result = "SUCCESS";
				}
				else
					result = "Address with id '" + id + "' doesn't exists...!";
			} catch (SQLException e) {
				e.printStackTrace();
				result = e.getMessage();
			}
			finally {
				JDBCHelper.close(rs);
				JDBCHelper.close(pst);
				JDBCHelper.close(con);
			}
			return result;
		}
		
		/**
		 * adds a new address to a address table
		 * @param person new address instance of  a person
		 * @param addressBook name of the addressbook
		 * @return SUCCESS if added else some error message
		 */
		public String addAddress(Person person, String addressBook) {
			String result = "";
			String query = "insert into "+addressBook +" (firstName, lastName, city,state,zip,phoneNumber)\n"+
			                "values(?,?,?,?,?,?)";
			
			Connection con = null;
			PreparedStatement pst = null;
			int count = -1;
			try {
				con = JDBCHelper.getConnection();
				pst = con.prepareStatement(query);
				pst.setString(1, person.getFirstName());
				pst.setString(2, person.getLastName());
				pst.setString(3, person.getCity());
				pst.setString(4, person.getState());
				pst.setInt(5, person.getZip());
				pst.setLong(6, person.getPhoneNumber());
				count = pst.executeUpdate();
				if(count > 0)
					result = Constants.SUCCSESS;
				else
					result = "Address not added to the addressbook...!";
			} catch (SQLException e) {
				e.printStackTrace();
				result = e.getMessage();
			}
			finally {
				JDBCHelper.close(pst);
				JDBCHelper.close(con);
			}
			return result;
		}
		
		/**
		 * updates an address in an addressbook 
		 * @param id id of the address
		 * @param newPerson address instance 
		 * @param addressBook name of the addressbook
		 * @return SUCCESS if updated else some error message
		 */
		public String updateAddress(int id, Person newPerson, String addressBook) {
			Person oldPerson = getAddressFromAddressBookById(id,addressBook);
			//update the old values with the new values
			if(newPerson.getCity() != null)
				oldPerson.setCity(newPerson.getCity());
			if(newPerson.getState() != null)
				oldPerson.setState(newPerson.getState());
			if(newPerson.getZip() != 0)
				oldPerson.setZip(newPerson.getZip());
			if(newPerson.getPhoneNumber() != 0)
				oldPerson.setPhoneNumber(newPerson.getPhoneNumber());
				
			String result = "";
			String query = "Update " + addressBook + "\n"+
			               "set city = ?, state = ?, zip = ?, phoneNumber = ? "+
					       "where id = ? ;";
			Connection con = null;
			PreparedStatement pst = null;
			int count = -1;
			try {
				con = JDBCHelper.getConnection();
				pst = con.prepareStatement(query);
				pst.setString(1, oldPerson.getCity());
				pst.setString(2, oldPerson.getState());
				pst.setInt(3, oldPerson.getZip());
				pst.setLong(4, oldPerson.getPhoneNumber());
				pst.setInt(5, id);
				count = pst.executeUpdate();
				if(count > 0)
					result = Constants.SUCCSESS;
				else
					result = "Address not updated to the addressbook...!";
			} catch (SQLException e) {
				e.printStackTrace();
				result = e.getMessage();
			}
			finally {
				JDBCHelper.close(pst);
				JDBCHelper.close(con);
			}
			return result;
		}
		
		/**
		 * deletes an existing address for the id
		 * @param id address id 
		 * @param addressBook name of the addressbook
		 * @return SUCCESS if deleted else some error messages
		 */
		public String removeAddress(int id, String addressBook) {
			String result = "";
			String query = "DELETE FROM "+ addressBook + "\n" + 
					       " WHERE id = ? ";
			Connection con = null;
			PreparedStatement pst = null;
			int count = -1;
			try {
				con = JDBCHelper.getConnection();
				pst = con.prepareStatement(query);
				pst.setInt(1, id);
				count  = pst.executeUpdate();
				if(count > 0)
					result = Constants.SUCCSESS;
				else
					result = "Address for the id '"+ id + "' not deleted...!";
			} catch (SQLException e) {
				e.printStackTrace();
				result = e.getMessage();
			}
			finally {
				JDBCHelper.close(pst);
				JDBCHelper.close(con);
			}
			return result;
		}
		
		/**
		 * gives all the address of an addressbook
		 * @param addressBook name of the addressbook
		 * @return list of addresses of an addressbook
		 */
		public List<Person> getAllAddressesOfAddressBook(String addressBook){
			List<Person> allAddress = null;
			String query = "Select * from "+addressBook + ";";
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				con = JDBCHelper.getConnection();
				pst = con.prepareStatement(query);
				rs = pst.executeQuery();
				while(rs.next()) {
					Person p = new Person();
					p.setId(rs.getInt("id"));
					p.setFirstName(rs.getString("firstName"));
					p.setLastName(rs.getString("lastName"));
					p.setCity(rs.getString("city"));
					p.setState(rs.getString("state"));
					p.setZip(rs.getInt("zip"));
					p.setPhoneNumber(rs.getLong("phoneNumber"));
					if(allAddress == null)
						allAddress = new ArrayList<>();
					allAddress.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				JDBCHelper.close(rs);
				JDBCHelper.close(pst);
				JDBCHelper.close(con);
			}
			return allAddress;
		}
		
		/**
		 * gives an address from the addressbook
		 * @param id
		 * @param addressBook
		 * @return
		 */
		public Person getAddressFromAddressBookById(int id, String addressBook) {
			String query = "Select * from "+ addressBook + " where id = ?";
			
			Person person = null;
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				con = JDBCHelper.getConnection();
				pst = con.prepareStatement(query);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				if(rs.next()) {
					person = new Person();
					person.setId(rs.getInt("id"));
					person.setFirstName(rs.getString("firstName"));
					person.setLastName(rs.getString("lastName"));
					person.setCity(rs.getString("city"));
					person.setState(rs.getString("state"));
					person.setZip(rs.getInt("zip"));
					person.setPhoneNumber(rs.getLong("phoneNumber"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				JDBCHelper.close(rs);
				JDBCHelper.close(pst);
				JDBCHelper.close(con);
			}
			return person;
		}
}
