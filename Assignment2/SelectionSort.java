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
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            min = i;
            for (int j = i+1; j < n; j++)
            {
            	compare = SelectionArray[j].compareTo(SelectionArray[min]);
                if (compare < 0)
                {
					min = j;
                }
            }
 
            // Swap the found minimum element with the first
            // element
            String temp = SelectionArray[min];
            SelectionArray[min] = SelectionArray[i];
            SelectionArray[i] = temp;
        }
        
		return SelectionArray;
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		String[] SelectionArray = new String[666];
		SelectionArray = myFileReader.fileArray();
		SelectionArray = sSort(SelectionArray);
		for(int i = 0; i < SelectionArray.length; i++)
		{
			System.out.println(SelectionArray[i]);
		}

	}

}
