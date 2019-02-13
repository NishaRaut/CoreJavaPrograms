package com.bridgelabz.javaprograms.core.functional;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 * Purpose: gives total no. of random numbers genrated to produce N distinct coupon numbers
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.o
 * @since 09-01-2019
 * 
******************************************************************************/
public class CouponNumbers {
	/*
	 * main function to test CouponNumbers class
	 */
	public static void main(String[] args) {
       int coupons = 0;
       System.out.println("Enter no. of distinct coupon needed...!");
       coupons = Utility.getPositiveInt();
       int totalRandoms = Utility.distinctCoupons(coupons);
       System.out.println("totalRandoms = "+totalRandoms);
	}

}
