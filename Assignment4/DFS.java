/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/

import java.util.ArrayList;

public class DFS 
{
	private ArrayList<Vertex> vertices;
	private MyStack stack = new MyStack();
	
	@SuppressWarnings("unchecked")
	public DFS(ArrayList<Vertex> vertices)
	{
		this.vertices = (ArrayList<Vertex>)vertices.clone();
		for(Vertex root : this.vertices)
		{
			if(!(root.getDFSisProcessed()))
			{
				DFStraverse(root);
			}
		}
	}
	
	public void DFStraverse(Vertex root)
	{
		stack.push(root);
		root.setDFSisProcessed(true);
		while(!stack.isEmpty())
		{
			Vertex vertex = stack.pop();
			System.out.print(vertex.getID() + " ");
			for(Vertex newRoot : vertex.getEdges())
			{
				if(!(newRoot.getDFSisProcessed()))
				{
					newRoot.setDFSisProcessed(true);
				}
				stack.push(newRoot);
			}
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
