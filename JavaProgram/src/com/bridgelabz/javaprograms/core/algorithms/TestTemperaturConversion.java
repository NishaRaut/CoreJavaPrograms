package com.bridgelabz.javaprograms.core.algorithms;

import java.text.DecimalFormat;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Conversion of temperature from Fahrenheit to Celsius and vice-versa
 *           
 * I/P    :  temperature, type : 1 to fahrenheit, 2 to celsius
 * O/P    :  temperature
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 15-09-2019
 *****************************************************************************************/
public class TestTemperaturConversion {
	public static void main(String[] args) {
		int type;
		double temperature;
		do {
			System.out.println("Enter your temperature type");
			System.out.println("1 for Fahrenheit");
			System.out.println("2 for Celsius");
			type = Utility.getPositiveInt();
		}while(type > 2 || type < 1);
		System.out.println("Enter the temperature...!");
		temperature = Utility.scanner.nextDouble();
		temperature = Utility.temperaturConversion(temperature, type);
		DecimalFormat df = new DecimalFormat(".##");
		if(type == 1)
			System.out.println("Temperature in Celsius = "+df.format(temperature));
		else
			System.out.println("Temperature in Fahrenheit = "+df.format(temperature));
	}

}
