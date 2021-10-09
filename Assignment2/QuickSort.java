import java.io.FileNotFoundException;
import java.util.Random;

/** @author Tyler Vultaggio
* Assignment 2
* Due Friday 10/8/2021
* Algorithms
*/

public class QuickSort 
{
	
	public static int countCompare = 0;
	// A utility function to swap two elements
	static void swap(String[] QuickArray, int i, int j)
	{
	    String temp = QuickArray[i];
	    QuickArray[i] = QuickArray[j];
	    QuickArray[j] = temp;
	}
	
	public static int randomPivot(String[] QuickArray)
	{
		Random ran = new Random();
		int ran1 = ran.nextInt(QuickArray.length);
		int ran2 = ran.nextInt(QuickArray.length);
		int ran3 = ran.nextInt(QuickArray.length);
		//System.out.println(ran1 + " " + ran2 + " " + ran3);
		if(ran1 <= ran2 && ran1 <= ran3)
		{
			return ran1;
		}
		else if(ran2 <= ran1 && ran2 <= ran3)
		{
			return ran2;
		}
		else
		{
			return ran3;
		}
		
	}
	
	
	/*
	 * This function takes last element as pivot, places
	 * the pivot element at its correct position in sorted
	 * array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */

	static int partition(String[] QuickArray, int low, int high)
	{
		//System.out.println(randomPivot(QuickArray));
	    
	    // pivot
	    String pivot = QuickArray[high]; 
	      
	    // Index of smaller element and
	    // indicates the right position
	    // of pivot found so far
	    int i = (low - 1); 
	  
	    for(int j = low; j <= high - 1; j++)
	    {
	          
	        // If current element is smaller 
	        // than the pivot
	    	countCompare++;
	        if (QuickArray[j].compareTo(pivot) < 0) 
	        {
	              
	            // Increment index of 
	            // smaller element
	            i++; 
	            swap(QuickArray, i, j);
	            
	        }
	    }
	    swap(QuickArray, i + 1, high);
	    return (i + 1);
	}
	  
	/* The main function that implements QuickSort
	          QuickArray[] --> Array to be sorted,
	          start --> Starting index,
	          end --> Ending index
	 */
	static String[] qSort(String[] QuickArray, int start, int end)
	{
	    if (start < end) 
	    {
	          
	        // pi is partitioning index, QuickArray[p]
	        // is now at right place 
	        int part = partition(QuickArray, start, end);
	  
	        // Separately sort elements before
	        // partition and after partition
	        qSort(QuickArray, start, part - 1);
	        qSort(QuickArray, part + 1, end);
	        
	    }
	    
	    return QuickArray;
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
		String[] QuickArray = new String[666];
		QuickArray = myFileReader.fileArray();
		QuickArray = qSort(QuickArray, 0, QuickArray.length-1);
		System.out.println(countCompare);
		//printArray(QuickArray);
	}

}
