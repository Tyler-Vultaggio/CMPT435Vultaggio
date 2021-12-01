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
	
	public AdjacencyNode getHead()
	{
		return head;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public void printList(AdjacencyNode edge)
	{
		System.out.print(edge.getStart() + " -> :");
		while(edge != null)
		{
			System.out.print(" " + edge.getEnd());
			edge = edge.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
}
