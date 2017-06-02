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
	private static final double PI = 3.14159;
	
	public static void main(String args[])
	{
		circleStats();
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
	
	private static void sumAndAverage()
	{
		Scanner keyboardScanner = new Scanner(System.in);
		
		System.out.println("Enter three integers:");
		
		int x = keyboardScanner.nextInt();
		int y = keyboardScanner.nextInt();
		int z = keyboardScanner.nextInt();
		System.out.printf("sum: %d%naverage: %f%n", x+y+z, (x+y+z)/3.0);
	}
	
	private static void circleStats()
	{
		Scanner keyboardScanner = new Scanner(System.in);
		
		System.out.println("Provide a radius");
		double radius = keyboardScanner.nextDouble();
		
		System.out.printf("Diameter:\t%f%n", radius*2);
		System.out.printf("Circumference:%f%n", PI*(radius*2));
		System.out.printf("Area of Circle:%f%n", PI*(radius*radius));
	}
}
