package com.bridgelabz.designpatterns.structural.adapter;

public class TestSocketAdapter {

	public static void main(String[] args) {
		testClassAdapter();
		System.out.println();
		testObjectAdapter();
	}
		
  public static void testClassAdapter() {
	  SocketAdapter adapter = new SocketClassAdapterImpl();
	  Volt v3 = adapter.get3Volt();
		Volt v12 = adapter.get12Volt();
		Volt v120 = adapter.get120Volt();
		System.out.println("v3 volts using Class Adapter="+v3.getVolts());
		System.out.println("v12 volts using Class Adapter="+v12.getVolts());
		System.out.println("v120 volts using Class Adapter="+v120.getVolts());
  }
  
  public static void testObjectAdapter() {
	  SocketAdapter adapter = new SocketObjectAdapterImpl();
	  Volt v3 = adapter.get3Volt();
		Volt v12 = adapter.get12Volt();
		Volt v120 = adapter.get120Volt();
		System.out.println("v3 volts using Object Adapter="+v3.getVolts());
		System.out.println("v12 volts using Object Adapter="+v12.getVolts());
		System.out.println("v120 volts using Object Adapter="+v120.getVolts());
  }
}
