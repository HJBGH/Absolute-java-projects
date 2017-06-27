package chapter13projectsInterfacesAndInnerClasses;

import java.util.Scanner;

/**
 * Copied straight out of Absolute Java fifth edition. This code is crap, it can't deal with exceptions
 *
 */
public class Date
{
	private String month;
	private int day;
	private int year; //a four digit number
	
	public Date(Date birthDate) {
		// TODO Auto-generated constructor stub
	}

	public void setYear(int newYear) {
		// TODO Auto-generated method stub
		
	}

	public boolean precedes(Date deathDate) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setDate(int monthInt, int day, int year)
	{
		if(dateOK(monthInt, day, year))
		{
			this.month = monthString(monthInt);
			this.day = day;
			this.year = year;
		}
		else
		{
			System.out.println("Fatal error");
			System.exit(0);
		}
	}
	
	public void setDate(String monthString, int day, int year)
	{
		if(dateOK(monthString, day, year))
		{
			this.month = monthString;
			this.day = day;
			this.year = year;
		}
		else
		{
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	public void setDate(int year)
	{
		setDate(1, 1, year);
	}
	
	private boolean dateOK(int monthInt, int dayInt, int yearInt) {
		return ( (monthInt >= 1) && (monthInt <=12) &&
				(dayInt >= 1) && (dayInt <= 31) &&
				(yearInt >= 1000) && (yearInt <= 9999) );
	}
	
	private boolean dateOK(String monthString, int dayInt, int yearInt) {
		return ( monthOK(monthString) &&
				(dayInt >= 1) && (dayInt <= 31) &&
				(yearInt >= 1000) && (yearInt <= 9999) );
	}
	
	private boolean monthOK(String Month)
	{
		return (month.equals("January") || month.equals("February") ||
				month.equals("March") || month.equals("April") ||
				month.equals("May") || month.equals("June") ||
				month.equals("July") || month.equals("August") ||
				month.equals("September") || month.equals("October") ||
				month.equals("November") || month.equals("December") );
	}
	
	public void readInput()
	{
		boolean tryAgain = true;
		Scanner keyboard = new Scanner(System.in);
		while (tryAgain)
		{
			System.out.println("Enter month, day, and year.");
			System.out.println("Do not use a comma.");
			String monthInput = keyboard.next();
			int dayInput = keyboard.nextInt();
			int yearInput = keyboard.nextInt();
			if (dateOK(monthInput, dayInput, yearInput))
			{
				setDate(monthInput, dayInput, yearInput)
				tryAgain = false;
			}
			else
				System.out.println("Illegal date. Re-enter input.");
		}
	}
	
}
