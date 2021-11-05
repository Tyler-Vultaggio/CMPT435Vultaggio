import java.io.FileNotFoundException;

/** @author Tyler Vultaggio
* Assignment 3
* Due Friday 11/5/2021
* Algorithms
*/
public class LinearSearch 
{
	public static int linSearch(String SortedItems[], String target)
	{
		int comparisons = 0;
		
		for(int i = 0; i < SortedItems.length; i++)
		{
			comparisons++;
			if(SortedItems[i].equalsIgnoreCase(target))
			{
				//System.out.println(comparisons);
				return comparisons;
			}
			
		}
		return comparisons;
	}
	
	
	public static void printArray(String[] printableArray)
	{
		for(int i = 0; i < 	printableArray.length; i++)
		{
			System.out.println(	printableArray[i]);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		int totalCompares = 0;
		int averageCompares = 0;
		String[] TempArray = new String[666];
		TempArray = myFileReader.fileArray();
		String[] TargetArray = new String[42];
		for(int i = 0; i < TargetArray.length; i++)
		{
			TargetArray[i] = TempArray[i];
		}
		
		//printArray(TargetArray);
		TempArray = MergeSort.mSort(TempArray, 0, TempArray.length-1);
		
		for(int i = 0; i < TargetArray.length; i++)
		{
			totalCompares = totalCompares + linSearch(TempArray, TargetArray[i]);
		}
		
		averageCompares = totalCompares/TargetArray.length;
		System.out.println("This is the number of total comparisons: " + totalCompares);
		System.out.println("This is the average number of comparisons: " + averageCompares);
		
		
	}

}
