/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/


public class Matrix 
{
	private int LastVertex;
	private int matrix[][];
	
	public Matrix(int vertex)
	{
		LastVertex = vertex + 1;
		matrix = new int[LastVertex][LastVertex];
	}
	
	public void addEdge(int start, int end)
	{
		matrix[start][end] = 1;
		matrix[end][start] = 1;
	}
	
	public void printMatrix()
	{
		for(int i = 0; i < LastVertex; i++)
		{
			for(int j = 0; j < LastVertex; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
}
