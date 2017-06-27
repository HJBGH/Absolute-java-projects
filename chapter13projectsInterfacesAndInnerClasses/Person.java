package chapter13projectsInterfacesAndInnerClasses;

import java.util.Scanner;

import chapter13projectsInterfacesAndInnerClasses.Date;

/**
 * A re-implementation as part of project 13.8 of the Person class from display 5.19 of Absolute Java 
 * @author hb
 *
 */
public class Person implements Cloneable{
	private String name;
	private Date born;
	private Date died; //if this is null the meat is still twitching.
	
	public Person(String initialName, Date birthDate, Date deathDate)
	{
		if(consistent(birthDate, deathDate))
		{
			name = initialName;
			born = new Date(birthDate); //copy constructor usage
			if(deathDate == null)
				died = null;
			else
				died = new Date(deathDate); // more copy constructor usage
		}
		else
		{
			System.out.println("Inconsistent dates, Aborting");
			System.exit(0);
		}
	}
	
	public Person clone()
	{
		return new Person(this.name, this.born, this.died);
	}
	
	public Person(Person original)
	{
		if (original == null)
		{
			System.out.println("Fatal Error; no original person");
			System.exit(0);
		}
		name = original.name;
		born = new Date(original.born);
		
		if(original.died == null)
			died = null;
		else
			died = new Date(original.died);
	}
	
	public void set(String newName, Date birthDate, Date deathDate)
	{
		//Definition for this method is in Self Test Exercise 4.1
	}
	
	public String toString()
	{
		//this is badly written method
		String diedString;
		if(died == null)
			diedString = ""; //Empty string
		else
			diedString = died.toString(); //died is a date
		
		return (name + ", " + born + "-" + diedString);
	}
	
	public boolean equals(Person otherPerson)
	{
		if(otherPerson == null)
			return false;
		else 
			return(name.equals(otherPerson.name)
					&& born.equals(otherPerson.born)
					&& datesMatch(died, otherPerson.died));
	}
	/**
	 * this is the part of the class with all the methods for dealing with dates in it
	 */
	
	/**
	 * To match, date1 and date2 must either the same date or must be both null.
	 */
	private static boolean datesMatch(Date date1, Date date2)
	{
		if (date1 == null)
			return (date2 == null);
		else if (date2 == null) //&& date1 != null
			return false;
		else //both dates not null.
			return (date1.equals(date2));
	}
	
	/**
	 * Precondition: newDate is a consistent date of birth.
	 * Postcondition: Date of birth of the calling object is newDate.
	 */
	public void setBirthDate(Date newDate)
	{
		if(consistent(newDate, died))
			born = new Date(newDate);
		else
		{
			System.out.println("Inconsistent dates. Aborting");
			System.exit(0);
		}
	}
	
	/**
	 * Precondition: newDate is a consistent date of death.
	 * Postcondition: Date of death of the calling object is newDate.
	 */
	public void setDeathDate(Date newDate)
	{
		if(!consistent(born, newDate))
		{
			System.out.println("Inconsistent dates. Aborting.");
			System.exit(0);
		}
		if(newDate == null)
			died = null;
		else
			died = new Date(newDate);
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	/**
	 * Precondition: The date of birth has been set, and changing the year
	 * part of the date of birth will give a consistent date of birth
	 * Postcondition: The year of birth is (changed to) newYear
	 */
	@SuppressWarnings("deprecation")
	public void setBirthYear(int newYear) //this shit really should throw errors instead of just exiting
	{
		if (born == null) //precondition is violated
		{
			System.out.println("Fatal error. Aborting");
			System.exit(0);
		}
		born.setYear(newYear); //this shit is deprecated apparently
		if (!consistent(born, died))
		{
			System.out.println("Inconsistent dates. Aborting");
			System.exit(0);
		}
	}
	
	/**
	 * Precondition: The date of death has been set, and changing the year part of the date of death will give a 
	 * consistent date of death.
	 * Postcondition: The year of death is (changed to) newYear
	 */
	@SuppressWarnings("deprecation")
	public void setDeathYear(int newYear)
	{
		if(died == null) //precondition is violated
		{
			System.out.println("Fatal Error. Aborting");
			System.exit(0);
		}
		died.setYear(newYear);
		if(!consistent(born, died))
		{
			System.out.println("Inconsistent dates. Aborting.");
			System.exit(0);
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public Date getBirthDate()
	{
		return new Date(born);
	}
	
	public Date getDeathDate()
	{
		if(died == null)
			return null;
		else
			return new Date(died);
	}
	
	/**
	 * To be consistent, birthDate must not be null. If there is no date of death (deathDate == Null),
	 * that is consistent with any birthDate. Otherwise, the birthDate must come before or be equal to the deathDate.
	 */
	
	private static boolean consistent(Date birthDate, Date deathDate)
	{
		if(birthDate == null)
			return false;
		else if (deathDate == null)
			return true;
		else
			return (birthDate.precedes(deathDate) || birthDate.equals(deathDate));
	}
	
	private class Date
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
			
			month = aDate.month; //Doesn't this cause a privacy leak? It does not.
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
}
