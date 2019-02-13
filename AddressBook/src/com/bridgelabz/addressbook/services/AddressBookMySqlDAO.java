package com.bridgelabz.addressbook.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.bridgelabz.addressbook.models.AddressBook;
import com.bridgelabz.addressbook.models.AddressList;
import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.util.Constants;

public class AddressBookMySqlDAO implements AddressBook {
	MySqlQueries queries = new MySqlQueries();
	@Override
	public String isAddressBookExists(String addressBook) {
		boolean result = queries.checkAddressBookIsPresent(addressBook.trim());
		if(result)
			return Constants.SUCCSESS;
		else
			return "Doesn't exists...!";
	}

	@Override
	public String createAddressBook(String addressBook) {
		if(queries.checkAddressBookIsPresent(addressBook))
			return "Addressbook already exists...!";
		return queries.creataAddressBook(addressBook.trim());
	}

	@Override
	public String deleteAddressBook(String addressBook) {
		return queries.deleteAddressBook(addressBook);
	}

	@Override
	public String saveAs(Set<Person> addressList, String filetype, String addressBook) {
		//write to a new text file with same name as of that the address book name
				String saveAsFilePath = Constants.SAVEASPATH+addressBook+filetype;
				File saveAsFile = new File(saveAsFilePath);
				String result;
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(saveAsFile,true))){
					for(Person person : addressList) {
						String address = "ID = "+person.getId()+"  FirstName = "+person.getFirstName();
						address = address + "  LastName = "+person.getLastName()+"  City = "+person.getCity();
						address = address + "  State = "+person.getState() + "  Zip = "+ person.getZip()+"  PhoneNumber = "+person.getPhoneNumber();
						address = address +"\n";
						bw.write(address);	
					}
					result = Constants.SUCCSESS;
				} catch (IOException e) {
					e.printStackTrace();
					result = e.getMessage();
				}
				return result;
	}

	@Override
	public List<String> listAllAddressBook() {
		return queries.retrieveAllAddressBooks();
	}

	@Override
	public String isAddressExists(int id, String addressBook) {
		return queries.serachAddressById(id, addressBook.trim());
	}

	@Override
	public String addNewAddress(Person bean, String addressBook) {
		return queries.addAddress(bean, addressBook.trim());
	}

	@Override
	public String updateAddress(int id, Person bean, String addressBook) {
		return queries.updateAddress(id, bean, addressBook.trim());
	}

	@Override
	public String removeAddress(int id, String addressBook) {
		return queries.removeAddress(id, addressBook.trim());
	}

	@Override
	public AddressList listAllAddresses(String addressBook) {
		List<Person> addresses = queries.getAllAddressesOfAddressBook(addressBook.trim());
		if(addresses == null)
			return null;
		PersonAddressComparatorByLastName<Person> comparator = new PersonAddressComparatorByLastName<>();
		Set<Person> addressSet = new TreeSet<>(comparator);
		addressSet.addAll(addresses);
		AddressList addrList = new AddressList();
		addrList.setAddresses(addressSet);
		return addrList;
	}
}
