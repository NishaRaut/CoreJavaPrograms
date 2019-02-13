package com.bridgelabz.cliniqueManagement.services;

import java.util.List;

import com.bridgelabz.cliniqueManagement.models.Appointment;

public class AppointmentList {
	private List<Appointment> appointments;

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
}
