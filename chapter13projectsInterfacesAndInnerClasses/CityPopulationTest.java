package chapter13projectsInterfacesAndInnerClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import chapter13projectsInterfacesAndInnerClasses.CityPopulation;
import chapter13projectsInterfacesAndInnerClasses.Utils;

public class CityPopulationTest {

	@Test
	public void test() {
		/**
		 * test instances in an array. this will be sorted to test the 
		 * implementation of comparable. This test isn't really written
		 * like a proper test.
		 */
		CityPopulation populations[] = {new CityPopulation("A town", 5000),
										new CityPopulation("Pinecreek", 700),
										new CityPopulation("Metropolis", 50000000),
										new CityPopulation("Night Vale", 20000),
										new CityPopulation("Pallet Town", 12)};
		Utils.quickSort(populations, 0, 4);
		for(int i = 0; i<=4; i++)
		{
			System.out.println(populations[i].getName());
		}
	}

}
