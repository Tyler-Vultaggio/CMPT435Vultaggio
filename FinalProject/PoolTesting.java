/** @author Tyler Vultaggio
* Final Project
* Due Wednesday 12/15/2021
* Algorithms
*/

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoolTesting 
{
	public static int populationSize = 1000;
	public static double infectionRate = 2;
	public static int groupSize = 8;
	public static int testsUsed;
	public static List<Integer> testGroup = new ArrayList<Integer>();
	public static List<Integer> testGroup1 = new ArrayList<Integer>();
	public static List<Integer> testGroup2 = new ArrayList<Integer>();
	public static Scanner input = new Scanner(System.in);
	
	//This function is for getting user inputs but it is not need to run the program since the global variables have been set already.
	public static void getUserInput()
	{
		boolean tryPopAgain = true;
		boolean tryRateAgain = true;
		
		//User input for population size
		while(tryPopAgain)
		{
			System.out.print("Please enter an integer value for the population size: ");
			populationSize = input.nextInt();
			if(populationSize < 1)
			{
				System.out.print("\nThe population size has to be greater than 7 since the test pool size is set to 8.\n");
			}
			else
			{
				System.out.println("You have entered a valid population size.");
				tryPopAgain = false;
			}
		}
		//User input for infection rate
		while(tryRateAgain)
		{
			System.out.print("Please enter an integer value for the infection rate the program will make it a %: ");
			infectionRate = input.nextInt();
			if(infectionRate <= 0 || infectionRate >= 100)
			{
				System.out.print("\nThe infection rate has to be greater than -1 and less than 101.\n");
			}
			else if(infectionRate >= 50)
			{
				System.out.println("The infection rate should be lower than 50% to be effective for pooled testing.");
			}
			else
			{
				System.out.println("You have entered a valid infection rate.");
				tryRateAgain = false;
			}
		}
		
	}
	
	public static void poolTesting(ArrayList<Integer> populationGroup)
	{
		int numberofgroups = populationSize/groupSize;
		if (numberofgroups == 0)
		{
			numberofgroups = 1;
		}
		//Expected values
		int tempCase3;
		DecimalFormat df = new DecimalFormat("#.##");
		if(df.format((numberofgroups *  0.0004)).equals("0"))
		{
			tempCase3 = 0;
		}
		else
		{
			tempCase3 = (int)Math.ceil(numberofgroups *  0.0004);
		}
		System.out.println("Expected output");
		System.out.println("========================================================");
		System.out.println("Case (1): " + numberofgroups + " × 0.8500 = " + df.format((numberofgroups *  0.8500)) + " instances requiring " + (int)Math.ceil(numberofgroups *  0.8500) + " tests");
		System.out.println("Case (2): " + numberofgroups + " × 0.1496 = " + df.format((numberofgroups *  0.1496)) + " instances requiring " + (int)Math.ceil(numberofgroups *  0.1496 * 7) + " tests");
		System.out.println("Case (3): " + numberofgroups + " × 0.0004 = " + df.format((numberofgroups *  0.0004)) + " instances requiring " + (tempCase3 * 11) + " tests");
		System.out.println("Total Tests expected are : " + ((int)Math.ceil(numberofgroups *  0.8500) + (int)Math.ceil(numberofgroups *  0.1496 * 7) + (tempCase3 * 11)) + " for a popultation size of: " + populationSize + " and for an infection rate of: " + infectionRate + "%");
		System.out.println("________________________________________________________\n");
		int case1 = 0;
		int case2 = 0;
		int case3 = 0;
		int startpos = 0;
		int endpos = startpos+8;
		for(int i = 0; i < numberofgroups; i++)
		{
			//This was to see where the indexes of test group were being created
			//System.out.println(startpos + " :: " + endpos);
			if(endpos > populationGroup.size()-1)
			{
				endpos = populationGroup.size()-1;
			}
			testGroup = populationGroup.subList(startpos, endpos);
			//System.out.println(testGroup);
			testsUsed++;
			
			//Checks to see if someone is infected
			if(isInfected(testGroup))
			{
				//Once in this if then it has to be case 2 or 3 so this next if is to check if its NOT case 3, and if it is case 3 it goes to the else.
				testGroup1 = testGroup.subList(0, groupSize/2);
				testGroup2 = testGroup.subList(groupSize/2, groupSize);
				//System.out.println(testGroup1);
				//System.out.println(testGroup2);
				if((isInfected(testGroup1) || isInfected(testGroup2)) && (!(isInfected(testGroup1)&&isInfected(testGroup2))))
				{
					case2++;
					testsUsed = testsUsed + 6;
					//System.out.println("Case 2");
				}
				else
				{
					case3++;
					testsUsed = testsUsed + 10;
					//System.out.println("Case 3");
				}
			}
			//This is for when its case 1 as in only one test was used because everyone was healthy
			else
			{
				case1++;
				//System.out.println("Case 1");
			}
			
			//isInfected(testGroup);
			//testGroup.clear();
			startpos = startpos+8;
			endpos = endpos+8;
		}
		//Prints the results of my pool test
		System.out.println("Results of my test");
		System.out.println("========================================================");
		System.out.println("Number of Case (1): " + case1 + " requiring " + (case1) + " tests.");
		System.out.println("Number of Case (2): " + case2 + " requiring " + (case2 * 7) + " tests.");
		System.out.println("Number of Case (3): " + case3 + " requiring " + (case3 * 11) + " tests.");
		System.out.println("Total number of tests used: " + testsUsed);
		System.out.println("________________________________________________________");
	}
	
	//Checks an arrayList to see if there is an infected person in the test group
	//If there is an infected person returns true if not returns false.
	public static boolean isInfected(List<Integer> testGroup)
	{
		for(int i = 0; i < testGroup.size(); i++)
		{
			//This is if there is an infected person in the pool, returns true
			if(testGroup.get(i) == 1)
			{
				//System.out.println("This test group is infected!");
				return true;
			}
		}
		//This returns false if everyone is health
		//System.out.println("This test group is clear of infection.");
		return false;
	}
	
	
	
	public static void main(String[] args) 
	{
		getUserInput();//This is optional, populationSize and infectionRate already have set global values.
		Population sim = new Population(populationSize, infectionRate);
		sim.fillPop();
		sim.infect();
		poolTesting(sim.population);
	}

}
