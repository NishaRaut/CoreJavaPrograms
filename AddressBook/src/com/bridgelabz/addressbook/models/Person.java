package com.bridgelabz.addressbook.models;

@SuppressWarnings("rawtypes")
public class Person implements Comparable{
	private int id;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private int zip;
	private long phoneNumber;
	
	@Override
	public String toString() {
		return "{\"id\" :"+ id + ", \"firstName\":" + firstName + ", \"lastName\" :" + lastName + ", \"city\":" + city
				+ ", \"state\":" + state + ", \"zip\" :" + zip + ", \"phoneNumber\" :" + phoneNumber + "}";
	}
	public Person() {
	}
	public void setId(int id) {
		 this.id = id;
	}
	public int getId() {
		return this.id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Person)
		{
			Person other = (Person)obj;
			return this.id - other.getId();
		}
		else
			throw new IllegalArgumentException("non-Person object can't compare");
	}	
}
