import java.io.FileNotFoundException;

/** @author Tyler Vultaggio
* Assignment 3
* Due Friday 11/5/2021
* Algorithms
*/
public class BinarySearch 
{
	
	public static int binSearch(String sortedArray[], String target)
	{
		 int start = 0;
		 int end = sortedArray.length - 1;
		 int comparisons = 0;
	        while (start <= end) 
	        {
	        	comparisons++;
	        	//System.out.println(comparisons);
	            int position = start + (end - start) / 2;
	 
	            int newtarget = target.compareTo(sortedArray[position]);
	 
	            // Check if newtarget is present at mid
	            if (newtarget == 0)
	                return comparisons;
	 
	            // If newtarget greater, ignore left half
	            if (newtarget > 0)
	            	start = position + 1;
	 
	            // If newtarget is smaller, ignore right half
	            else
	            	end = position - 1;
	        }
	 
	        return -1;
	}

	
	public static void main(String[] args) throws FileNotFoundException 
	{
		double totalCompares = 0;
		double averageCompares = 0;
		String[] TempArray = new String[666];
		TempArray = myFileReader.fileArray();
		String[] TargetArray = new String[42];
		for(int i = 0; i < TargetArray.length; i++)
		{
			TargetArray[i] = TempArray[i];
		}
		
		TempArray = MergeSort.mSort(TempArray, 0, TempArray.length-1);
		
		for(int i = 0; i < TargetArray.length; i++)
		{
			totalCompares = totalCompares + binSearch(TempArray, TargetArray[i]);
		}
		
		averageCompares = totalCompares/TargetArray.length;
		double roundedAverageCompares = (double) (Math.round(averageCompares*100.0)/100.0);
		System.out.println("This is the number of total comparisons: " + totalCompares);
		System.out.println("This is the average number of comparisons: " + roundedAverageCompares);
		
	}

}
