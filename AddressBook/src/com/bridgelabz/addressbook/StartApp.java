package com.bridgelabz.addressbook;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.bridgelabz.addressbook.models.AddressList;
import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.services.AddressManager;
import com.bridgelabz.addressbook.services.PersonAddressComparatorByLastName;
import com.bridgelabz.addressbook.util.Constants;
import com.bridgelabz.addressbook.util.Utility;

public class StartApp {

	public static void main(String[] args) {
		System.out.println("***************** Welcome to Address Book App ******************************");
		int mainMenu;
		String addBookName;
		String result = "";
		AddressManager manager = new AddressManager();
		do {
			System.out.println("Press 1 => Create New Address Book..!");
			System.out.println("Press 2 => Open Address Book..!");
			System.out.println("Press 3 => Quit Application..!\n");
			System.out.println("\t Enter your choice...!");
			mainMenu = Utility.getPositiveInteger();
			switch(mainMenu) {
			//***************Creating a new Address Book **************************
			case 1 : System.out.println("\t Enter the Address Book Name...!");
			result = "";
			do
			{  
				System.out.println(result);
				addBookName = Utility.sc.next();
				result = manager.addAddressBook(addBookName);
			}while(!result.equals(Constants.SUCCSESS));
			System.out.println("\t AddressBook '"+ addBookName+"' is Created Successfully...\n");
			break;

			case 2 : //Open an existing address book
				List<String> allAddressBooks = manager.loadAddressBook();
				if(allAddressBooks == null)
					System.out.println("\t There are no address books...!");
				else {//display all the address books
					System.out.println("********************Address Books List ***********************");
					System.out.println("SL No. \t Name");
					System.out.println("-------------------------------------------------");
					for(int i = 0; i < allAddressBooks.size(); i++) {
						System.out.println(i+1 + "\t "+allAddressBooks.get(i));
					}

					boolean flag=false;
					System.out.println("\n\n\t Enter AddressBook Name To Open...!!!");
					do
					{
						addBookName = Utility.sc.next();
						flag = Utility.validateStringForAlphanumericOflength20(addBookName);
						if(!flag)
							System.out.println("\t AddressBook Name should be Alphanumeric Value of Length 3-20 And Start with a Letter \n");
					}while(!flag);
					result = manager.isAddressBookExists(addBookName);
					if(result.equals(Constants.SUCCSESS)){
						AddressList allAddresses = manager.listAllAddresses(addBookName);
						Set<Person> addressList = null;
						if(allAddresses != null)
							addressList = allAddresses.getAddresses();
						displayAddressBookData(addressList);
						//********show the Address menu*************************//
						boolean menu2 = true;
						do
						{
							menu2=subMenu(addBookName);
						}while(menu2);
					}
					else {
						System.out.println("'"+addBookName+"' doesn't exists....!");
					}
				}
				break;

			case 3 : //program ends 
				System.out.println("************* Bye Bye *********************");
				System.exit(1);
			}
		}while(mainMenu != 6);
	}// end of the application

	public static boolean subMenu(String addressBook)
	{
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);//to read a single word
		AddressManager manager = new AddressManager();
		String result;
		boolean addrMenu = true;
		int choice;
		System.out.println("");
		System.out.println("Press 1 to Add a New Address!");
		System.out.println("Press 2 to Remove an Address!");
		System.out.println("Press 3 to Edit an Address!");
		System.out.println("Press 4 to List the Addresses By Last Name!");
		System.out.println("Press 5 to Close Address Book!");
		System.out.println("\n\tEnter choice !!!");


