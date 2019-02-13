package com.bridgelabz.javaprograms.core.oops.stock;

public interface Account {
	
	double valueOf();

	void buy(double amount, String name);

	void sell(double amount, String name);

	void save(String filename);

	void printReport();
}
