/****************************************************************************************
 * Purpose : Implementation of tic - tac - toe game.
 * 
 * @author BridgeLabz/Sudhakar
 * @version 1.0
 * @since 16-09-2019
 *****************************************************************************************/

package com.bridgelabz.javaprograms.core.functional;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	public static Scanner sc = new Scanner(System.in);
	char[][] gameboard = new char[3][3];
	
	public static void main(String[] args) 
	{
		TicTacToe t = new TicTacToe();
		System.out.println("*******TIC TAC TOE GAME*******");
		System.out.println("Player VS Computer");
		System.out.println("Enter player symbol :");
		String str1 = sc.next();
		char usersymbol = str1.charAt(0);
		System.out.println("Enter computer symbol :");
		String str2 = sc.next();
		char computersymbol = str2.charAt(0);
		t.initializeBoard();
		System.out.println("\n*********Game Board**********\n");
		t.displayBoard();
		System.out.println("\nDo you want to turn 1st  y/n : ");
		String str3 = sc.next();
		char turn = str3.charAt(0);
		int count = 0;
		while(count++<9)
		{
			switch(turn)
			{
			case 'y' :
				System.out.println("\n****Player Turn*****");
				t.makeMove(usersymbol , 1);
				t.displayBoard();
				if(t.winORLose())
				{
					System.out.println("\n******Player Win*****");
					return;
				}
				turn = 'n';
				break;
			case 'n':
				System.out.println("\n*****Computer turn****");
				t.makeMove(computersymbol,0);				
				t.displayBoard();
				if(t.winORLose())
				{
					System.out.println("\n****Computer Win******");
					return;
				}
				turn = 'y';
				break;
			}
		}
		System.out.println("\nGame Draw...!!!!!");
	}
	
/****************************Tic Tac Toe***********************/
	public void initializeBoard()
	{
		for(int row = 0;row < 3;row++)
		{
			for(int col = 0;col<3;col++)
			{	
				gameboard[row][col] = ' ';
			}
		}
	}
	
	/**
	 * display the play board
	 */
	public void displayBoard()
	{
		//initializeBoard();
		for(int row = 0; row<gameboard.length;row++)
		{
			for(int col=0;col<gameboard[0].length;col++ )
			{
				System.out.print("  "+ gameboard[row][col]+"  ");
				if(col==0 || col==1)
				{
					System.out.print("|");
				}				
			}
			if(row==0 || row==1)				
				System.out.print("\n-----------------\n");			
		}
	}
	
	/**
	 * make the move on the board
	 * @param ch player symbol
	 * @param num
	 */
	public void makeMove(char ch , int num)
	{

		if(	num == 1 )
		{
			System.out.println("Player..enter your position to mark ");
			System.out.println("Row : ");
			int i = sc.nextInt();
			System.out.println("Column : ");
			int j = sc.nextInt();
			if(gameboard[i][j] == ' ')
			{
				gameboard[i][j] = ch;				
			}
			else
			{
				System.out.println("Already Marked...!!!");
				makeMove( ch , num);
			}
		}
		else if( num == 0 )
		{						
			computerMove(ch);
		}
	}

	/**
	 * performing the system move
	 * @param ch symbol for system play
	 * @return
	 */
	public char[][] computerMove(char ch)
	{
		for(int i = 0 ;i<3; i++)
		{	
			//rows
			if(gameboard[i][0]==gameboard[i][1] && gameboard[i][2] ==' ' && gameboard[i][0]!=' ')
			{
				gameboard[i][2] = ch;
				return gameboard;
			}
			if(gameboard[i][1]==gameboard[i][2] && gameboard[i][0] == ' ' && gameboard[i][1]!=' ') 				
			{
				gameboard[i][0] = ch ;
				return gameboard;
			}
			if(gameboard[i][0]== gameboard[i][2] && gameboard[i][1]==' ' && gameboard[i][1]!=' ')
			{
				gameboard[i][1] = ch ;
				return gameboard;
			}
			//Column
			if(gameboard[0][i]==gameboard[1][i] && gameboard[2][i] ==' ' && gameboard[1][i]!=' ')
			{
				gameboard[2][i] = ch;
				return gameboard;
			}
			if(gameboard[1][i]==gameboard[2][i] && gameboard[0][i] == ' ' && gameboard[1][i]!=' ') 				
			{
				gameboard[0][i] = ch ;
				return gameboard;
			}
			if(gameboard[0][i]== gameboard[2][i] && gameboard[1][i]==' ' && gameboard[2][i]!=' ')
			{
				gameboard[1][i] = ch ;
				return gameboard;
			}
		}

		//Cross
		if(gameboard[0][0]==gameboard[1][1] && gameboard[2][2] == ' ' && gameboard[1][1]!=' ') 				
		{
			gameboard[2][2] = ch ;
			return gameboard;
		}
		if(gameboard[1][1]==gameboard[2][2] && gameboard[0][0] == ' ' && gameboard[1][1]!=' ') 				
		{
			gameboard[0][0] = ch ;
			return gameboard;
		}
		if(gameboard[0][0]== gameboard[2][2] && gameboard[1][1]==' ' && gameboard[2][2]!=' ')
		{
			gameboard[1][1] = ch ;
			return gameboard;
		}


		if(gameboard[0][2]== gameboard[1][1] && gameboard[2][0]==' ' && gameboard[0][2]!=' ')
		{
			gameboard[2][0] = ch ;
			return gameboard;
		}		
		if(gameboard[1][1]==gameboard[2][0] && gameboard[0][2] == ' ' && gameboard[2][0]!=' ') 				
		{
			gameboard[0][2] = ch ;
			return gameboard;
		}
		if(gameboard[0][2]== gameboard[2][0] && gameboard[1][1]==' ' && gameboard[2][0]!=' ')
		{
			gameboard[1][1] = ch ;
			return gameboard;
		}

		Random random = new Random();
		int i = random.nextInt(3);
		int j = random.nextInt(3);
		if(gameboard[i][j] == ' ')
		{
			gameboard[i][j] = ch;				
		}
		else
		{
			makeMove(ch , 0);
		}
		return gameboard;
	}

	/**
	 * check the winning / loosing status of the game
	 * @return
	 */
	public boolean winORLose()
	{
		for(int i = 0 ;i<3; i++)
		{	
			if(gameboard[0][i]==gameboard[1][i] && gameboard[1][i]==gameboard[2][i] && gameboard[1][i]!=' ')
			{
				return true;
			}
			if(gameboard[i][0]==gameboard[i][1] && gameboard[i][1]==gameboard[i][2] && gameboard[i][1]!=' ')
			{
				return true;
			}
		}
		if((gameboard[0][0]==gameboard[1][1] && gameboard[1][1]==gameboard[2][2] &&  gameboard[1][1]!=' ') || 
				(gameboard[0][2]==gameboard[1][1] && gameboard[1][1]==gameboard[2][0] && gameboard[0][2]!=' '))
		{
			return true;
		}
		return false;
	}			

}
