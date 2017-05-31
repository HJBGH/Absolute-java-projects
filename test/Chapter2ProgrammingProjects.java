package test;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Chapter2ProgrammingProjects {
	/** execute methods here, the methods will be implementations of the projects
	 * literally none of the code here is idiomatic or in any way sensibly designed, I'm just killing time with java.
	 * None of this code handles exceptions properly because I'm "programming by the book" so to speak - following the 
	 * textbook I'm using.
	 */
	public static void main(String args[])
	{
		incomeTaxCalculator();
		return;
	}
	
	//I must find out why this has to be static
	private static void babylonSqrRoot()
	{
		Scanner keyboardScanner = new Scanner(System.in);
		System.out.println("Enter your number and your best guess at the square root:");
		double number = keyboardScanner.nextDouble();
		double bestRootGuess = keyboardScanner.nextDouble(); //It's probably poor form to re-use this variable all through the method.
		if(number < 0 || bestRootGuess < 0)
		{
			System.out.println("No negative input please.");
			return;
		}
		for(int i = 0; i < 5; i++)
		{
			double r = number/bestRootGuess;
			bestRootGuess = (bestRootGuess + r)/2;
		}
		System.out.printf("Your root of %.2f is approximately %.2f", number, bestRootGuess);
	}
	
	private static void incomeTaxCalculator()
	{
		NumberFormat outputNumberFormat = NumberFormat.getCurrencyInstance(Locale.US);
		Scanner keyboardScanner = new Scanner(System.in);
		
		System.out.println("Please enter your Gross Income:");
		double grossIncome = keyboardScanner.nextDouble();
		System.out.println("Please enter your Standard Deduction:");
		double standardDeduction = keyboardScanner.nextDouble();
		System.out.println("Please enter your Personal Exemption:");
		double personalExemption = keyboardScanner.nextDouble();
		System.out.println("Please enter your Tax Rate:");
		double taxRate = keyboardScanner.nextDouble();
		double netIncome = grossIncome - (standardDeduction + personalExemption);
		
		//I know it really would be a better idea to get the name from the user but the book doesn't say I should so I'll take the lazy way out
		System.out.printf("Name:\t\t\t%s%n", "John Smith");
		System.out.printf("Gross income:\t\t%s%n", outputNumberFormat.format(grossIncome));
		System.out.printf("Standard Deduction:\t%s%n", outputNumberFormat.format(standardDeduction));
		System.out.printf("Personal Exemption:\t%s%n", outputNumberFormat.format(personalExemption));
		System.out.printf("Net Income\t\t%s%n", outputNumberFormat.format(netIncome));
		System.out.printf("Tax payable\t\t%s%n", outputNumberFormat.format(netIncome * (taxRate/100)));
		
	}
}
