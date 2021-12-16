/** @author Tyler Vultaggio
* Final Project
* Due Wednesday 12/15/2021
* Algorithms
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Population 
{
	public int populationSize;
	public double infectionRate;
	public ArrayList<Integer> population = new ArrayList<Integer>();
	//this is for printing out the array in an easy way (testing purpose)
	public Iterator<Integer> itr = population.iterator();
	
	//This is a constructor for the simulation of population
	Population(int size, double rate)
	{
		populationSize = size;
		infectionRate = rate/100;
	}
	
	//This fills the arraylist with health people (0's)
	public void fillPop()
	{
		for(int i = 0; i < populationSize; i++)
		{
			population.add(0);
		}
	}
	
	//This infects the popultaion based on the infection rate (1's)
	public void infect()
	{
		//This gets the rounded number of people that needs to be infected.
		int numInfected = (int)Math.round(populationSize * infectionRate);
		//System.out.println(numInfected);
		
		//This loop infects the first (numInfected) people.
		for(int i = 0; i < numInfected; i++)
		{
			//System.out.println("infected");
			population.set(i, 1);
		}
		//This shuffles the arraylist so that the infected people are all mixed in and not just at the front.
		Collections.shuffle(population);
	}
	
	//This was used for testing purposes.
	public void printArray()
	{
		int i = 1;
		itr = population.iterator();
		while (itr.hasNext()) 
		{
            System.out.print(itr.next() + " ");
            if(i%8 == 0)
            {
            	System.out.print(" | ");
            }
            i++;
        }
		System.out.println();
	}

	public static void main(String[] args) 
	{
		//This was for testing
		/*
		Population pop = new Population(104, 2);
		pop.fillPop();
		pop.printArray();
		pop.infect();
		pop.printArray();
		*/
	}

}
