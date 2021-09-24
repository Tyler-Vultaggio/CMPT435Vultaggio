/**
 * 
 */
import java.util.*;
/**
 * @author Tyler Vultaggio
 *
 */
//This is my node for my linked list
public class Node 
{
	public Node next;
	public String name;
	
	public Node () 
	{
		
	}
	
	//This section is for setting methods
	//______________________________________________
	public void setNext(Node node) 
	{
		next = node;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	//______________________________________________
	
	//This section is for getting methods
	//______________________________________________
	public String getName()
	{
		return name;
	}
	
	public Node getNext()
	{
		return next;
	}
	//______________________________________________
	
	public static void main(String[] args) 
	{
		//Creates each element in the List
		Node Film1 = new Node();
		Film1.name = "Spider-Man 1";
		Film1.next = null;
		Node Film2 = new Node();
		Film2.name = "Spider-Man 2";
		Film2.next = null;
		Node Film3 = new Node();
		Film3.name = "Spider-Man 3";
		Film3.next = null;
		Node Film4 = new Node();
		Film4.name = "Spider-Man: Into the Spider-Verse";
		Film4.next = null;
		
		
		//Links all of the elements in the list to make the Linked List
		Film2.next = Film1;
		Film3.next = Film2;
		Film4.next = Film3;
		
		
		
		
		
	}
	

}
