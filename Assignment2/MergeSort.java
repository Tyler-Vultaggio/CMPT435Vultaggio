import java.io.FileNotFoundException;

/** @author Tyler Vultaggio
* Assignment 2
* Due Friday 10/8/2021
* Algorithms
*/

public class MergeSort 
{
	//I made this a global variable since I needed to keep the changes to it everytime merge was called.
	public static int countCompare = 0;
	
	public static void merge(String[] mergeArray, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        
  
        /* Create temp arrays */
        String L[] = new String[n1];
        String R[] = new String[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = mergeArray[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = mergeArray[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) 
        {
            if (L[i].compareTo(R[j]) <= 0) 
            {
                mergeArray[k] = L[i];
                i++;
                countCompare++;
            }
            else 
            {
                mergeArray[k] = R[j];
                j++;
                countCompare++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        {
            mergeArray[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        {
            mergeArray[k] = R[j];
            j++;
            k++;
        }
        //System.out.println(countCompare);
    }
	
	public static String[] mSort(String MergeArray[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            mSort(MergeArray, l, m);
            mSort(MergeArray, m + 1, r);
  
            // Merge the sorted halves
            merge(MergeArray, l, m, r);
        }
        
        return MergeArray;
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
		String[] MergeArray = new String[666];
		MergeArray = myFileReader.fileArray();
		MergeArray = mSort(MergeArray, 0, MergeArray.length-1);
		System.out.println(countCompare);
		//printArray(MergeArray);
	}

}