		while(!s1.hasNextInt())
		{
			System.out.println("\n\t Enter Eumber from 1 to 5 Only...!!!");
			s1.next();
		}
		choice=s1.nextInt();
		switch(choice)
		{
		case 1:  //Add New Address

			String firstName;
			String lastName;
			String city;
			String state;
			int zip;
			long phoneNumber;
			int id;
			System.out.println("\t Enter Person's First Name...!!!");
			while(true)
			{
				firstName = s1.next();
				if(!Utility.validateStringForAlphanumericOflength20(firstName))
					System.out.println("\tFirst Name should be Alphanumeric of Length 3-20 And Start with a Letter \n ");
				else
					break;
			}
			System.out.println("\t Enter Person's Last Name...!!!");
			while(true)
			{
				lastName = s1.next();
				if(!Utility.validateStringForAlphanumericOflength20(firstName))
					System.out.println("Last Name should be Alphanumeric of Length 3-20 And Start with a Letter \n ");
				else
					break;
			}
			System.out.println("\t Enter City Name...!!!");
			while(true)
			{
				city = s1.next();
				if(!Utility.validateStringForAlphanumericOflength20(firstName))
					System.out.println("City Name should be Alphanumeric of Length 3-20 And Start with a Letter \n ");
				else
					break;
			}
			System.out.println("\t Enter State Name...!!!");
			while(true)
			{
				state = s1.next();
				if(!Utility.validateStringForAlphanumericOflength20(firstName))
					System.out.println("State Name should be Alphanumeric of Length 3-20 And Start with a Letter \n ");
				else
					break;
			}

			String input = null;
			do {
				System.out.println("\t Enter 6-digits zip code...!!! ");
				input=s1.next();
			}while(!Utility.validateZipCode(input));
			zip = Integer.parseInt(input);

			input = null;
			do {
				System.out.println("\t Enter 10-digits mobile number...!!! ");
				input=s1.next();
			}while(!Utility.validateMobileNumber(input));
			phoneNumber = Long.parseLong(input);
			//now create a person bean
			Person bean = new Person();
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setCity(city);
			bean.setState(state);
			bean.setZip(zip);
			bean.setPhoneNumber(phoneNumber);
			AddressList allAddresses = manager.listAllAddresses(addressBook);
			Set<Person> addressList = null;
			if(allAddresses != null) {
				addressList = allAddresses.getAddresses();
				bean.setId(manager.getIdOfLastAddress(addressBook)+1);
			}
			else {
				bean.setId(1);
				addressList = new TreeSet<Person>();
			}
			addressList.add(bean);
			//System.out.println("\t Address got added to your address book...!");
			displayAddressBookData(addressList);
			//save menu
			int saveOption = saveMenu();
			switch(saveOption) {
			case 1 : result = manager.addAddress(bean, addressBook);
			if(result.equals(Constants.SUCCSESS))
				System.out.println("\t address book saved...!");
			else
				System.out.println(result);
			break;
			case 2 : //save as//////////////////////////////////////////////////////////////////////////////
				result = manager.saveAsAddressBook(addressList, Constants.SAVEASEXTENSION,addressBook);
				if(result.equals(Constants.SUCCSESS))
					System.out.println("AddressBook '"+addressBook+"' is saved...!");
				else
					System.out.println(result);
				break;
			}
			break;

		case 2 : //remove address
			System.out.println("\t Enter ID of the address to be deleted...!!!");
			while(!s1.hasNextInt())
			{
				System.out.println("\t Enter a valid number...!!!");
				s1.next();
			}
			id=s1.nextInt();
			result = manager.isAddressExists(id, addressBook);
			if(!result.equals(Constants.SUCCSESS))
				System.out.println(result);
			else { //if(!().equals(Constants.SUCSESS)){
				allAddresses = manager.listAllAddresses(addressBook);
				addressList = allAddresses.getAddresses();
				for(Person pb : addressList) {
					if(pb.getId() == id)
					{
						addressList.remove(pb);
						break;
					}
				}
				//System.out.println("\t Address got deleted from the address book...!");
				displayAddressBookData(addressList);	
				saveOption = saveMenu();
				switch(saveOption) {
				case 1 : result= manager.removeaddress(id, addressBook);
				if(result.equals(Constants.SUCCSESS))
					System.out.println("\t address book saved...!");
				else
					System.out.println(result);
				break;
				case 2 : //save as//////////////////////////////////////////////////////////////////////////////
					result = manager.saveAsAddressBook(addressList, Constants.SAVEASEXTENSION,addressBook);
					if(result.equals(Constants.SUCCSESS))
						System.out.println("AddressBook '"+addressBook+"' is saved...!");
					else
						System.out.println(result);
					break;
				}
			}
			break;

		case 3: //edit address
			System.out.println("\t Enter ID of the address to be edited...!!!");
			while(!s1.hasNextInt())
			{
				System.out.println("\t Enter a valid number...!!!");
				s1.next();
			}
			id=s1.nextInt();
			result = manager.isAddressExists(id, addressBook);
			if(!result.equals(Constants.SUCCSESS))
				System.out.println(result);
			else {
				//ask the user which all fields he wants to update
				result =addressUpdateMenu(id, addressBook, manager);
				if(result.equals(Constants.SUCCSESS))
					System.out.println("Address with id '"+id+"' edited  and saved successfully...!");
				else
					System.out.println(result);
			}
			break;

		case 4 : //list all addresses of addresss book by last name
			allAddresses = manager.listAllAddresses(addressBook);
			addressList = null;
			if(allAddresses != null) {
				PersonAddressComparatorByLastName<Object> addressCompartor = new PersonAddressComparatorByLastName<>();
				addressList = new TreeSet<Person>(addressCompartor);/////////////////change sort by last name
				addressList.addAll(allAddresses.getAddresses());
			}
			displayAddressBookData(addressList);
			break;

		case 5 : //close = > go back to main menu
			addrMenu = false;
			break;
		}
		return addrMenu;
	}

	/**
	 * performing the address update
	 * @param id of the address
	 * @param addressBook name of the address book
	 * @return "SUCCES" if edited else some error message
	 */
	public static String addressUpdateMenu(int id, String addressBook, AddressManager manager) {
		System.out.println("\t What do you want to update??...!!!");
		int updateChoice;
		String newcity;
		String newState;
		int newZip;
		long newPhoneNumber;
		Person bean = new Person();
		bean.setId(id);
		String ch;
		do
		{
			System.out.println("");
			System.out.println("Press 1 to Update City!");
			System.out.println("Press 2 to Update State!");
			System.out.println("Press 3 to Zip!");
			System.out.println("Press 4 to Phone Number!");
			System.out.println("\n\tEnter choice !!!");

			//take the user choice
			while(!Utility.sc.hasNextInt())
			{
				System.out.println("\t Enter Number from 1 to 4 only...!!!");
				Utility.sc.next();
			}
			updateChoice = Utility.sc.nextInt();
			String input = null;
			//update the required field
			switch(updateChoice)
			{

			case 1 : //Update City
				System.out.println("\t Enter New City Name...!!!");
				while(true)
				{
					newcity = Utility.sc.next();
					if(!Utility.validateStringForAlphanumericOflength20(newcity))
						System.out.println("Last Name should be Alphanumeric of Length 3-20 And Start with a Letter \n Enter again...");
					else
						break;
				}
				bean.setCity(newcity);
				break;

			case 2 : //Update State
				System.out.println("\t Enter New State Name...!!!");
				while(true)
				{
					newState = Utility.sc.next();
					if(!Utility.validateStringForAlphanumericOflength20(newState))
						System.out.println("Last Name should be Alphanumeric of Length 3-20 And Start with a Letter \n Enter again...");
					else
						break;
				}
				bean.setState(newState);
				break;

			case 3 : //Update zip
				//System.out.println("*********** Enter New zip code...!!!*******");
				input = null;
				do {
					System.out.println(" Enter 6-digits zip code...!!! ");
					input= Utility.sc.next();
				}while(!Utility.validateZipCode(input));
				newZip = Integer.parseInt(input);
				bean.setZip(newZip);
				break;

			case 4: //update phone number
				//System.out.println("*********** Enter New Phone Number...!!!*******");
				input = null;
				do {
					System.out.println(" Enter 10-digits Mobile Number...!!! ");
					input= Utility.sc.next();
				}while(!Utility.validateMobileNumber(input));
				newPhoneNumber = Long.parseLong(input);
				bean.setPhoneNumber(newPhoneNumber);
				break;
			}

			System.out.println("\t Want to Update Any Other Fields?? (Y/N)..!!!");
			while(!((ch=Utility.sc.next()).trim().equalsIgnoreCase("Y") || (ch).trim().equalsIgnoreCase("N")))
			{
				System.out.println("Enter Only Either 'Y' or 'N'......!!");
			}
		}while(ch.trim().equalsIgnoreCase("Y"));

		AddressList allAddresses = manager.listAllAddresses(addressBook);
		Set<Person> addressList = allAddresses.getAddresses();
		Person oldBean = null;
		for(Person pb : addressList) {
			if(pb.getId() == id) {
				oldBean = pb;
				addressList.remove(pb);
				break;
			}
		}
		if(bean.getCity() != null)
			oldBean.setCity(bean.getCity());
		if(bean.getState() != null)
			oldBean.setState(bean.getState());
		if(bean.getZip() != 0)
			oldBean.setZip(bean.getZip());
		if(bean.getPhoneNumber() != 0)
			oldBean.setPhoneNumber(bean.getPhoneNumber());
		addressList.add(oldBean);
		//System.out.println("\t Address got updated...!");
		displayAddressBookData(addressList);
		int saveOption = saveMenu();
		String result =null;
		switch(saveOption) {
		case 1 : result= manager.updateAddress(bean, addressBook);
		break;

		case 2 : //save as//////////////////////////////////////////////////////////////////////////////
			result = manager.saveAsAddressBook(addressList, Constants.SAVEASEXTENSION,addressBook);
			if(result.equals(Constants.SUCCSESS))
				System.out.println("AddressBook '"+addressBook+"' is saved...!");
			else
				System.out.println(result);
			break;
		}
		return result;
	}

	public static void displayAddressBookData(Set<Person> addressLists) {
		if(addressLists == null)
			System.out.println("No addresses...!");
		else {//display all the addresses of the address book 
			System.out.println("************************** Addresses are :*******************************");
			System.out.println("\tId \tFirstName \tLastName \tCity \tState \tZip \tPhone Number");
			System.out.println("---------------------------------------------------------------------------------------------");
			for(Person pb : addressLists) {
				System.out.print("\t"+pb.getId());
				System.out.print(" \t"+pb.getFirstName());
				System.out.print(" \t"+pb.getLastName());
				System.out.print(" \t"+pb.getCity());
				System.out.print(" \t"+pb.getState());
				System.out.print(" \t"+pb.getZip());
				System.out.print(" \t"+pb.getPhoneNumber());
				System.out.println();
			}
			System.out.println();
		}
	}

	public static int saveMenu() {

		System.out.println("Press 1 to Save!");
		System.out.println("Press 2 Save As!");
		System.out.println("\n\tEnter choice !!!");

		int saveOption;
		while(!Utility.sc.hasNextInt())
		{
			System.out.println("\n\t Enter Enter number from 1 to 2 Only...!!! ");
			Utility.sc.next();
		}
		saveOption=Utility.sc.nextInt();
		return saveOption;
	}
}

