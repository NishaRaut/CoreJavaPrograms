package com.bridgelabz.jdbc.controllers;

import java.util.List;

import com.bridgelabz.jdbc.models.Student;
import com.bridgelabz.jdbc.services.DbCRUDByStatement;
import com.bridgelabz.jdbc.util.Utility;

public class TestJDBCStatement {

	public static void main(String[] args) {
		String name = null;
		int age = 0;
		String major = null;
		int id;
		DbCRUDByStatement statementService = new DbCRUDByStatement();
		Student stud = null;
		int numOfRowsAffected = 0;
		int choice;
		do {
			System.out.println();
			System.out.println("Enter 1 : Insert Value");
			System.out.println("Enter 2 : Update Value");
			System.out.println("Enter 3 : Delete Value");
			System.out.println("Enter 4 : Retrieve Value");
			System.out.println("Enter 5 : Exit/n");

			choice = Utility.getPositiveInt(5);

			switch (choice) {
			case 1: // *********** Insert Value **************************** /
				System.out.println("Enter name");
				name = Utility.getString();
				System.out.println("Enter age");
				age = Utility.getPositiveInt(22);
				System.out.println("Enter major");
				major = Utility.getString();
				stud = statementService.insert(name, age, major);
				if(stud != null) {
					System.out.println("Student record got added to the database as :");
				    System.out.println(stud);
				}
				else
					System.out.println("Student not added to the database...!");
				break;

			case 2 : // *********** Update Value **************************** /
				System.out.println("Enter Id of the student");
				id = Utility.getPositiveInt(100);
                if(statementService.isIdExists(id)) {
                	stud = null;
                	stud = updateMenu();
                	numOfRowsAffected = statementService.update(id, stud.getName(), stud.getAge(), stud.getMajor());
                    System.out.println(numOfRowsAffected + "row(s) got updated.");
                }
                else
                	System.out.println("There is no record with the Id = "+id);
                break;
                
			case 3 : // *********** Delete Value **************************** /
				System.out.println("Enter Id of the student");
				id = Utility.getPositiveInt(100);
                if(statementService.isIdExists(id)) {
                	numOfRowsAffected = statementService.delete(id);
                	if(numOfRowsAffected > 0)
                		System.out.println(numOfRowsAffected + " rows got deleted");
                	else
                		System.out.println("Error while deleting a record with id "+ id);
                }
                else
                	System.out.println("There is no record with the Id = "+id);
                break;
                
			case 4 : // *********** Retrieve Value **************************** /
				  List<Student> allStudents = statementService.retrieve();
				  if(allStudents == null)
					  System.out.println("There are no students record...!");
				  else {
					  for(Student s : allStudents)
						  System.out.println(s);
				  }
				  break;
			}
		} while (choice != 5);
	}// end of main
    
	/**
	 * menu for updating a student
	 * @return student with updated values
	 */
	public static Student updateMenu() {
		Student student = new Student();
		String name = null;
		String major = null;
		int age = 0;
		int choice;
		do {
			System.out.println("\nSelect fields to update\n");
			System.out.println("Enter 1 : Name");
			System.out.println("Enter 2 : Age");
			System.out.println("Enter 3 : Major");
			System.out.println("Enter 4 : Exit Update Menu");

			choice = Utility.getPositiveInt(4);

			switch (choice) {
			case 1 : //update name
				    System.out.println("Enter new name");
				    name = Utility.getString();
				    student.setName(name);
				    break;
				    
			case 2 : //update age
				   System.out.println("Enter new age");
				   age = Utility.getPositiveInt(22);
				   student.setAge(age);
				   break;
				   
			case 3 : //update major
				System.out.println("Enter new major");
				major = Utility.getString();
				student.setMajor(major);
				break;
			}
		}while(choice != 4);
		return student;
	}
}
