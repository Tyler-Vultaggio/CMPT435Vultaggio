/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/

import java.util.ArrayList;

public class BFS 
{
	
	private MyQueue queue = new MyQueue();
	
	public BFS(ArrayList<Vertex> vertices)
	{
		for(Vertex v: vertices)
		{
			if(!(v.getBFSisProcessed()))
			{
				BFStraverse(v);
			}
		}
	}
	
	
	public void BFStraverse(Vertex root)
	{
		queue.enqueue(root);
		root.setBFSisProcessed(true);
		while(!queue.isEmpty())
		{
			Vertex vertex = queue.dequeue();
			System.out.print(vertex.getID() + " ");
			ArrayList <Vertex> neighbours = root.getEdges();
			for(int i = 0; i < neighbours.size(); i++)
			{
				Vertex n = neighbours.get(i);
				if(n != null && !n.getBFSisProcessed())
				{
					queue.enqueue(n);
					n.setBFSisProcessed(true);
				}
			}
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
