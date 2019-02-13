package com.bridgelabz.cliniqueManagement.models;

import java.util.List;

public interface Clinic {
	//-----Doctor functionalities --------------------------------//
   String addDoctor(String name, Specialization specialization,Availability availability);
   Doctor serachDoctorById(int id);
   List<Doctor> serachDoctorByName(String name);
   List<Doctor> serachDoctorBySpecialization(Specialization specialization);
   List<Doctor> serachDoctorByAvailability(Availability availability);
   //-----Patient functionalities --------------------------------//
   String addPatient(String name, String mobileNumber,int age);
   Patient serachPatientByID(int id);
   List<Patient> serachPatientByName(String name);
   List<Patient> serachPatientByMobileNumber(String mobileNumber);
   //-------------- fix appointment --------------------------------//
   Appointment fixAppointment(int patientId, int doctorId);
   
}
