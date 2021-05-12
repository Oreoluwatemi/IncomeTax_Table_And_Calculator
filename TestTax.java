/*
Project#2
Course:ITC-5102 - Semester 1
Last Name:Lawal
First Name:Oreoluwa
ID:N01452264
Last Name:Shah
First Name:Ashka  
ID:N01414926
Section:RNB
This project represents my own work in accordance with Humber Academic Policy.
Date:4/21/2021
*/
package Project2;

import java.util.Scanner;

public class TestTax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		while (true) {

			// prompt user to enter a choice
			System.out.println("Select your choice \n" + "(1)Compute personal income Tax\n"
					+ "(2)Print the tax tables for taxable incomes (with range)\n" + "(0)Exit\n");

			int choice = input.nextInt();

			// switch statement for each choice cases
			switch (choice) {

			// choice case to compute personal income
			case 1:

				// asks user to enter a status
				System.out.println("0 for single filer ");
				System.out.println("1 for Married  joint or qualifying widower ");
				System.out.println("2 for married seperate ");
				System.out.println("3 for head of a house ");
				System.out.println("Enter your filing status :");

				// creating object of income tax class
				IncomeTax test1 = new IncomeTax();
				// sets status entered by user( using setter method)
				test1.setStatus(input.nextInt());
				// checks if the the user has entered valid status
				if (test1.getStatus() >= 0 && test1.getStatus() <= 3) {
					System.out.println("Enter your taxable income : $"); // asks user to enter the tax income
					test1.setTaxableIncome(input.nextDouble()); // sets taxable income entered by user (using setter
																// method)
					int[][] interval = { { 8350, 33950, 82250, 171550, 372950 },
							{ 16700, 67900, 137050, 208850, 372950 }, { 8350, 33950, 68525, 104425, 186475 },
							{ 11950, 45500, 117450, 190200, 372950 } };

					double[] rates = { 10, 15, 25, 28, 33, 35 };

					test1.setInterval(interval);
					test1.setRates(rates);
					System.out.println("Tax is : $" + test1.getIncomeTax(test1.getTaxableIncome(), test1.getStatus()));
				} else {
					System.out.println("Invalid status");
				}

				break;

			// choice case to print tax table and income with range
			case 2:

				// object of IncomeTax class with default constructor of no argument
				IncomeTax test = new IncomeTax();

				// prompts user to enter taxable income from and to.
				System.out.println("Enter taxable income from:");
				double taxableIncomeFrom = input.nextDouble();

				System.out.println("Enter taxable income to:");
				double taxableIncomeTo = input.nextDouble();

				System.out.println();

				// prints header
				System.out.println(
						"2001 tax tables for taxable income from $" + taxableIncomeFrom + " $" + taxableIncomeTo);
				System.out.println("--------------------------------------------------------");
				System.out.println("Taxable    Single    Married Joint    Married    Head of");
				System.out.println("Income               or Qualifying    Separate   a House");
				System.out.println("                     Widow(er)");
				System.out.println("--------------------------------------------------------");

				// loop to set taxable income and filing status and get income tax using 2001
				// rates
				// and also prints the income tax for each filing status
				for (double i = taxableIncomeFrom; i <= taxableIncomeTo;) {

					double single = test.getIncomeTax(i, test.SINGLE_FILER);
					double married = test.getIncomeTax(i, test.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER);
					double seperate = test.getIncomeTax(i, test.MARRIED_SEPARATELY);
					double head = test.getIncomeTax(i, test.HEAD_OF_HOUSEHOLD);

					System.out.printf("%-11.0f%-13.2f%-14.2f%-11.2f%-8.2f\n", i, single, married, seperate, head);
					i = i + 1000;
				}

				// object of IncomeTax with constructor
				IncomeTax test_2009 = new IncomeTax();

				// storing maximum amount of 2009 tax table to determine how much rate is to
				// applied on the taxable income
				int[][] interval_2009 = { { 8350, 33950, 82250, 171550, 372950 },
						{ 16700, 67900, 137050, 208850, 372950 }, { 8350, 33950, 68525, 104425, 186475 },
						{ 11950, 45500, 117450, 190200, 372950 } };

				// 2009 tax table rates are stored in these array
				double[] rates_2009 = { 10, 15, 25, 28, 33, 35 };

				// set interval and set rate
				test_2009.setInterval(interval_2009);
				test_2009.setRates(rates_2009);

				System.out.println();
				System.out.println();

				// print header for 2009 tax table
				System.out.println("2009 tax tables for taxable income from $" + taxableIncomeFrom + " to" + " $"
						+ taxableIncomeTo);
				System.out.println("--------------------------------------------------------");
				System.out.println("Taxable    Single    Married Joint    Married    Head of");
				System.out.println("Income               or Qualifying    Separate   a House");
				System.out.println("                     Widow(er)");
				System.out.println("--------------------------------------------------------");

				// loop to set taxable income and filing status and get income tax using 2009
				// rates
				// and also prints the income tax for each filing status
				for (double i = taxableIncomeFrom; i <= taxableIncomeTo;) {

					double single = test_2009.getIncomeTax(i, test.SINGLE_FILER);
					double married = test_2009.getIncomeTax(i, test.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER);
					double seperate = test_2009.getIncomeTax(i, test.MARRIED_SEPARATELY);
					double head = test_2009.getIncomeTax(i, test.HEAD_OF_HOUSEHOLD);

					System.out.printf("%-11.0f%-13.2f%-14.2f%-11.2f%-8.2f\n", i, single, married, seperate, head);

					i = i + 1000;
				}
				break;

			// choice case for user to exit
			case 0:
				System.out.println("You have exited!");
				System.exit(0);

			default:
				System.out.println("Invalid option");
			}
			System.out.println();
		}
	}

}
