/** @author Tyler Vultaggio
* Assignment 5
* Due Friday 12/10/2021
* Algorithms
*/
public class Edges 
{
	public Vertex source;
	public Vertex destination;
	public int weight;
	
	public Edges()
	{
		source = null;
		destination = null;
		weight = 0;
		
	}
	
	//This section is for setting methods
	//______________________________________________
	public void setSource(Vertex edge)
	{
		this.source = edge;
	}
	public void setDestination(Vertex edge)
	{
		this.destination = edge;
	}
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	//______________________________________________
	
	//This section is for getting methods
	//______________________________________________
	public Vertex getSource()
	{
		return source;
	}
	public Vertex getDestination()
	{
		return destination;
	}
	public Integer getWeight()
	{
		return weight;
	}
	//______________________________________________
	
	
	/*
	 * public void printEdgeInfo() { System.out.println("Edge:" + edge.getID() +
	 * "Weight: " + getWeight()); }
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
