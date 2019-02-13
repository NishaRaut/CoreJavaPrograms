package com.bridgelabz.designpatterns.structural.facade;

import java.sql.Connection;

public class OracleHelper {
	public static Connection getOracleDBConnection(){
		System.out.println("oracle database connection.....");
		return null;
	}
	
	public void generateOraclePDFReport(String tableName, Connection con){
		System.out.println("Oracle PDF report.....");
	}
	
	public void generateOracleHTMLReport(String tableName, Connection con){
		System.out.println("Oracle HTML report.....");
}
}
