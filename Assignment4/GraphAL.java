/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/

import java.util.ArrayList;

public class GraphAL 
{
	
	private ArrayList <AdjacencyList> array;
	private int totalVertices;
	
	public GraphAL()
	{
		array = new ArrayList<>();
		array.add(0, new AdjacencyList());
		totalVertices = 1;
	}
	
	public void addVertex()
	{
		array.add(totalVertices, new AdjacencyList());
		totalVertices++;
	}
	
	public void addEdge(int source, int destination)
	{
		array.get(source).addHead(source, destination);
		array.get(destination).addHead(destination, source);
	}
	
	public void printGraph(GraphAL graph)
	{
		AdjacencyNode edge;
		int i = 0;
		if(graph.array.get(i).isEmpty())
		{
			i = 1;
		}
		while(i < graph.array.size())
		{
			if(graph.array.get(i).getHead() != null)
			{
				edge = graph.array.get(i).getHead();
				graph.array.get(i).printList(edge);
			}
			i++;
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
