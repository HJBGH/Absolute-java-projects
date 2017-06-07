package chapter13projectsInterfacesAndInnerClasses;


/**
 * Modify the recursive implementation of binary search from Chapter 11 so that the
 * search method owkrs on any array of type Comparable[]. Test the implementation
 * with arrays of different types to see if it works.
 *
 */
public class Project1 {
	
	public static int binarySearch(Comparable[] domain, int first, int last, Comparable key)
	/**
	 * Searches the array domain for a key. If the key is not in the array segment,
	 * then -1 is returned. Otherwise returns an index in the segment such that key == a[index]
	 */
	{
		int result = 0; //initialize it to keep the compiler happy.
		
		if (first > last)
			result = -1;
		else
		{
			int mid = (first + last)/2;
			
			if (key == domain[mid])
				result = mid;
			else if (key.compareTo(domain[mid]) < 0)
				result = binarySearch(domain, first, mid-1, key);
			else if (key.compareTo(domain[mid])> 0)
				result = binarySearch(domain, mid+ 1, last, key);
		}
		return result;
	}

}
