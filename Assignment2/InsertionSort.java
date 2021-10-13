import java.io.FileNotFoundException;

/** @author Tyler Vultaggio
* Assignment 2
* Due Friday 10/8/2021
* Algorithms
*/

public class InsertionSort 
{
	public static String[] iSort(String[] InsertionArray)
	{
		int n = InsertionArray.length;
		String key;
		int countCompare = 0;
        for (int i = 1; i < n; ++i) 
        {
            key = InsertionArray[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && InsertionArray[j].compareTo(key) >= 0) 
            {
            	InsertionArray[j + 1] = InsertionArray[j];
                j = j - 1;
                countCompare++;
            }
            InsertionArray[j + 1] = key;
        }
		System.out.println(countCompare);
		return InsertionArray;
	}
	
	/*
	 * This is a function so that I can see the sorted array printed.
	 * Thus I know that it is working properly.
	 */
	
	public static void printArray(String[] printableArray)
	{
		for(int i = 0; i < 	printableArray.length; i++)
		{
			System.out.println(	printableArray[i]);
		}
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		//I am making a copy of the original array so I don't need to shuffle free 10 points
		String[] InsertionArray = new String[666];
		InsertionArray = myFileReader.fileArray();
		InsertionArray = iSort(InsertionArray);
		//printArray(InsertionArray);

	}

}
