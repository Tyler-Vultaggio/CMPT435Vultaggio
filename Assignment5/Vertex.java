/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/

import java.util.ArrayList;

public class Vertex 
{
	
	public int id;
	public ArrayList<Edges> edges = new ArrayList<Edges>();
	public Vertex next;
	//public int weight;
	
	
	public Vertex() 
	{
		id = 0;
		edges = null;
		next = null;
		//weight = 0;
	}
	
	public Vertex(int id)
	{
		this.id = id;
	}
	//This section is for setting methods
	//______________________________________________
	public void setID(int id) 
	{
		this.id = id;
	}
	public void setEdge(Edges edge)
	{
		edges.add(edge);
	}
	public void setNext(Vertex next)
	{
		this.next = next;
	}
	//______________________________________________
	
	//This section is for getting methods
	//______________________________________________
	public Integer getID()
	{
		return id;
	}
	public ArrayList<Edges> getEdges()
	{
		return edges;
	}
	public Vertex getNext()
	{
		return next;
	}
	//______________________________________________
	
	public void printVertexInfo() 
	{
        System.out.println( "\n____________________________________" );
        System.out.println( "Vertex ID: " + getID() );
        for( int i = 0; i < edges.size(); i++ ) 
        {        	
            System.out.println("Edge: " + edges.get(i).getSource().getID() + " - " + edges.get(i).getDestination().getID() + " and it's weight: " + edges.get(i).getWeight());
        }
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}

