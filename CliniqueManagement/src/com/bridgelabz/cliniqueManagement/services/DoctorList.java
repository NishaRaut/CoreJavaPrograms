package com.bridgelabz.cliniqueManagement.services;

import java.util.List;

import com.bridgelabz.cliniqueManagement.models.Doctor;

public class DoctorList {
	private List<Doctor> doctors;

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
}
