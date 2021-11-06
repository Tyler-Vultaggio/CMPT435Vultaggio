/** @author Tyler Vultaggio
* Assignment 3
* Due Friday 11/5/2021
* Algorithms
*/

import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Objects;

public class HashTable extends HashNode
{
	
	static private HashNode [] hashTable = new HashNode[250];
	public static double totalComparisons = 0;
	public static int comparisons = 0;
	
	//Method for adding magicItem to the Hash Table
	//For my add it puts the first magicItem into the hashTable as a new node and then it makes a linked list off of that first node
	//thus for my get method the first get it does is actually a node that has a magicItem not just a pointer to a linked list.
	public static void add(int key, String magicItem)
	{
		//int location = key;
		HashNode newNode;
		newNode = new HashNode();
		newNode.magicItem = magicItem;       
		if (hashTable[key] == null)
		{
			//the linked list is still empty and this is the first entry
			hashTable[key] = newNode;
		}
		else 
		{
			HashNode runner; // the runner will go throught the linked list wothout loosing the head 
			runner = hashTable[key];
			HashNode prevNode = new HashNode();
			while (runner!=null)
			{
				prevNode = runner;
				runner = runner.next;
			}
			runner = newNode;
			prevNode.next = runner;
			//runner.key=key;
			runner.magicItem = magicItem; 
	   }
	}
	
	//Method for getting a word from the hashtable.
	//Because of how my add is set up my get is more efficient and my get and my first comparison for the chaining are the same.
	static String get(String word)
	{
		comparisons = 0;
        int location = getKey(word);
        //System.out.println("location value for get is " + location.toString());
        HashNode runner;
        runner = hashTable[location];
        while (runner!=null)
        {
        	totalComparisons++;
        	comparisons++;
            if (runner.magicItem.equals(word))
            {
                return runner.magicItem;
            }
            runner = runner.next;                            
        }       
        return null;
        
    }
	

	
	//For my key I take my cleaned string from my file reader and set that word to all lower case
	//and then I take each letter in the work as its ascii value and add them up and the take the total and % it by 250 to get the key value.
	public static int getKey(String magicItem)
	{
		int nameLenght = magicItem.length();
		int total = 0 ;
		int key = 0;
		magicItem = magicItem.toLowerCase();
	    for(int i = 0; i < nameLenght ; i++)
	    {        
	        char character = magicItem.charAt(i);
	        int ascii = (int) character;
	        total = total + ascii;
	    }
	    
	    key = total % 250;
	    
	    return key;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		//double totalCompares = 0;
		double averageCompares = 0;
		String[] HashArray = new String[666];
		HashArray = myFileReader.fileArray();
		String[] TargetArray = new String[42];
		for(int i = 0; i < TargetArray.length; i++)
		{
			TargetArray[i] = HashArray[i];
			//System.out.println(TargetArray[i] + getKey(TargetArray[i]));
		}
		
		HashArray = MergeSort.mSort(HashArray, 0, HashArray.length-1);
		
		//System.out.println();
		for(int i = 0; i < HashArray.length; i++)
		{
			add(getKey(HashArray[i]), HashArray[i]);
		}
		for(int i = 0; i < TargetArray.length; i++)
		{
			System.out.println(get(TargetArray[i]) + ": " + comparisons);
		}
		
		averageCompares = totalComparisons/TargetArray.length;
		double roundedAverageCompares = (double) (Math.round(averageCompares*100.0)/100.0);
		System.out.println("This is the number of total comparisons: " + totalComparisons);
		System.out.println("This is the average number of comparisons: " + roundedAverageCompares);
		
		
		
		
		//Test for my Key
		//System.out.println(getKey("ringofthemercifulblow"));

	}

}
