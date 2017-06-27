package chapter13projectsInterfacesAndInnerClasses;

import chapter13projectsInterfacesAndInnerClasses.Date;

/**
 * A re-implementation as part of project 13.8 of the Person class from display 5.19 of Absolute Java 
 * @author hb
 *
 */
public class Person {
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
	//TODO; copy out the rest of the methods
	
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
}
