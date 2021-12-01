/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/

import java.util.ArrayList;

public class Graphs 
{
	
	private ArrayList<Vertex> vertices;
	
	//This is the graph itself
	public Graphs()
	{
		vertices = new ArrayList<>();
	}
	
	//Adds a Vertex
	public void addVertex(int vertexID)
	{
		Vertex newVertex = new Vertex(vertexID);
		vertices.add(newVertex);
	}
	
	//Gets the vertices
	public ArrayList<Vertex> getVertices()
	{
		return vertices;
	}
	
	
	//Adds an edge to the graph
	public void addEdgetoGraph(int startId, int endId) 
	{
        int startLoc = getVertexLocation(startId);
        int endLoc = getVertexLocation(endId);
        if( (startId != -1) && (endId != -1)) 
        {
            // If exists, lets add it
	        vertices.get(startLoc).setEdge(vertices.get(endLoc));
	        vertices.get(endLoc).setEdge(vertices.get(startLoc));
	    }
	    else
	    {
	    	System.out.println("Vertex cannot be connected, make sure it exists");
	    }
	}
	
	//Gets the location of the Vertices
	public int getVertexLocation(int someVertexIdToFind) 
	{
		
		int location = 0;
		boolean found = false;
		while ( found == false && (location < vertices.size()) ) 
	    {
			if (someVertexIdToFind == vertices.get(location).getID()) 
	        {
				found = true;
	        } 
			else 
	        {
				location ++;
	        }
	    }
	        return location;
	 }
	
	
	  public void DFS(Vertex root) 
	  {
		  if(!root.DFSisProcessed)
		  {
			  System.out.print(root.id + " ");
			  root.setDFSisProcessed(true);
		  }
		  for(Vertex n: root.edges)
		  {
			  if(!n.DFSisProcessed)
			  {
				  DFS(n);
			  }
		  }
	  }
	  
	  public void BFS(Vertex root) 
	  {
		  MyQueue queue = new MyQueue();
		  queue.enqueue(root);
		  root.setBFSisProcessed(true);
		  while(!queue.isEmpty())
		  {
			  Vertex vertex = queue.dequeue();
			  System.out.print(vertex.id + " ");
			  for(Vertex n: vertex.edges)
			  {
				  if(!n.BFSisProcessed)
				  {
					  queue.enqueue(n);
					  n.setBFSisProcessed(true);
				  }
			  }
		  }
	  }
	 	
	public void GraphDetails()
	{
		for(int i = 0; i <vertices.size(); i++)
		{
			vertices.get(i).printVertexInfo();
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
}
