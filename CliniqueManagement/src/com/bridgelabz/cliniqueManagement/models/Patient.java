package com.bridgelabz.cliniqueManagement.models;

import com.bridgelabz.cliniqueManagement.services.AppData;
import com.bridgelabz.cliniqueManagement.util.Utility;

public class Patient {
	
	private int id;
	private String name;
	private String mobileNumber;
	private int age;
	public static int count;
	
	static {
		AppData appdata = Utility.getAppData();
		if(appdata == null)
			count = 0;
		else
			count = appdata.getPatientID();
	}
	public Patient() {
		this.id = ++count;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
