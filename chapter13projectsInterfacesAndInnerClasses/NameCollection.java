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
				private int pointer = 0; //this is probably the wrong way to go about this
				
				public String getNext()
				{
					//the fact that I can access names from here is very weird
					try
					{
						return names[pointer++];
					}
					catch (Exception e)
					{
						throw e;
					}
				}
				
				public boolean hasNext()
				{
					if(pointer >= names.length)
						return false;
					return true; //haven't bothered with the else, maybe that's bad practise
				}
			}; //needs a semicolon, this entire anonymous declaration is basically one statement
		return eggs;
		//complete code here using inner class
	}
}
