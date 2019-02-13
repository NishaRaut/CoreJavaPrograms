package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/****************************************************************************************
 * Purpose : Computes and prints the wind child by taking the temperature (t) in fahrenheit and 
 *           wind speed (v) in miles per hour.
 *           
 * I/P    : temperature and wind speed
 * O/P    : wind chill
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 11-09-2019
 *****************************************************************************************/
public class WindChill {
	public static void main(String[] args) {
		try {
			double t = Double.parseDouble(args[0]);//temperature
			double v = Double.parseDouble(args[1]);//wind speed

			double windchill = Utility.getWindChill(t, v);
			System.out.printf("wind chill = %.2f",windchill);
		}
		catch(Exception e) {
			System.out.println("\nProvide temp value(1-50) and wind speed value (3-120)...!");
		}
	}

}
