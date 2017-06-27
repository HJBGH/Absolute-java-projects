package chapter13projectsInterfacesAndInnerClasses;

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

	private boolean dateOK(String monthString, int day, int year) {
		// TODO Auto-generated method stub
		return false;
	}

}
