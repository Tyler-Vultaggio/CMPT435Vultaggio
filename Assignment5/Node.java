/** @author Tyler Vultaggio
* Assignment 1
* Due Friday 9/24/2021
* Algorithms
*/


//This is my node for my linked list
public class Node 
{
	public Vertex vertex = null;
	public Node next = null;
	
	public Node()
	{
		vertex = null;
		next = null;
	}
	
	public Node (Vertex vertex) 
	{
		this.vertex = vertex;
		next = null;
	}
	
	//This section is for setting methods
	//______________________________________________
	public void setNext(Node next) 
	{
		this.next = next;
	}
	
	public void setVertex(Vertex vertex) 
	{
		this.vertex = vertex;
	}
	//______________________________________________
	
	//This section is for getting methods
	//______________________________________________
	public Vertex getletter()
	{
		return vertex;
	}
	
	public Node getNext()
	{
		return next;
	}
	//______________________________________________
	
	
	public static void main(String[] args) 
	{
		
		
	}
	

}
