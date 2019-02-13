package com.bridgelabz.jdbc.util;

import java.util.List;

import com.bridgelabz.jdbc.models.Student;

public interface DbCRUDOperation {
  Student insert(String name, int age, String major);
  int update(int id, String newName, int newAge, String newMajor);
  int delete(int id);
  List<Student> retrieve();
}
