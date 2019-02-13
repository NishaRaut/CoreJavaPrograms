package com.bridgelabz.cliniqueManagement.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.bridgelabz.cliniqueManagement.models.Appointment;
import com.bridgelabz.cliniqueManagement.models.Availability;
import com.bridgelabz.cliniqueManagement.models.Clinic;
import com.bridgelabz.cliniqueManagement.models.Doctor;
import com.bridgelabz.cliniqueManagement.models.Patient;
import com.bridgelabz.cliniqueManagement.models.Specialization;
import com.bridgelabz.cliniqueManagement.util.FilePaths;
import com.bridgelabz.cliniqueManagement.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClinicManager implements Clinic {

	@Override
	public String addDoctor(String name, Specialization specialization, Availability availability) {
		String result = "SUCCESS";
		Doctor dr = new Doctor();
		dr.setName(name);
		dr.setSpecialization(specialization);
		dr.setAvailability(availability);

		// fetch all the existing doctors from the file
		List<Doctor> doctors = getAllExistingDoctors();
		if (doctors == null)
			doctors = new ArrayList<>();
		doctors.add(dr);
		//write back to the file
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(FilePaths.DOCTORFILEPATH);
		DoctorList data = new DoctorList();
		data.setDoctors(doctors);
		try {
			mapper.writeValue(file, data);
		} catch (IOException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	@Override
	public Doctor serachDoctorById(int id) {
		List<Doctor> allDoctors = getAllExistingDoctors();
		if(allDoctors == null)
			return null;
		Doctor dr = null;
		if(allDoctors.stream().filter(d -> d.getId() == id).findFirst().isPresent())
			dr = allDoctors.stream().filter(d -> d.getId() == id).findFirst().get();
		return dr;
	}

	@Override//////////////////////
	public List<Doctor> serachDoctorByName(String name) {
		List<Doctor> allDoctors = getAllExistingDoctors();
		if(allDoctors == null)
			return null;
		List<Doctor> doctorsWithSameName = allDoctors.stream()
			              .filter(d -> d.getName().equalsIgnoreCase(name))
			              .collect(Collectors.toList());
		if(doctorsWithSameName.isEmpty())
			return null;
		return doctorsWithSameName;
	}

	@Override
	public List<Doctor> serachDoctorBySpecialization(Specialization specialization) {
		List<Doctor> allDoctors = getAllExistingDoctors();
		if(allDoctors == null)
			return null;
		List<Doctor> doctorsWithSameSpecialization = allDoctors.stream()
			              .filter(d->d.getSpecialization() == specialization)
			              .collect(Collectors.toList());
		if(doctorsWithSameSpecialization.isEmpty())
			return null;
		return doctorsWithSameSpecialization;
	}

	@Override
	public List<Doctor> serachDoctorByAvailability(Availability availability) {
		List<Doctor> allDoctors = getAllExistingDoctors();
		if(allDoctors == null)
			return null;
		List<Doctor> doctorsWithSameAvailability = allDoctors.stream()
			              .filter(d -> d.getAvailability() == availability)
			              .collect(Collectors.toList());
		if(doctorsWithSameAvailability.isEmpty())
			return null;
		return doctorsWithSameAvailability;
	}

	@Override
	public String addPatient(String name, String mobileNumber, int age) {
		String result = "SUCCESS";
		Patient pt = new Patient();
		pt.setName(name);
		pt.setMobileNumber(mobileNumber);
		pt.setAge(age);

		// fetch all the existing patients from the file
		List<Patient> patients = getAllExistingPatients();
		if (patients == null)
			patients = new ArrayList<>();
		patients.add(pt);
		//write back to the file
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(FilePaths.PATIENTFILEPATH);
		PatientList data = new PatientList();
		data.setPatients(patients);
		try {
			mapper.writeValue(file, data);
		} catch (IOException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	@Override
	public Patient serachPatientByID(int id) {
		List<Patient> allPatients = getAllExistingPatients();
		if(allPatients == null)
			return null;
		Patient pt = null;
		if(allPatients.stream().filter(p->p.getId() == id).findFirst().isPresent())
			pt = allPatients.stream().filter(p->p.getId() == id).findFirst().get();
		return pt;
	}

	@Override
	public List<Patient> serachPatientByName(String name) {
		List<Patient> allPatients = getAllExistingPatients();
		if(allPatients == null)
			return null;
		List<Patient> patientsWithSameName = allPatients.stream()
			              .filter(p -> p.getName().equalsIgnoreCase(name))
			              .collect(Collectors.toList());
		if(patientsWithSameName.isEmpty())
			return null;
		else
			return patientsWithSameName;
	}

	@Override
	public List<Patient> serachPatientByMobileNumber(String mobileNumber) {
		List<Patient> allPatients = getAllExistingPatients();
		if(allPatients == null)
			return null;
		List<Patient> patientsWithMobileNumber = allPatients.stream()
			              .filter(p->p.getMobileNumber().equals(mobileNumber))
			              .collect(Collectors.toList());
		if(patientsWithMobileNumber.isEmpty())
			return null;
		else
			return patientsWithMobileNumber;
	}

	public void printDoctorAvailabilityOptions() {
		int count = 0;
		for (Availability av : Availability.values()) {
			System.out.println(++count + " = > " + av);
		}
	}

	public Availability getAvailability(int number) {
		Availability result = null;
		switch (number) {
		case 1:
			result = Availability.AM;
			break;

		case 2:
			result = Availability.PM;
			break;

		case 3:
			result = Availability.BOTH;
			break;
		}
		return result;
	}

	public void printSpecializations() {
		int count = 0;
		for (Specialization spl : Specialization.values()) {
			System.out.println(++count + " = > " + spl);
		}
	}

	public Specialization getSpecialization(int number) {
		Specialization result = null;
		;
		switch (number) {
		case 1:
			result = Specialization.Cardiology;
			break;

		case 2:
			result = Specialization.Medicine;
			break;

		case 3:
			result = Specialization.Neurosurgery;
			break;

		case 4:
			result = Specialization.Orthopedics;
			break;

		case 5:
			result = Specialization.Pediatrics;
			break;

		default:
			System.out.println("Invalid choice...!");
		}
		return result;
	}

	@Override
	public Appointment fixAppointment(int patientId, int doctorId) {
		// create a new Appointment instance by getting the doctor's info
		List<Doctor> doctors = getAllExistingDoctors();
		Doctor dr = doctors.stream().filter(d -> d.getId() == doctorId).findFirst().get();
		Appointment appt = new Appointment();
		appt.setDoctorId(doctorId);
		appt.setPatientId(patientId);
		appt.setSpecialization(dr.getSpecialization());
		appt.setAvailability(dr.getAvailability());

		// Fetch all the appointments from the file
		List<Appointment> appointments = getAllExistingAppointments();
		if (appointments == null) {// first entry into the appointments
			appointments = new ArrayList<Appointment>();
			appt.setAppointmentDate(Utility.getCurrentDate());
		} else {
			List<Appointment> reqDrsAppointments = appointments.stream()
					.filter(a -> a.getDoctorId() == doctorId).collect(Collectors.toList());
			reqDrsAppointments = reqDrsAppointments.stream()
					.filter(a -> a.getAppointmentDate() == Utility.getCurrentDate()).collect(Collectors.toList());
			//
			if (reqDrsAppointments.size() == 5)// doctor's appointment list for the session is full
				appt.setAppointmentDate(Utility.getNextDate(new Date())); // give tomorrow's appointment
			else
				appt.setAppointmentDate(Utility.getCurrentDate());
		}
		appointments.add(appt);
		// write back to the appointments file
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(FilePaths.APPOINTMENTFILEPATH);
		AppointmentList aplist = new AppointmentList();
		aplist.setAppointments(appointments);
		try {
			mapper.writeValue(file, aplist);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return appt;
	}

	public List<Appointment> getAllExistingAppointments() {
		List<Appointment> appointments = null;
		AppointmentList jsonData = null;
		File file = new File(FilePaths.APPOINTMENTFILEPATH);
		if (file.length() == 0) // empty file
			return null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonData = mapper.readValue(file, AppointmentList.class);
			appointments = jsonData.getAppointments();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return appointments;
	}

	public List<Doctor> getAllExistingDoctors() {
		List<Doctor> doctors = null;
		DoctorList jsonData = null;
		File file = new File(FilePaths.DOCTORFILEPATH);
		if (file.length() == 0) // empty file
			return null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonData = mapper.readValue(file, DoctorList.class);
			doctors = jsonData.getDoctors();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doctors;
	}

	public List<Patient> getAllExistingPatients() {
		List<Patient> patients = null;
		PatientList jsonData = null;
		File file = new File(FilePaths.PATIENTFILEPATH);
		if (file.length() == 0) // empty file
			return null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonData = mapper.readValue(file, PatientList.class);
			patients = jsonData.getPatients();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return patients;
	}
}
