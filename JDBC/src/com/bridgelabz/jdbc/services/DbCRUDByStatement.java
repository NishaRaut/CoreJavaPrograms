package com.bridgelabz.jdbc.services;

import java.util.List;

import com.bridgelabz.jdbc.models.Student;
import com.bridgelabz.jdbc.repositories.StatementExecution;
import com.bridgelabz.jdbc.util.DbCRUDOperation;

public class DbCRUDByStatement implements DbCRUDOperation {
	StatementExecution executeSt = new StatementExecution();
	
    /**
     * searches a record with id exists in db table or not  
     * @param id id of the record
     * @return true if exists else false
     */
	public boolean isIdExists(int id) {
		return true;
	}
	
	/**
	 * add a new student object to the Student table in db
	 */
	@Override
	public Student insert(String name, int age, String major) {
		Student stud = new Student();
        stud.setName(name);
        stud.setAge(age);
        stud.setMajor(major);
        return executeSt.insert(stud);
	}

	/**
	 * update a student data by id
	 */
	@Override
	public int update(int id, String newName, int newAge, String newMajor) {
		if(!isIdExists(id))
			return -1;                  // record with id doesn't exists
		Student stud = new Student();
		stud.setId(id);
		if(newName != null)
			stud.setName(newName);
		if(newAge != 0)
			stud.setAge(newAge);
		if(newMajor != null)
			stud.setMajor(newMajor);
		return executeSt.update(stud);
	}

	/**
	 * delete a student by id
	 */
	@Override
	public int delete(int id) {
		if(!isIdExists(id))
			return -1;                  // record with id doesn't exists
		return executeSt.delete(id);
	}

	/**
	 * get all the students records
	 */
	@Override
	public List<Student> retrieve() {
		return executeSt.retrieveAll();
	}
}
