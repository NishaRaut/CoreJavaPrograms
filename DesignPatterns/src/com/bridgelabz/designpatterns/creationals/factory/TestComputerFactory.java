package com.bridgelabz.designpatterns.creationals.factory;

public class TestComputerFactory {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
		Computer laptop = ComputerFactory.getComputer("laptop","4 GB","600 GB","2.5 GHz");
		Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
		System.out.println("Factory PC Config::"+pc);
		System.out.println("Factory Laptop Config::"+laptop);
		System.out.println("Factory Server Config::"+server);
	}
}
