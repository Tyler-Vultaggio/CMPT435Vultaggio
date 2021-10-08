/** @author Tyler Vultaggio
* Assignment 2
* Due Friday 10/8/2021
* Algorithms
*/

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import java.io.Reader;

public class myFileReader 
{
	public static String[] fileArray() throws FileNotFoundException
	{
		Scanner scanner = new Scanner(new File("magicitems.txt"));
		String[] myArray = new String[666];
		int index = 0;
		
		while(scanner.hasNextLine())
		{
			myArray[index] = scanner.nextLine();
			myArray[index] = myArray[index].replaceAll("[0-9+,_()/.]", "");
			myArray[index] = myArray[index].replaceAll("\\s", "");
			myArray[index] = myArray[index].replaceAll("'", "");
			myArray[index] = myArray[index].replaceAll("-", "");
			myArray[index] = myArray[index].substring(0,1).toUpperCase() + myArray[index].substring(1).toLowerCase();
			index = index + 1;
		}
		scanner.close();
		
		return myArray;
	}
	
	public static void main(String[] args) throws IOException
	{
		
		
		//This was testing to see if my file reader was giving me the results I wanted.
		/*
		Scanner scanner = new Scanner(new File("magicitems.txt"));
		String[] myArray = new String[666];
		int index = 0;
		
		while(scanner.hasNextLine())
		{
			//System.out.println(scanner.nextLine());
			myArray[index] = scanner.nextLine();
			myArray[index] = myArray[index].replaceAll("[0-9+,_()/.]", "");
			myArray[index] = myArray[index].replaceAll("\\s", "");
			myArray[index] = myArray[index].replaceAll("'", "");
			myArray[index] = myArray[index].replaceAll("-", "");
			//System.out.println(myArray[index]);
			index = index + 1;
		}
		//System.out.println(myArray[665]);
		scanner.close();
		*/
		
		
		
		/*
		String fileName = "magicitems.txt";
		FileReader fileReader = new FileReader(fileName);
		
		File file = new File("magicitems.txt");
		FileReader input = new FileReader(file);
		
		try {
            int i;    
            while((i = fileReader.read()) != -1) {
               System.out.print((char)i);    
            }
       } finally {
           fileReader.close();
       }
		*/
		
		
		//System.out.println(0);

	}

}
