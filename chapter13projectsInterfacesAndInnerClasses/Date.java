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
	
	//Copy constructor
	public Date(Date aDate) {
		if(aDate == null) //not a date
		{
			System.out.println("Fatal error");
			System.exit(0);
		}
		
		month = aDate.month; //Doesn't this cause a privacy leak?
		day = aDate.day;
		year = aDate.year;
	}

	public boolean precedes(Date otherDate)
	{
		//this return statement is somewhat confusing at a glance.
		return (( year < otherDate.year) || 
			(year == otherDate.year && getMonth() <
			otherDate.getMonth()) ||
			(year == otherDate.year && month.equals(otherDate.month) && day < otherDate.day));
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
				setDate(monthInput, dayInput, yearInput);
				tryAgain = false;
				keyboard.close();
			}
			else
				System.out.println("Illegal date. Re-enter input.");
		}
	}
	
	/**
	 * the functions below are from display 4.9 and 4.13
	 */
	public void writeOutput()
	{
		System.out.println(month + " " + day + " " + year);
	}
	
	public void setMonth(int monthNumber)
	{
		if ((monthNumber <= 0) || (monthNumber > 12))
		{
			System.out.println("Fatal error");
			System.exit(0);
		}
		else
			month = monthString(monthNumber);
	}
	
	public void setDay(int day)
	{
		if((day <= 0) || (day > 31))
		{
			System.out.println("Fatal error");
			System.exit(0);
		}
		else
			this.day = day;
	}
	
	public void setYear(int year)
	{
		if((year < 1000) || (year > 9999))
		{
			System.out.println("Fatal Error.");
			System.exit(0);
		}
		else
			this.year = year;
	}
	
	public boolean equals(Date otherDate)
	{
		return ((month.equalsIgnoreCase(otherDate.month))
				&& (day == otherDate.day) && (year == otherDate.year)); 
	}
	
	private String monthString(int monthNumber) //HOLY FUCK an enum is perfect for this
	{
		switch (monthNumber)
		{
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			System.out.println("Fatal Error");
			System.exit(0);
			return "Error"; //the compiler is so god-damn needy
		}
	}
	
	public int getMonth() //USE AN ENUM FFFFFFFUUUUCKKKKKKK
	{
		if(month.equals("January"))//don't need to worry about cases
			return 1;
		else if (month.equals("February"))
			return 2;
		else if (month.equals("March"))
			return 3;
		else if (month.equals("April"))
			return 4;
		else if (month.equals("May"))
			return 5;
		else if (month.equals("June"))
			return 6;
		else if (month.equals("July"))
			return 7;
		else if (month.equals("August"))
			return 8;
		else if (month.equals("September"))
			return 9;
		else if (month.equals("October"))
			return 10;
		else if (month.equals("November"))
			return 11;
		else if (month.equals("December"))
			return 12;
		else
		{
			System.out.println("Fatal error");
			System.exit(0);
			return 0; //needy compiler
		}
	}
	
	
}
