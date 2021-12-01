/** @author Tyler Vultaggio
* Assignment 3
* Due Friday 11/19/2021
* Algorithms
*/

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import java.io.Reader;

public class myFileReaderforTargetItems 
{
	public static String[] fileArrayTargetItems() throws FileNotFoundException
	{
		Scanner scanner = new Scanner(new File("magicitems-find-in-bst.txt"));
		String[] myArray = new String[42];
		int index = 0;
		
		while(scanner.hasNextLine())
		{
			myArray[index] = scanner.nextLine();
			myArray[index] = myArray[index].replaceAll("[0-9+,_()/.]", "");
			myArray[index] = myArray[index].replaceAll("\\s", "");
			myArray[index] = myArray[index].replaceAll("'", "");
			myArray[index] = myArray[index].replaceAll("-", "");
			myArray[index] = myArray[index].toLowerCase();
			myArray[index] = myArray[index].substring(0,1).toUpperCase() + myArray[index].substring(1).toLowerCase();
			index = index + 1;
		}
		scanner.close();
		
		return myArray;
	}
	
	public static void main(String[] args) throws IOException
	{
		
	}

}
