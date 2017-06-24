package chapter13projectsInterfacesAndInnerClasses;

import java.util.Date;

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
}
