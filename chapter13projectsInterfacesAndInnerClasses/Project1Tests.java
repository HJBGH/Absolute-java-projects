package chapter13projectsInterfacesAndInnerClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import chapter13projectsInterfacesAndInnerClasses.Project1; //<-- binary search is in here.
public class Project1Tests {

	@Test
	public void typeDoubleTest() 
	{
		Double doubleObjects[] = {1.2, 2.0, 4.5, 9.8, 100.4, 2000.0}; //already ordered
		int result = Project1.binarySearch(doubleObjects, 0, 5, new Double(1.2));
		assert(result == 0); //1.2 is expected to be found at doubleObjects[0]
	}
	
	@Test
	public void typeIntegerTest()
	{
		Integer intObjects[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int result = Project1.binarySearch(intObjects, 0, 7, new Integer(7));
		assert(result == 6);
	}
	
	//
	@Test
	public void typeStringTest()
	{
		String strings[] = {"Abaddon", "Beezlebub", "Carthage", "Devourer", "Empty", "Fallanges", "Grapple"};
		int result = Project1.binarySearch(strings, 0, strings.length-1, "Beezlebub");
		assert(result == 1);
	}
	
	//now two tests with cases where the object isn't present in the array
	
	@Test
	public void typeDoubleFailureTest() 
	{
		Double doubleObjects[] = {1.2, 2.0, 4.5, 9.8, 100.4, 2000.0}; //already ordered
		int result = Project1.binarySearch(doubleObjects, 0, 5, new Double(500));
		assert(result == -1); 
	}
	
	@Test
	public void typeIntegerFailureTest()
	{
		Integer intObjects[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int result = Project1.binarySearch(intObjects, 0, 7, new Integer(-4));
		assert(result == -1);
	}
}
