/** @author Tyler Vultaggio
* Assignment 5
* Due Friday 12/10/2021
* Algorithms
*/

import java.util.ArrayList;

public class Graphs 
{
	
	private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	private ArrayList<Edges> edges = new ArrayList<Edges>();
	
	//This is the graph itself
	public Graphs()
	{
		
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
	public void addEdgetoGraph(int startId, int endId, int weight) 
	{
        int startLoc = getVertexLocation(startId);
        int endLoc = getVertexLocation(endId);
        Edges edge = new Edges();
        edge.setSource(vertices.get(startLoc));
        edge.setDestination(vertices.get(endLoc));
        edge.setWeight(weight);
        if( (startId != -1) && (endId != -1)) 
        {
            // If exists, lets add it
	        vertices.get(startLoc).setEdge(edge);
	        edges.add(edge);
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
	
	public void BellmanFord(Graphs graph, Vertex source)
	{
		int numberOfVertices = vertices.size();
		int numberOfEdges = edges.size();
		int distance[] = new int[numberOfVertices];
		
		//Sets the distance from the source to all of the vertices to infinity.
		for(int i = 1; i < numberOfVertices; i++)
		{
			distance[i] = Integer.MAX_VALUE;
			//System.out.println(vertices.get(i).getID());
		}
		//Sets distance to the source to the source to zero.
		distance[source.getID() - 1] = 0;
		
		for(int i = 1; i < numberOfVertices; i++)
		{
			//This finds the shortest path
			for(int j = 0; j < numberOfEdges; j++)
			{
				int from = edges.get(j).getSource().getID() - 1;
				int to = edges.get(j).getDestination().getID() - 1;
				int weight = edges.get(j).getWeight();
				if(distance[from] != Integer.MAX_VALUE && distance[to] > distance[from] + weight)
				{
					distance[to] = distance[from] + weight;
					edges.get(j).getDestination().setNext(edges.get(j).getSource());
					vertices.get(from).setNext(edges.get(j).getDestination());
					//System.out.println(edges.get(j).getDestination().getNext().getID());
					//System.out.println(vertices.get(from).getID());
				}
			}
		}
			
			
			//This second loop checks to see if there is an infinite negative loop cycle 
			for(int j = 0; j < numberOfEdges; j++)
			{
				int from = edges.get(j).getSource().getID() - 1;
				int to = edges.get(j).getDestination().getID() - 1;
				int weight = edges.get(j).getWeight();
				if(distance[from] != Integer.MAX_VALUE && distance[to] > distance[from] + weight)
				{
					System.out.println("There is an infinite loop.");
					break;
				}
			}
		
		printPath(distance);
	}
	
	public void printPath(int distance[])
	{
		for(int i = 1; i < vertices.size(); i++)
		{
			System.out.print("1 -> " + (i+1) + " cost is: " + distance[i] + "; path is 1");
			//path(i+1);
			System.out.println("");
		}
	}
	
	public void path(int end)
	{
		int i = 0;
		int j = 0;
		while(j != end)
		{
			System.out.print(" -> " + vertices.get(i).getNext().getID());
			i = vertices.get(i).getNext().getID() - 1;
			j = i + 1;
		}
	}
	
	 	
	public void GraphDetails()
	{
		for(int i = 0; i < vertices.size(); i++)
		{
			vertices.get(i).printVertexInfo();
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
}
