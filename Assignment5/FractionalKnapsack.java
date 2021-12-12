/** @author Tyler Vultaggio
* Assignment 5
* Due Friday 12/10/2021
* Algorithms
*/

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Comparator;
import java.util.*;

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
         Collections.sort(allSpices, Spices.SpicePricePer);
         
         //Prints the sorted arrayList of Spices in descending order of Price_per_qty
         //This is to see that it sorted how I wanted it to
         
         for (Spices spice : allSpices) 
         {
             spice.printSpice();
         }
         
         //The link below is where I learned the above from, I adapted what they did to make it work with my code.
         //https://www.geeksforgeeks.org/how-to-sort-an-arraylist-of-objects-by-property-in-java/
         
         int knapsackCount = 0;
         int spiceCount = 0;
         double spiceFraction;
         double differnceInSpace;
         System.out.println("\n=================================================");
         System.out.println("Filling the KnapSacks");
         System.out.println("=================================================");
         
         while(knapsackCount < knapsacks.length)
         {
        	 if(spiceCount < allSpices.size() && knapsacks[knapsackCount].getCurrent_Size() != knapsacks[knapsackCount].getTotal_Size())
        	 {
	        	 if(knapsacks[knapsackCount].getCurrent_Size() + allSpices.get(spiceCount).getQty() < knapsacks[knapsackCount].getTotal_Size())
	        	 {
	        		 knapsacks[knapsackCount].addSize(allSpices.get(spiceCount).getQty());
	        		 knapsacks[knapsackCount].addValue(allSpices.get(spiceCount).getTotal_Price());
	        		 System.out.println("Added all of " + allSpices.get(spiceCount).getColor());
	        		 spiceCount++;
	        	 }
	        	 else
	        	 {
	        		 differnceInSpace = (knapsacks[knapsackCount].getTotal_Size() - knapsacks[knapsackCount].getCurrent_Size());
	        		 spiceFraction = differnceInSpace/allSpices.get(spiceCount).getQty();
        			 knapsacks[knapsackCount].addValue(allSpices.get(spiceCount).getPrice_per() * differnceInSpace);
        			 knapsacks[knapsackCount].addSize(allSpices.get(spiceCount).getQty() * spiceFraction);
        			 System.out.println("Added qty: " + spiceFraction + " of spice: " + allSpices.get(spiceCount).getColor() + " at " + allSpices.get(spiceCount).getPrice_per() + " per.");
        			 spiceCount++;
	        	 }
        	 }
        	 else
        	 {
        		 
        		 System.out.println("Knapsack of capcity " + knapsacks[knapsackCount].getTotal_Size() + " is worth " + knapsacks[knapsackCount].getValue());
        		 System.out.println("\n_________________________________________________\n");
        		 knapsackCount++;
        		 spiceCount = 0;
        	 }
         }
         
	}
	

	public static void main(String[] args) throws FileNotFoundException 
	{
		readFileKnapsackandSpices();

	}

}
