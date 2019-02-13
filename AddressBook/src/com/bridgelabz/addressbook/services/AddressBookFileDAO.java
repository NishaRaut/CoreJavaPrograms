package com.bridgelabz.addressbook.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.bridgelabz.addressbook.models.AddressBook;
import com.bridgelabz.addressbook.models.AddressList;
import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddressBookFileDAO implements AddressBook {

	@Override
	public String isAddressBookExists(String addressBook) {
		File file = new File(Constants.PATH+addressBook+Constants.EXTENSION);
		if(file.exists())
			return Constants.SUCCSESS;
		else
			return "AddressBook '"+addressBook +"' Doesn't exists...!!";
	}

	@Override
	public String createAddressBook(String addressBook) {
		File file = new File(Constants.PATH+addressBook+Constants.EXTENSION);
		//Write JSON file
		try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
			return Constants.SUCCSESS;
		}
		catch(IOException e)
		{
			return "Oops...Something Wrong happens ...!!!"+e.getMessage();
		}
	}

	@Override
	public String deleteAddressBook(String addressBook) {
		File f = new File(Constants.PATH+addressBook+Constants.EXTENSION);
		if(f.exists())
		{
			f.delete();
			return Constants.SUCCSESS;
		}
		else
			return "Sorry..!!! Category '"+addressBook+"' Doesn't Exists !!";
	}

	@Override
	public List<String> listAllAddressBook() {
		File f = new File(Constants.PATH);
		Collection<String>addressBooks = new ArrayList<String>();
		String[] allbooks=null;
		if(f.exists())
		{
			allbooks = f.list();
			for(String book : allbooks)
			{
				addressBooks.add(book.split("\\.")[0]);
			}
			return new ArrayList<String>(addressBooks);
		}
		else
			return null; 
	}

	/**
	 * saving the opened address book into a specific file format
	 */
	@Override
	public String saveAs(Set<Person> addressList, String filetype,String addressBook) {
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

	//<-------------------------- persons addresses functionalities ------------------> 
	@Override
	public String isAddressExists(int id, String addressBook) {
		File file = new File(Constants.PATH+addressBook+Constants.EXTENSION);
		ObjectMapper objectMapper = new ObjectMapper();
		AddressList addrList = null;
		try {
			addrList = objectMapper.readValue(file, AddressList.class);
			for(Person pb : addrList.getAddresses()) {
				if(pb.getId() == id) {
					return Constants.SUCCSESS;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Specified Address Doesn't Exists...!";
	}


	@Override
	public String addNewAddress(Person bean, String addressBook) {
		String filePath = Constants.PATH+addressBook+Constants.EXTENSION;
		File file = new File(filePath);
		ObjectMapper objectMapper = new ObjectMapper();
		AddressList addrList = null;
		try {
			if(file.length()== 0) {// empty json file
				bean.setId(1);
				addrList = new AddressList();
				addrList.setAddresses(new TreeSet<>());
			}
			else {
				//read data from the file
				addrList = objectMapper.readValue(file, AddressList.class);
				if(addrList.getAddresses().size() != 0) {
					int count = 0;
					for(Person p : addrList.getAddresses()) {
						if(count < p.getId()) {
							count = p.getId();
						}
					}
					bean.setId(count + 1);		
				}
				else
					bean.setId(1);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		addrList.getAddresses().add(bean);
		//write back to address book
		try {
			objectMapper.writeValue(file, addrList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Constants.SUCCSESS;
	}

	@Override
	public String updateAddress(int id, Person bean, String addressBook) {
		String filePath = Constants.PATH+addressBook+Constants.EXTENSION;
		File file = new File(filePath);
		ObjectMapper objectMapper = new ObjectMapper();
		AddressList addrList = null;
		//read data from the file and get the required address
		Person oldAddress = null;
		try {
			addrList = objectMapper.readValue(file, AddressList.class);
			for(Person pb : addrList.getAddresses()) {
				if(pb.getId() == id)
				{
					oldAddress = pb;
					addrList.getAddresses().remove(pb);//remove the required bean obj from the list
					break;
				}
			}
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		//write back to the file with the updated address
		if(bean.getFirstName() != null)
			oldAddress.setFirstName(bean.getFirstName());
		if(bean.getLastName() != null)
			oldAddress.setLastName(bean.getLastName());
		if(bean.getCity() != null)
			oldAddress.setCity(bean.getCity());
		if(bean.getState() != null)
			oldAddress.setState(bean.getState());
		if(bean.getZip() != 0)
			oldAddress.setZip(bean.getZip());
		if(bean.getPhoneNumber() != 0)
			oldAddress.setPhoneNumber(bean.getPhoneNumber());
		addrList.getAddresses().add(oldAddress);
		try {
			objectMapper.writeValue(file, addrList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Constants.SUCCSESS;
	}

	@Override
	public String removeAddress(int id, String addressBook) {
		String filePath = Constants.PATH+addressBook+Constants.EXTENSION;
		File file = new File(filePath);
		ObjectMapper objectMapper = new ObjectMapper();
		AddressList addrList = null;
		try {
			//read data from the file
			addrList = objectMapper.readValue(file, AddressList.class);
			for(Person pb : addrList.getAddresses()) {
				if(pb.getId() == id)
				{
					addrList.getAddresses().remove(pb);//remove the required bean obj from the list
					break;
				}
			}
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		//write back to the file
		try {
			objectMapper.writeValue(file, addrList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Constants.SUCCSESS;
	}

	@Override
	public AddressList listAllAddresses(String addressBook) {
		File file = new File(Constants.PATH+addressBook+Constants.EXTENSION);
		AddressList addrList = null;
		if(file.length() == 0)
		{
			return null;
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			addrList = objectMapper.readValue(file, AddressList.class);
		} catch (IOException e) {
			e.printStackTrace();
		};
		return addrList;
	}

}
