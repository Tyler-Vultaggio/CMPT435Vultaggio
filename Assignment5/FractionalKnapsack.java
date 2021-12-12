/** @author Tyler Vultaggio
* Assignment 5
* Due Friday 12/10/2021
* Algorithms
*/

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class FractionalKnapsack 
{
	private static final String FILE_NAME = "spice.txt";
	private static final File myFile = new File(FILE_NAME);
	
	public static void readFileKnapsackandSpices() throws FileNotFoundException 
	{
		 String[] regSpices;
         String[] regKnapsacks;
         Knapsack[] knapsacks = new Knapsack[5];
         int count = 0;
         Scanner input = new Scanner(myFile);
         String currentLine;
         ArrayList<Spices> allSpices = new ArrayList<Spices>();
         
         
         System.out.println("Greedy Spices :");
         System.out.println("==============================================");
         
         while(input.hasNextLine())
         {
        	 currentLine = input.nextLine();
        	 if(!(currentLine.contentEquals("")) && (currentLine.charAt(0) != '-'))
        	 {
        		 if(currentLine.charAt(0) == 's')
        		 {
        			 String temp = currentLine;
        			 temp = temp.replaceAll(";","");
        			 regSpices = temp.split(("\\s+"));
        			 Spices newSpice = new Spices(regSpices[3], Double.parseDouble(regSpices[6]), Integer.parseInt(regSpices[9]));
        			 allSpices.add(newSpice);
        		 }
        		 else if(currentLine.charAt(0) == 'k')
        		 {
        			 String temp = currentLine;
        			 temp = temp.replaceAll(";","");
        			 regKnapsacks = temp.split(("\\s+"));
        			 Knapsack newSack = new Knapsack(Integer.parseInt(regKnapsacks[3]));
        			 knapsacks[count] = newSack;
        			 count++; 
        		 }
        	 }
         }
	}
	
	public void sortSpices(ArrayList<Spices> allSpices)
	{
		//allSpices.sort(()-> o1.getCustomProperty().compareTo(o2.getCustomProperty()));
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		readFileKnapsackandSpices();

	}

}
