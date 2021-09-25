/** @author Tyler Vultaggio
* Assignment 1
* Due Friday 9/24/2021
* Algorithms
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class palindromeTester //extends MyStack
{
	
	public static boolean isPalindrome(String word)
	{
		
		//All of the print statements where to show me what was happening at each stage so I could debug it
		//I thought it was good to leave them in but comment them out.
		
		//System.out.println(word);
		MyStack stack = new MyStack();
		MyQueue queue = new MyQueue();
		 
		char letter;
		 
		for(int i = 0; i < word.length(); i++)
		{
			letter = word.charAt(i);
			//System.out.println(letter);
			stack.push(letter);
			queue.enqueue(letter);
		}
		for(int i = 0; i < word.length(); i++)
		{
			//System.out.println(stack.isEmpty());
			//System.out.println(queue.isEmpty());
			char letter1 = stack.pop();
			char letter2 = queue.dequeue();
			//System.out.println(letter1 + " " + letter2);
			if(letter1 != letter2)
			{
				//This clears stack and queue when they are not a palindrome
				for(int j = i; j < word.length()-1; j++)
				{
					stack.pop();
					queue.dequeue();
				}
				return false;
			}	 
		}
		
		return true;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		//This puts the file (magicitems into an array of cleaned strings)
		Scanner scanner = new Scanner(new File("magicitems.txt"));
		String[] myArray = new String[666];
		int index = 0;
		
		
		//This while loop puts each line into an array string and then gets rid of any special chars and spaces
		while(scanner.hasNextLine())
		{
			myArray[index] = scanner.nextLine();
			myArray[index] = myArray[index].replaceAll("[0-9+,_()/.]", "");
			myArray[index] = myArray[index].replaceAll("\\s", "");
			myArray[index] = myArray[index].replaceAll("'", "");
			myArray[index] = myArray[index].replaceAll("-", "");
			myArray[index] = myArray[index].toLowerCase();
			
			index = index + 1;
		}
		scanner.close();
		
		//This loops through the whole array to check for Palindromes in the array
		for(int i = 0; i < myArray.length; i++)
		{
			if(isPalindrome(myArray[i]))
			{
				System.out.println(myArray[i]);
			}
		}

	}
	
	


}
