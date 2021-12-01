/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class GraphandBtree 
{
	private static final String FILE_NAME = "graphs1.txt";
	private static final File myFile = new File(FILE_NAME);
	
	
	private static void readFileVertexAndMakeGraph() throws FileNotFoundException 
	{
            String[] regVertex;
            String[] regEdges;
            Scanner input = new Scanner(myFile);
            String currentLine;
            Graphs graph = new Graphs();
            GraphAL adj = new GraphAL();
            Matrix matrix = new Matrix(0);
            int numGraph = 0;
            while (input.hasNextLine()) 
            {
                currentLine = input.nextLine();
                if (currentLine.equals("new graph")) 
                {
                	graph = new Graphs();
                    matrix = new Matrix(0);
                    adj = new GraphAL();
                    numGraph++;
                } 
                else if (!(currentLine.equals("")) && (currentLine.charAt(0) != '-')) 
                {
                    if (currentLine.charAt(4) == 'v') 
                    {
                        // add vertex
                        regVertex = currentLine.split("add vertex ");
                        graph.addVertex(Integer.parseInt(regVertex[1]));
                        adj.addVertex();
                        matrix = new Matrix(Integer.parseInt(regVertex[1]));
                    } 
                    else if (currentLine.charAt(4) == 'e') 
                    {
                        // add edge
                        regEdges = currentLine.split("\\s+");
                        graph.addEdgetoGraph(Integer.parseInt(regEdges[2]), Integer.parseInt(regEdges[4]));
                        adj.addEdge(Integer.parseInt(regEdges[2]), Integer.parseInt(regEdges[4]));
                        matrix.addEdge(Integer.parseInt(regEdges[2]), Integer.parseInt(regEdges[4]));
                    }
                } 
                else if (currentLine.trim().isEmpty()) {
                    System.out.println("\n=============================================");
                    System.out.println("Graph # " + numGraph);
                    System.out.println("=============================================");
                    System.out.println("Adjacency Matrix");
                    System.out.println("---------------------------------------------");
                    matrix.printMatrix();
                    System.out.println("---------------------------------------------");
                    System.out.println("Adjacency List");
                    System.out.println("---------------------------------------------");
                    adj.printGraph(adj);
                    System.out.println("\n---------------------------------------------");
                    System.out.println("Linked Object");
                    System.out.println("---------------------------------------------");
                    graph.GraphDetails();
                    System.out.println("---------------------------------------------");
                    System.out.println("DFS");
                    System.out.println("---------------------------------------------");
                    ArrayList<Vertex> vertices = graph.getVertices();
                    graph.DFS(vertices.get(0));
                    System.out.println("\n---------------------------------------------");
                    System.out.println("BFS");
                    System.out.println("---------------------------------------------");
                    graph.BFS(vertices.get(0));
                    System.out.println("\n---------------------------------------------\n");
                }
            }
    }
	

    // Perform Binary Search Tree operations: get 42 random items and search for them while
    // calculating results
    private static void binarySearchTreeResults() throws FileNotFoundException 
    {
        int avgcomp = 0;
        String[] magicItems = new String[666];
        magicItems = myFileReader.fileArray();
		String[] TargetArray = new String[42];
		TargetArray = myFileReaderforTargetItems.fileArrayTargetItems();
        BSTree Tree = new BSTree();
        for (int i = 0; i < magicItems.length; i++) 
        {
        	Tree.addNode(magicItems[i]);
        	System.out.println(magicItems[i]);
        	Tree.printPath();
        }
        System.out.println("================BST===================");
        System.out.println("You touched the following nodes, in that order: ");
        Tree.TreeTraverseinOrder(Tree.getRoot());
        System.out.println("-----------------------------------");
        for (int j = 0; j < TargetArray.length; j++) {
            System.out.println("Search for " + TargetArray[j]);
            Tree.findNode(TargetArray[j]);
            System.out.println("You found " + TargetArray[j] + " with " + Tree.getCount() + " comparisons");
            Tree.printPath();
            avgcomp = avgcomp + Tree.getCount();
        }
        System.out.println("-----------------------------------");
        System.out.println("Average number of comparisons: " + avgcomp / TargetArray.length);
        System.out.println("===================================");
    }

    // Not a fan of how I made this class, but I don't have time to make it look any cleaner
    public static void main(String[] args) throws FileNotFoundException 
    {
    	//You have to run one a time running both prints out way to much.
        readFileVertexAndMakeGraph();	
        binarySearchTreeResults();
    }


}
