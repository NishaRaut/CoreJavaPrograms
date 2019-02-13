package com.bridgelabz.designpatterns.creationals.prototype;

public class TestPrototypePattern {

	public static void main(String[] args) {
		Employees emps = new Employees();
		emps.loadData();
		
		//clone a new employees object using emps instance
       try {
		Employees newEmps1 = (Employees)emps.clone();
		Employees newEmps2 = (Employees)emps.clone();
		//manipulate newEmps1 and newEmps2
        newEmps1.getEmpList().add("John");
        newEmps2.getEmpList().remove("Pankaj");
        //display all the 3 objects
        System.out.println("emps : "+emps.getEmpList());
        System.out.println("newEmps1 :  "+ newEmps1.getEmpList());
        System.out.println("newEmps2 :  "+ newEmps2.getEmpList());
	} catch (CloneNotSupportedException e) {
		e.printStackTrace();
	}
	}

}
