/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/

import java.util.ArrayList;

public class Vertex 
{
	
	public int id;
	public boolean DFSisProcessed;
	public boolean BFSisProcessed;
	public ArrayList<Vertex> edges = new ArrayList<Vertex>();
	
	
	public Vertex() 
	{
		id = 0;
		DFSisProcessed = false;
		BFSisProcessed = false;
		edges = null;	
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
	public void setDFSisProcessed(boolean DFSisProcessed) 
	{
		this.DFSisProcessed = DFSisProcessed;
	}
	
	public void setBFSisProcessed(boolean BFSisProcessed) 
	{
		this.BFSisProcessed = BFSisProcessed;
	}
	public void setEdge(Vertex edge)
	{
		edges.add(edge);
	}
	
	//______________________________________________
	
	//This section is for getting methods
	//______________________________________________
	public Integer getID()
	{
		return id;
	}
	
	public boolean getDFSisProcessed()
	{
		return DFSisProcessed;
	}
	
	public boolean getBFSisProcessed()
	{
		return BFSisProcessed;
	}
	
	public ArrayList<Vertex> getEdges()
	{
		return edges;
	}
	//______________________________________________
	
	public void printDetails() 
	{
        System.out.println( "\n____________________________________" );
        System.out.println( "Vertex ID: " + getID() );
        System.out.println( "Edges: " );
        for( int i = 0; i < edges.size(); i++ ) 
        {
            System.out.println( edges.get(i).getID() );
        }
	}


}

