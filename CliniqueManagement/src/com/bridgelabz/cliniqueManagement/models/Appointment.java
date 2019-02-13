package com.bridgelabz.cliniqueManagement.models;

import com.bridgelabz.cliniqueManagement.services.AppData;
import com.bridgelabz.cliniqueManagement.util.Utility;

public class Appointment {
	public static int count;
	
	private int appointmentId;
	private int doctorId;
	private int patientId;
	private Specialization specialization;
	private Availability availability; 
	private String appointmentDate;

	static {
		AppData appdata = Utility.getAppData();
		if(appdata == null)
			count = 0;
		else
			count = appdata.getAppointmentID();
	}
	public Appointment() {
		appointmentId = ++count;
	}
	
	public int getAppointmentId() {
		return appointmentId;
	}
	
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
}
