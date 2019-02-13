package com.bridgelabz.designpatterns.structural.facade;

import java.sql.Connection;

public class HelperFacade {
	public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
		Connection con = null;
		
		switch (dbType) {
		case MYSQL: // performing MySql database stuffs
			con = MySqlHelper.getMySqlDBConnection();
			MySqlHelper mySqlHelper = new MySqlHelper();
			switch (reportType) {
			case HTML:
				mySqlHelper.generateMySqlHTMLReport(tableName, con);
				break;
			case PDF:
				mySqlHelper.generateMySqlPDFReport(tableName, con);
				break;
			}
			break;

		case ORACLE: // performing oracle database stuffs
			con = OracleHelper.getOracleDBConnection();
			OracleHelper oracleHelper = new OracleHelper();
			switch (reportType) {
			case HTML:
				oracleHelper.generateOracleHTMLReport(tableName, con);
				break;
			case PDF:
				oracleHelper.generateOraclePDFReport(tableName, con);
				break;
			}
			break;
		}
	}
}
