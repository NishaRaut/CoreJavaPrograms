package com.bridgelabz.designpatterns.creationals.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
	private List<String> empsList;

	public Employees() {
		empsList = new ArrayList<String>();
	}

	public Employees(List<String> emps) {
		this.empsList = emps;
	}

	public List<String> getEmpList() {
		return empsList;
	}

	public void loadData() {
		// read all employees from database and put into the list
		empsList.add("Pankaj");
		empsList.add("Raj");
		empsList.add("David");
		empsList.add("Lisa");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<String>();
		for (String s : this.getEmpList())
			temp.add(s);
		return new Employees(temp);
	}

}