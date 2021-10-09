import java.io.FileNotFoundException;

/** @author Tyler Vultaggio
* Assignment 2
* Due Friday 10/8/2021
* Algorithms
*/

public class SelectionSort 
{
	public static String[] sSort(String[] SelectionArray)
	{
		int n = SelectionArray.length;
		int compare;
		int min;
		int countCompare = 0;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            min = i;
            for (int j = i+1; j < n; j++)
            {
            	compare = SelectionArray[j].compareTo(SelectionArray[min]);
            	countCompare++;
                if (compare < 0)
                {
					min = j;
                }
            }
 
            // Swap the min element into the i index
            String temp = SelectionArray[min];
            SelectionArray[min] = SelectionArray[i];
            SelectionArray[i] = temp;
        }
        System.out.println(countCompare);
		return SelectionArray;
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
		String[] SelectionArray = new String[666];
		SelectionArray = myFileReader.fileArray();
		SelectionArray = sSort(SelectionArray);
		//printArray(SelectionArray);
		

	}

}
