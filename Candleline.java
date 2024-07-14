/*
Assignment:	Lab 11
Programmer:	Bennett Wenger
Date:		12-11-2015
Filename:	Candleline.java
Purpose:	This program calculates the costs associated with an order of candles.
*/

//imports

import java.util.*;
import java.text.DecimalFormat;

public class Candleline
{
	public static void main(String[] args)
	{
		//declare class variables

		double candleCost, shippingCost;
		int shippingType;

		//UI

		System.out.println("\t\tCandleline - Candles Online\n");

		//call methods

		candleCost = getCandleCost();
		shippingType = getShippingType();
		shippingCost = getShippingCost(candleCost, shippingType);
		output(candleCost, shippingCost);
	}
	//methods

	public static double getCandleCost()
	{
		//declare method variables

		Scanner input = new Scanner(System.in);
		double amount = 0.00;
		boolean check = false;

		//loop to receieve input

		while (!check)
		{
			//TRY/CATCH blocks for exception handling

			try
			{
				System.out.print("Enter the cost of the candle order: ");
				amount = input.nextDouble();

				if(amount <= 0)
				{
					throw new InputMismatchException();
				}
				check = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("\nError, enter a dollar amount greater than 0\n");
				input.nextLine();
			}
		}
		return amount;
	}
	public static int getShippingType()
	{
		//declare method variables

		Scanner input = new Scanner(System.in);
		int num = 0;
		boolean check = false;

		//loop for input

		while (!check)
		{
			//TRY/CATCH blocks for exception handling

			try
			{
				System.out.println("\nEnter the type of shipping:");
				System.out.println(" 1) Priority (Overnight)");
				System.out.println(" 2) Express (2 business days)");
				System.out.println(" 3) Standard (3 to 7 business days)");
				System.out.print("Enter type number: ");
				num = input.nextInt();

				if(num != 1 && num != 2 && num != 3)
				{
					throw new InputMismatchException();
				}
				check = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("\nError, enter a 1, 2, or 3\n");
				input.nextLine();
			}
		}
		return num;
	}
	public static double getShippingCost(double theCandleCost, int theShippingType)
	{
		//declare method variables

		double amount = 0;

		//perform calculations with IF statements

		if (theShippingType == 1)
		{
			amount = 16.95;
		}
		else if (theShippingType == 2)
		{
			amount = 13.95;
		}
		else if (theShippingType == 3 && theCandleCost < 100)
		{
			amount = 7.95;
		}
		else
		{
			amount = 0;
		}
		return amount;
	}
	public static void output(double theCandleCost, double theShippingCost)
	{
		// declare finance mask
		DecimalFormat finance = new DecimalFormat("$#,###,###,##0.00");

		// final output
		System.out.println("\nThe candle cost of " +
		finance.format(theCandleCost) +
		" plus the shipping costs of " +
		finance.format(theShippingCost) +
		" equals " +
		finance.format(theCandleCost + theShippingCost) +
		"\n");
	}
}