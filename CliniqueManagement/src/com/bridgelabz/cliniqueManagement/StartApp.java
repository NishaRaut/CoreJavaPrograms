package com.bridgelabz.cliniqueManagement;

import java.util.List;

import com.bridgelabz.cliniqueManagement.models.Appointment;
import com.bridgelabz.cliniqueManagement.models.Availability;
import com.bridgelabz.cliniqueManagement.models.Doctor;
import com.bridgelabz.cliniqueManagement.models.Patient;
import com.bridgelabz.cliniqueManagement.models.Specialization;
import com.bridgelabz.cliniqueManagement.services.AppData;
import com.bridgelabz.cliniqueManagement.services.ClinicManager;
import com.bridgelabz.cliniqueManagement.util.Utility;

public class StartApp {

	public static void main(String[] args) {
		ClinicManager manager = new ClinicManager();

		String result = "";
		int choice;
		String doctorName;
		Specialization specialization;
		Availability availability;
		int avail;
		int spl;
		String patientName;
		String mobileNumber;
		int age;
		int pid;
		int did;
		Doctor dr;
		Appointment appointment;
		do {
			System.out.println();
			System.out.println("Enter 1 = > Add Doctor");
			System.out.println("Enter 2 = > Add Petient");
			System.out.println("Enter 3 = > Search Doctor");
			System.out.println("Enter 4 = > Search Patient");
			System.out.println("Enter 5 = > Take Appointment");
			System.out.println("Enter 6 = > Quit");
			System.out.println();

			choice = Utility.getCliniqueMenuChoice();
			switch (choice) {
			case 1: // add a new doctor
				System.out.println("Enter doctor name.");
				doctorName = Utility.getString();
				System.out.println("Select doctor specialization.");
				manager.printSpecializations();
				System.out.println("Enter Specialization id");
				spl = Utility.getPositiveInt();
				specialization = manager.getSpecialization(spl);
				System.out.println("Select doctor availability.");
				manager.printDoctorAvailabilityOptions();
				System.out.println("Enter availability id");
				avail = Utility.getPositiveInt();
				availability = manager.getAvailability(avail);
				result = manager.addDoctor(doctorName, specialization, availability);
				if (result.equals("SUCCESS"))
					System.out.println("A Doctor with name '" + doctorName + "' is added.");
				else
					System.out.println(result);
				break;

			case 2: // add a new patient
				System.out.println("Enter patient name.");
				patientName = Utility.getString();
				System.out.println("Enter Mobile Number.");
				boolean flag = false;
				do {
					mobileNumber = Utility.getString();
					flag = Utility.validateMobileNumber(mobileNumber);
 					if (!flag)
						System.out.println("Enter a valid 10 digit mobile number");
				} while (!flag);
				System.out.println("Enter age.");
				age = Utility.getPositiveInt();
				result = manager.addPatient(patientName, mobileNumber, age);
				if (result.equals("SUCCESS"))
					System.out.println("A patient with name '" + patientName + "' is added.");
				else
					System.out.println(result);
				break;

			case 3: // search doctor
				searchDoctor(manager);
				break;

			case 4: // search patient
				searchPatient(manager);
				break;

			case 5: // take appointment with a doctor
				System.out.println("Enter patient Id");
				pid = Utility.getPositiveInt();
				if (manager.serachPatientByID(pid) == null) {
					System.out.println("Patient with id '" + pid + "' doesn't exist...!!");
					break;
				}
				// select doctor
				System.out.println("Search Doctor");
				searchDoctor(manager);
				System.out.println("Enter doctor id");
				do {
					did = Utility.getPositiveInt();
					dr = manager.serachDoctorById(did);
					if (dr == null)
						System.out.println("Enter a valid doctor id...!!");
				} while (dr == null);
				/// take appointment
				appointment = manager.fixAppointment(pid, did);
				if (appointment != null)
					System.out.println("Appointment fixed on " + appointment.getAppointmentDate() + " in the "
							+ appointment.getAvailability() + " time.");
				else
					System.out.println("Appointment not fixed...!!");
				break;
			}
		} while (choice != 6);
		AppData appData = new AppData();
		appData.setAppointmentID(Appointment.count);
		appData.setDoctorID(Doctor.count);
		appData.setPatientID(Patient.count);
		Utility.saveAppData(appData);
		System.out.println("***********Application closed ****************************");
	}// end of main function

