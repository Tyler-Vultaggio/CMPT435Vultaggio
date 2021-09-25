/** @author Tyler Vultaggio
* Assignment 1
* Due Friday 9/24/2021
* Algorithms
*/


public class MyStack extends Node
{
	public static Node top;
	
	public MyStack()
	{
		
	}
	
	
	//Push adds and element to the top of the stack
	public void push(char newLetter)
	{
		Node oldTop = top;
		top = new Node();
		top.letter = newLetter;
		top.next = oldTop;
	}
	
	//Pop takes the top element off and returns it
	public char pop()
	{
		if(this.isEmpty())
		{
			throw new IllegalArgumentException("Stack is empty");
		}
		
		else
		{
			char poppedChar = top.letter;
			top = top.next;
			return poppedChar;
		}
	}
	
	//isEmpty checks to see if the stack is empty ... 
	public boolean isEmpty()
	{
		return(top==null);
	}
	
		
	
	
	
	public static void main(String[] args) 
	{
		//Testing the stack class to make sure everything works
		/*
		MyStack stack = new MyStack();
		stack.push('L');
		
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		*/
		
		
		/*
		String badString = "Tome of leadership and influence +4";
		
		badString = badString.replaceAll("[0-9+-,_()/]", "");
		badString = badString.replaceAll("\\s", "");
		badString = badString.replaceAll("'", "");
		
		
		System.out.print(badString);
		*/

	}

}
