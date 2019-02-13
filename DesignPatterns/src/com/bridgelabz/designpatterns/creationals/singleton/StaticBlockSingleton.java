package com.bridgelabz.designpatterns.creationals.singleton;

public class StaticBlockSingleton {
	 private static StaticBlockSingleton instance;
	    
	    private StaticBlockSingleton(){}
	    
	    //static block initialization for exception handling
	    static{
	        try{
	            instance = new StaticBlockSingleton();
	            System.out.println("instance got created after the class loading");
	        }catch(Exception e){
	            throw new RuntimeException("Exception occured in creating singleton instance");
	        }
	    }
	    
	    public static StaticBlockSingleton getInstance(){
	        return instance;
	    }
	    
	    public static void main(String[] args) {
	    	// not even having a single statement in the main
	    	//that is client application is not using the singleton object
	    }
}
