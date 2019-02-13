package com.bridgelabz.javaprograms.core.oops.stock;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StockAccount implements Account {
	private String name;
	private double balance;
	private List<CompanyShare> companyShares;

	@Override
	public double valueOf() {
		return this.balance;
	}

	@Override
	public void buy(double amount, String name) {
		this.balance -= amount;
	}

	@Override
	public void sell(double amount, String name) {
		this.balance += amount;
	}

	@Override
	public void save(String filename) {
		String path = "resource/stock/"+name+".json";
		File file = new File(path);
		 try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			 ObjectMapper mapper = new ObjectMapper();
			 mapper.writeValue(file, this);
		 } catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printReport() {
        System.out.println(this.name +" Stock Account Details are :");
        System.out.println("------------------------------------");
        System.out.println("name = "+ this.name);
        System.out.println("balance = "+ this.balance);
        System.out.println("Shares List : ");
        System.out.println("Name \t Shares \t TransactionDate");
        System.out.println("-----------------------------------------");
        for(CompanyShare cs : this.companyShares) {
        	System.out.println(cs.getName() +"\t" + cs.getNumberOfShares() + "\t" + cs.getTransactionDate());
        }
        System.out.println();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<CompanyShare> getCompanyShares() {
		return companyShares;
	}

	public void setCompanyShares(List<CompanyShare> companyShares) {
		this.companyShares = companyShares;
	}
}
