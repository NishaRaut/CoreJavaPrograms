package com.bridgelabz.javaprograms.core.datastructures;

import com.bridgelabz.javaprograms.core.util.Utility;

/******************************************************************************
 *  Purpose: Simulation of a Banking cash counter for depositing and withdrawal of money
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   19-01-2019
 *******************************************************************************/
public class BankingCashCounter {
	double cashBalance;
	Queue<Double> panel;
	//int[] transactionType;
	int panelSize;
	public BankingCashCounter() {
		cashBalance = 10000;//10k initial balance;
		panelSize =10;
		panel = new Queue<Double>(panelSize);//10 is the panel capacity
		//transactionType = new int[panelSize];//1=> deposit, 2=>withdraw
	}

	/**
	 * depositing the money
	 * @param amount the deposit amount
	 */
	public void deposit(Double amount) {
		if(panel.isFull()) {
			System.out.println("\tCash Counter queue panel is full...wait for some time...!");
			return;
		}
		panel.enqueue(amount);
	}

	/**
	 * withdrawing the money
	 * @param amount withdraw amount
	 */
	public void withdraw(Double amount) {
		deposit(-amount);
	}

	/**
	 * performing the transaction 
	 */
	public void process() {
		if(panel.isEmpty())//no customers to process;
			return;
		double transactionAmount = panel.dequeue();
		if(transactionAmount > 0)//deposit
		{
			cashBalance += transactionAmount;
			System.out.printf("\t%.2f gets deposited...!\n",transactionAmount);
		}
		else if(transactionAmount < 0)//withdraw
		{
			transactionAmount = -transactionAmount;//make it positive
			//check for sufficient balance
			if(cashBalance < transactionAmount) {
				System.out.printf("\tThere is no sufficient cash to perform your withdrawal of %.2f...!\n",transactionAmount);
				System.out.printf("\tAvailable balance is : %.2f\n",cashBalance);
			}
			else {
				cashBalance -= transactionAmount;
				System.out.printf("\t%f gets withdrawn...!\n",transactionAmount);
			}	 
		}
		else {
			System.out.println("\tInvalid transaction amount...Can't process it...! ");
		}
	}

	/**
	 * main function to test the BankingCashCounter class
	 * @param args
	 */
	public static void main(String[] args) {
		BankingCashCounter counter =  new BankingCashCounter();
		int operation; // 1=> deposit 2=>withdraw 3=> process
		do {
			System.out.println("***********ENTER YOUR CHOICE:************");
			System.out.println(" 1 => deposit \n 2 => withdraw \n 3 => process \n 4 => exit");
			operation = Utility.getPositiveInt();
			
			switch(operation) {
			case 1 : System.out.println("\tEnter the amount to be deposited...!");
			Double depAmount = Utility.getDouble();
			counter.deposit(depAmount);
			break;

			case 2 : System.out.println("\tEnter the amount to be withdrawn...!");
			Double withdAmount = Utility.getDouble();
			counter.withdraw(withdAmount);
			break;

			case 3 : 
				if(counter.panel.size() == 0) 
				{
					System.out.println("\tNo transactions to process...!");
				}
				else
				{
					System.out.println("\tProcessing the transanction...!");
					counter.process();
				}
				break;

			case 4 : System.out.println("***************Thank you******************"); 
				break;//exiting

			default : System.out.println("\tInvalid input...!");
			break;
			}
		}while(operation >=0 && operation <=3);
	}

}
