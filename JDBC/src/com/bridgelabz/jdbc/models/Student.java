package com.bridgelabz.jdbc.models;

public class Student {
	private int id;
	private String name;
	private int age;
	private String major;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "[id = "+id +" name = "+name + " age = "+age + " major = "+major+"]";
	}
}
