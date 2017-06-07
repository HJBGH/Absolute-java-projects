package chapter13projectsInterfacesAndInnerClasses;


/**
 * Flesh out the class's skeleton code with teh appropriate accessors, consturctors, and mutatiors. The
 * census authority should be able to assign a value to teh variable population to
 * each city that comes under their supervision. Next, modify the class so that it
 * implements the Comparable interface. The compareTo() method should compare
 * the value of the variable population; e.g., a city with a lower population
 * should precede a city with a higher population. Test your class by creating an
 * array of sample CityPopulation's and sort them using a sorting method 
 * that takes as input an array of type Comparable. 
 * 
 *
 */
public class CityPopulation implements Comparable
{
	private String name;
	private long population;
	
	public CityPopulation(String name, long population)
	{
		this.name = name;
		this.population = population;
	}
	
	public String getName()
	{
		return this.name; //Strings are immutable, this shouldn't cause any privacy leaks
	}
	
	public long getPopulation()
	{
		return this.population; //this should return the value, not a reference. I hope.
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPopulation(long population)
	{
		this.population = population;
	}

	@Override
	public int compareTo(Object arg0) {
		if (((CityPopulation)arg0).getPopulation() < this.getPopulation())
			return -1;
		if(((CityPopulation)arg0).getPopulation() > this.getPopulation())
			return 1;
		return 0;
	}
}
