/** @author Tyler Vultaggio
* Assignment 1
* Due Friday 9/24/2021
* Algorithms
*/


//This is my node for my linked list
public class Node 
{
	public Node next = null;
	public char letter;
	
	public Node () 
	{
		
	}
	
	//This section is for setting methods
	//______________________________________________
	public void setNext(Node next) 
	{
		this.next = next;
	}
	
	public void setName(char letter) 
	{
		this.letter = letter;
	}
	//______________________________________________
	
	//This section is for getting methods
	//______________________________________________
	public char getletter()
	{
		return letter;
	}
	
	public Node getNext()
	{
		return next;
	}
	//______________________________________________
	
	
	public static void main(String[] args) 
	{
		//Creates each element in the List
		Node List1 = new Node();
		List1.letter = 'L';
		List1.next = null;
		Node List2 = new Node();
		List2.letter = 'i';
		List2.next = null;
		Node List3 = new Node();
		List3.letter = 's';
		List3.next = null;
		Node List4 = new Node();
		List4.letter = 't';
		List4.next = null;
		
		
		//Links all of the elements in the list to make the Linked List
		List2.next = List1;
		List3.next = List2;
		List4.next = List3;
		
		
		//Test to see if it would print what I wanted
		//System.out.println(List4.getletter());
		
		
		
	}
	

}
