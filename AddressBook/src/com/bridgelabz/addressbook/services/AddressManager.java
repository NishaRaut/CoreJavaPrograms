package com.bridgelabz.addressbook.services;

import java.util.List;
import java.util.Set;

import com.bridgelabz.addressbook.models.AddressBook;
import com.bridgelabz.addressbook.models.AddressBookFactory;
import com.bridgelabz.addressbook.models.AddressList;
import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.util.Constants;
import com.bridgelabz.addressbook.util.Utility;

public class AddressManager {
	AddressBook controller = AddressBookFactory.getDAO();
	/**
	 * add a new address book
	 * @param name name of the new address book
	 * @return status of addition of new address book
	 */
	public String addAddressBook(String name)
	{
		if(!Utility.validateStringForAlphanumericOflength20(name))
			return "AddressBook Name should be Alphanumeric of Length 3-20 And Start with a Letter";
		if(controller.isAddressBookExists(name).equals(Constants.SUCCSESS))
			return "AddressBook '"+ name +"' is already exists.. Plz Enter another name.";
		else
			return controller.createAddressBook(name);		
	}

	/**
	 * get all the address books
	 * @return list of all the address books
	 */
	public List<String> loadAddressBook()
	{
		return controller.listAllAddressBook();
	}
	/**
	 * delete an address book
	 * @param name name of the address book
	 * @return
	 */
	public String removeAddressBook(String name)
	{
		if(!Utility.validateStringForAlphanumericOflength20(name))
			return "AddressBook Name should be Alphanumeric of Length 3-20 And Start with a Letter";
		if(controller.isAddressBookExists(name).equals(Constants.SUCCSESS))
			return controller.deleteAddressBook(name);
		else
			return "AddressBook '"+ name +"' doesn't exists...!!!";
	}

	/**
	 * list all the address books
	 * @return list of all address books
	 */
	public List<String> listAllAddressBook() {
		return controller.listAllAddressBook();
	}

	public String isAddressBookExists(String addressBook) {
		if(!Utility.validateStringForAlphanumericOflength20(addressBook))
			return "AddressBook Name should be Alphanumeric of Length 3-20 And Start with a Letter";
		else if(controller.isAddressBookExists(addressBook).equals(Constants.SUCCSESS))
			return Constants.SUCCSESS;
		else
			return "AddressBook '"+ addressBook +"' doesn't exists...!!!";
	}

	public String saveAsAddressBook(Set<Person> addressList, String filetype, String addressBook) {
		return controller.saveAs(addressList, filetype, addressBook);
	}
	//<-------------- Persons address methods ------------------------------>
	/**
	 * add a new person address into the address book
	 * @param bean Person address object
	 * @param addressBook AddressBook name                        
	 * @return address addition status
	 */
	public String addAddress(Person bean, String addressBook)
	{
		return controller.addNewAddress(bean, addressBook);
	}

	/**
	 * delete the address of a person
	 * @param bean address object
	 * @param addressBook name of the address book
	 * @return address deletion status
	 */
	public String removeaddress(int id, String addressBook)
	{
		if(controller.isAddressExists(id, addressBook).equals(Constants.SUCCSESS))
			return  controller.removeAddress(id, addressBook);
		else
			return "Person Address '"+id+"' Doesn't Exists...!!!";
	}

	/**
	 * editing the address of a person
	 * @param bean address object
	 * @param addressBook name of the address book
	 * @return address updation status
	 */
	public String updateAddress(Person bean, String addressBook)
	{
		if(!controller.isAddressExists(bean.getId(), addressBook).equals(Constants.SUCCSESS))
			return "Person Address '"+bean.getId()+"' Doesn't Exists...!!!";
		return controller.updateAddress(bean.getId(), bean, addressBook);
	}

	/**
	 * get list of all the addresses of a Address Book
	 * @param addressBook name of the address book
	 * @return list of addresses
	 */
	public AddressList listAllAddresses(String addressBook)
	{
		return controller.listAllAddresses(addressBook);
	}
	/**
	 * check for the address existance for a given id
	 * @param id id of the address
	 * @param addressBook name of the address book
	 * @return search status
	 */
	public String isAddressExists(int id, String addressBook) {
		return controller.isAddressExists(id, addressBook);
	}
	/**
	 * gives the ID of the recently added address
	 * @return ID of the most recent address
	 */
	public int getIdOfLastAddress(String addressBook) {
		AddressList addressList = controller.listAllAddresses(addressBook);
		Set<Person> addresses = addressList.getAddresses();
		if(addressList == null || addresses == null)
			return 1;
		else {		
			if(addresses.size() != 0) {
				int count = 0;
				for(Person p : addresses) {
					if(count < p.getId()) {
						count = p.getId();
					}
				}
				return count;
			}
			return 1;
		}
	}
}
