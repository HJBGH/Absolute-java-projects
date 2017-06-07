package chapter13projectsInterfacesAndInnerClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import chapter13projectsInterfacesAndInnerClasses.Project1; //<-- binary search is in here.
public class Project1Tests {

	@Test
	public void typeDoubleTest() {
		Double doubleObjects[] = {1.2, 2.0, 4.5, 9.8, 100.4, 2000.0}; //already ordered
		int result = Project1.binarySearch(doubleObjects, 0, 5, 1.2);
		assert(result == 0); //1.2 is expected to be found at doubleObjects[0]
	}

}
