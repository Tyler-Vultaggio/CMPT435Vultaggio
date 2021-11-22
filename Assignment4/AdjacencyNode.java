/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/

public class AdjacencyNode 
{
	private int start;
	private int end;
	private AdjacencyNode next;
	
	public AdjacencyNode()
	{
		
	}
	
	public AdjacencyNode(int start, int end)
	{
		this.start = start;
		this.end = end;
		next = null;
	}
	
	public void setStart(int start)
	{
		this.start = start;
	}
	
	public void setEnd(int end)
	{
		this.end = end;
	}
	
	public void setNext(AdjacencyNode next)
	{
		this.next = next;
	}
	
	public int getStart()
	{
		return start;
	}
	
	public int getEnd()
	{
		return end;
	}
	
	public AdjacencyNode getNext()
	{
		return next;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
}
