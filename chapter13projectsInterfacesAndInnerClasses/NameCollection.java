package chapter13projectsInterfacesAndInnerClasses;

interface Enumeration
{
	public boolean hasNext(); //Returns true if another element in the collection exists
	
	public Object getNext(); //Returns the next element in the collection as an Object
}

public class NameCollection {
	String[] names;
	
	/**
	 * The list of names is initialized from outside
	 * and passed in as an array of strings
	 */
	NameCollection(String[] names)
	{
		this.names = names;
	}
	
	/**
	 * get Enumeration should returned an instance of the class that implements
	 * the Enumeration interface where hasNext() and getNext() correspond to
	 * data stored within the names array.
	 */
	Enumeration getEnumeration()
	{
		Enumeration eggs = new Enumeration()
			{
			
			}
		return eggs;
		//complete code here using inner class
	}
}
