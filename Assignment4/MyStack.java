/** @author Tyler Vultaggio
* Assignment 1
* Due Friday 9/24/2021
* Algorithms
*/


public class MyStack //extends Node
{
	public static Node top;
	
	/*
	 * public MyStack() {
	 * 
	 * }
	 */
	
	
	//Push adds and element to the top of the stack
	public void push(Vertex vertex)
	{
		Node oldTop = top;
		top = new Node();
		top.vertex = vertex;
		top.next = oldTop;
	}
	
	//Pop takes the top element off and returns it
	public Vertex pop()
	{
		if(this.isEmpty())
		{
			throw new IllegalArgumentException("Stack is empty");
		}
		
		else
		{
			Vertex poppedChar = top.vertex;
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
	
	}

}