	/**
	 * search doctor
	 * 
	 * @param manager CliniqueManager instance
	 */
	public static void searchDoctor(ClinicManager manager) {
		int choice;
		int id;
		String name;
		Specialization specialization;
		Availability availability;
		Doctor dr = null;
		List<Doctor> doctors = null;
		do {
			System.out.println();
			System.out.println("Enter 1 = > Search By Id");
			System.out.println("Enter 2 = > Search By Name");
			System.out.println("Enter 3 = > Search By Specialization");
			System.out.println("Enter 4 = > Search By Availability");
			System.out.println("Enter 5 = > Stop searching doctor");
			System.out.println();

			choice = Utility.getDoctorSearchMenuChoice();
			switch (choice) {
			case 1: // *************************************** search by Id
				// ********************************//
				System.out.println("Enter doctor's id.");
				id = Utility.getPositiveInt();
				dr = manager.serachDoctorById(id);
				if (dr != null) {
					System.out.println("ID \t Name \t Specialization \tAvailability");
					System.out.println("-----------------------------------------------------------------------");
					System.out.println(dr.getId() + "\t " + dr.getName() + " \t" + dr.getSpecialization() + "\t"
							+ dr.getAvailability());
					System.out.println();
				} else
					System.out.println("There is no doctor with id '" + id + "...!!'\n");
				break;

			case 2: // **************** search by name **************************//
				System.out.println("Enter Doctor's Name.");
				name = Utility.getString();
				doctors = manager.serachDoctorByName(name);
				if (doctors != null) {
					System.out.println("ID \t Name \t Specialization \tAvailability");
					for (Doctor doc : doctors) {
						System.out.println(doc.getId() + "\t " + doc.getName() + " \t" + doc.getSpecialization() + "\t"
								+ doc.getAvailability());
					}
					System.out.println();
				} else
					System.out.println("There is no doctor with name '" + name + "...!!'\n");
				break;

			case 3: // *************** search by Specialization ******************************//
				System.out.println("Select doctor specialization.");
				manager.printSpecializations();
				System.out.println("Enter Specialization id");
				id = Utility.getPositiveInt();
				specialization = manager.getSpecialization(id);
				doctors = manager.serachDoctorBySpecialization(specialization);
				if (doctors != null) {
					System.out.println("ID \t Name \t Specialization \tAvailability");
					for (Doctor doc : doctors) {
						System.out.println(doc.getId() + "\t " + doc.getName() + " \t" + doc.getSpecialization() + "\t"
								+ doc.getAvailability());
					}
					System.out.println();
				} else
					System.out.println("There is no doctor with specialization '" + specialization + "...!!'\n");
				break;

			case 4: // ****************************** Search By Availability
				// ************************************//
				System.out.println("Select doctor availability.");
				manager.printDoctorAvailabilityOptions();
				System.out.println("Enter availability id");
				id = Utility.getPositiveInt();
				availability = manager.getAvailability(id);
				doctors = manager.serachDoctorByAvailability(availability);
				if (doctors != null) {
					System.out.println("ID \t Name \t Specialization \tAvailability");
					for (Doctor doc : doctors) {
						System.out.println(doc.getId() + "\t " + doc.getName() + " \t" + doc.getSpecialization() + "\t"
								+ doc.getAvailability());
					}
					System.out.println();
				} else
					System.out.println("There is no doctor with availability '" + availability + "...!!'\n");
				break;
			}

		} while (choice != 5);
	}// end of doctor searching

	/**
	 * searching patient
	 * 
	 * @param manager CliniqueManager instance
	 */
	public static void searchPatient(ClinicManager manager) {
		int choice;
		int id;
		String name;
		String mobileNumber;
		Patient pt = null;
		List<Patient> patients = null;
		do {
			System.out.println();
			System.out.println("Enter 1 = > Search By Id");
			System.out.println("Enter 2 = > Search By Name");
			System.out.println("Enter 3 = > Search By MobileNumber");
			System.out.println("Enter 4 = > Stop searching patient");
			System.out.println();

			choice = Utility.getPatientSearchMenuChoice();
			switch (choice) {
			case 1: // *************************************** search by Id
				// ********************************//
				System.out.println("Enter patient's id.");
				id = Utility.getPositiveInt();
				pt = manager.serachPatientByID(id);
				if (pt != null) {
					System.out.println("ID \t Name \t Age \t MobileNumber");
					System.out.println("-----------------------------------------------------------------------");
					System.out.println(
							pt.getId() + "\t " + pt.getName() + " \t" + pt.getAge() + "\t" + pt.getMobileNumber());
					System.out.println();
				} else
					System.out.println("There is no patient with id '" + id + "...!!'\n");
				break;

			case 2: // ********************** search by name
				// **********************************************//
				System.out.println("Enter Patient's Name.");
				name = Utility.getString();
				patients = manager.serachPatientByName(name);
				if (patients != null) {
					System.out.println("ID \t Name \t Age \t MobileNumber");
					System.out.println("-----------------------------------------------------------------------");
					for (Patient p : patients) {
						System.out.println(
								p.getId() + "\t " + p.getName() + " \t" + p.getAge() + "\t" + p.getMobileNumber());
					}
					System.out.println();
				} else
					System.out.println("There is no Patient with name '" + name + "...!!'\n");
				break;

			case 3: // ***************************** search by MobileNumber
				// ************************************//
				System.out.println("Enter Mobile Number.");
				boolean flag = false;
				do {
					mobileNumber = Utility.getString();
					flag = Utility.validateMobileNumber(mobileNumber);
					if (!flag)
						System.out.println("Enter a valid 10 digit mobile number");
				} while (!flag);
				patients = manager.serachPatientByMobileNumber(mobileNumber);
				if (patients != null) {
					System.out.println("ID \t Name \t Age \t MobileNumber");
					System.out.println("-----------------------------------------------------------------------");
					for (Patient p : patients) {
						System.out.println(
								p.getId() + "\t " + p.getName() + " \t" + p.getAge() + "\t" + p.getMobileNumber());
					}
					System.out.println();
				} else
					System.out.println("There is no Patient with MobileNumber '" + mobileNumber + "...!!'\n");
				break;
			}

		} while (choice != 4);
	}// end of searching patient
}





//System.out.println("Enter 6 = > Print Doctor-Patient Report");
//System.out.println("Enter 6 = > Popular Specialization");
//System.out.println("Enter 7 = > Popular Doctor");
