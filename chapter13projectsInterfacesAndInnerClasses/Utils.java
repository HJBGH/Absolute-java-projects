package chapter13projectsInterfacesAndInnerClasses;


/**
 * The only reason this class exists is because I need an implementation of quicksort
 * for project 2, but the Arrays.sort() group of methods don't have what I'm looking for.
 * Everything in there requires generic arguments and comparators
 *
 */
public class Utils 
{
	public static void quickSort(Comparable array[], int start, int end)
	{
		if((end - start) >= 1)
		{
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot);
			quickSort(array, pivot+1, end);
		}
	}
	
	private static int partition(Comparable array[], int start, int end)
	{
		Comparable temp[]; //using a temporary array seems heavy handed
		int size = (end - start + 1);
		temp = new Comparable[size];
		
		Comparable pivotVal = array[start];
		int low = 0; //value used for moving elements down the array
		int high = size - 1; //value used for moving elements up the array
		
		for(int i = start + 1; i <= end; i++)
		{
			if(array[i].compareTo(pivotVal) <= 0)
			{
				temp[low]=array[i];
				low++;
			}
			else
			{
				temp[high]=array[i];
				high--;
			}
		}
		temp[low]=pivotVal; //put the pivot in the correct position of the temp array
		//the loop below copies the temp array into the corresponding position of the original
		for(int i = 0; i < size; i++)
		{
			array[start+i] = temp[i];
		}
		return (start+low);
	}
}

