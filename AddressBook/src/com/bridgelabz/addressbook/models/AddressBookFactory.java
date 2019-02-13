package com.bridgelabz.addressbook.models;

import com.bridgelabz.addressbook.services.AddressBookFileDAO;
import com.bridgelabz.addressbook.services.AddressBookMySqlDAO;
import com.bridgelabz.addressbook.util.Constants;

public class AddressBookFactory {
	public static AddressBook getDAO()
	{
		if(Constants.DAO.equals("file"))
			return new AddressBookFileDAO();
		else if(Constants.DAO.equals("mysqldb"))
			return new AddressBookMySqlDAO();
		else
			return new AddressBookFileDAO();//default
	}
}
