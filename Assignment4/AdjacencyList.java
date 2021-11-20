/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/


public class AdjacencyList 
{
	
	private AdjacencyNode head = null;
	
	public AdjacencyList()
	{
		
	}
	
	//adds to the head of the list
	public void addHead(int Source, int Destination)
	{
		AdjacencyNode next = head;
		head = new AdjacencyNode(Source, Destination);
		head.setNext(next);
	}
	
	
}
