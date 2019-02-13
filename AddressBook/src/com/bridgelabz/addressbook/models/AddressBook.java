package com.bridgelabz.addressbook.models;

import java.util.List;
import java.util.Set;

import com.bridgelabz.addressbook.models.AddressList;
import com.bridgelabz.addressbook.models.Person;

public interface AddressBook {
	public String isAddressBookExists(String addressBook);
	public String createAddressBook(String addressBook);
	public String deleteAddressBook(String addressBook);
	public String saveAs(Set<Person> addressList, String filetype,String addressBook);
	public List<String> listAllAddressBook();

	//Task methods
	public String isAddressExists(int id, String addressBook);
	public String addNewAddress(Person bean, String addressBook);
	public String updateAddress(int id,Person bean, String addressBook);
	public String removeAddress(int id, String addressBook);
	public AddressList listAllAddresses(String addressBook);
}
