package com.bridgelabz.cliniqueManagement.services;

import java.util.List;

import com.bridgelabz.cliniqueManagement.models.Patient;

public class PatientList {
	List<Patient> patients;

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
