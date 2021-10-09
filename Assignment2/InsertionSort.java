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
            }
            InsertionArray[j + 1] = key;
        }
		
		return InsertionArray;
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		String[] InsertionArray = new String[666];
		InsertionArray = myFileReader.fileArray();
		InsertionArray = iSort(InsertionArray);
		for(int i = 0; i < InsertionArray.length; i++)
		{
			System.out.println(InsertionArray[i]);
		}

	}

}
