package com.bridgelabz.designpatterns.structural.facade;

import java.sql.Connection;

public class TestFacade {

	public static void main(String[] args) {
		String tableName = "Student";

		// generating HTML and PDF reports from MySql database without using Facade
		System.out.println("\ngenerating HTML and PDF reports from MySql database without using Facade\n");
		Connection con = MySqlHelper.getMySqlDBConnection();
		MySqlHelper mySqlHelper = new MySqlHelper();
		mySqlHelper.generateMySqlHTMLReport(tableName, con);
		mySqlHelper.generateMySqlPDFReport(tableName, con);

		// generating HTML and PDF reports from Oracle database without using Facade
		System.out.println("\ngenerating HTML and PDF reports from Oracle database without using Facade\n");
		Connection con1 = OracleHelper.getOracleDBConnection();
		OracleHelper oracleHelper = new OracleHelper();
		oracleHelper.generateOraclePDFReport(tableName, con1);
		oracleHelper.generateOraclePDFReport(tableName, con1);

		// generating MySql HTML and PDF report using Facade
		System.out.println("\ngenerating MySql HTML and PDF report using Facade\n");
		HelperFacade.generateReport(DBTypes.MYSQL, ReportTypes.HTML, tableName);
		HelperFacade.generateReport(DBTypes.MYSQL, ReportTypes.PDF, tableName);

		// generating Oracle HTML and PDF report using Facade
		System.out.println("\ngenerating Oracle HTML and PDF report using Facade\n");
		HelperFacade.generateReport(DBTypes.ORACLE, ReportTypes.HTML, tableName);
		HelperFacade.generateReport(DBTypes.ORACLE, ReportTypes.PDF, tableName);
	}

}
