package com.bridgelabz.addressbook.models;

import java.util.Set;

import com.bridgelabz.addressbook.models.Person;

public class AddressList {
  private Set<Person> addresses;
  
  public void setAddresses(Set<Person> persons) {
	  this.addresses = persons;
  }
  public  Set<Person> getAddresses() {
	  return this.addresses;
  }
}
