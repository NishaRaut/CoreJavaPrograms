package com.bridgelabz.cliniqueManagement.models;

import com.bridgelabz.cliniqueManagement.services.AppData;
import com.bridgelabz.cliniqueManagement.util.Utility;

public class Doctor {
	private int id;
	private String name;
	private Specialization specialization;
	private Availability availability;
	public static int count;
	
	static {
		AppData appdata = Utility.getAppData();
		if(appdata == null)
			count = 0;
		else
			count = appdata.getDoctorID();
	}
	public Doctor() {
		this.id = ++count;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
}
