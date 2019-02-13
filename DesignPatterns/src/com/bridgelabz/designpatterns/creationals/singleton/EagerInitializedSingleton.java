package com.bridgelabz.designpatterns.creationals.singleton;

import java.util.Scanner;

public class EagerInitializedSingleton {
	 private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
	    
	    //private constructor to avoid client applications to use constructor
	    private EagerInitializedSingleton(){}

	    public static EagerInitializedSingleton getInstance(){
	        return instance;
	    }
	    
	    public void greet(String name) {
	    	System.out.println("Hi good morning.."+ name);
	    }
	    public static void main(String[] args) {
	    	EagerInitializedSingleton instance =  EagerInitializedSingleton.getInstance();
	    	System.out.println("Enter a person name");
	    	Scanner sc = new Scanner(System.in);
	    	String name = sc.next();
	    	instance.greet(name);
	    	sc.close();
	    }
}
