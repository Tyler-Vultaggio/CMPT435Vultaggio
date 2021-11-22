/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 11/19/2021
* Algorithms
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class GraphandBtree 
{
	private static final String FILE_NAME = "graphs1.txt";
	private static final File myFile = new File(FILE_NAME);

	private static final String FILE_NAME_2 = "magicitems.txt";
	private static final File theFile = new File(FILE_NAME_2);
	
	private static final int TOTAL_LINES = 666;
	private static String[] magicItemsList = new String[TOTAL_LINES];
	
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
                    DFS dfs = new DFS(graph.getVertices());
                    System.out.println("\n---------------------------------------------");
                    System.out.println("BFS");
                    System.out.println("---------------------------------------------");
                    BFS bfs = new BFS(graph.getVertices());
                    System.out.println("\n---------------------------------------------\n");
                }
            }
    }
	
	private static String[] randomItems() 
	{
        String[] listOfRandomItems = new String[42];
        int numberOfElements = 42;
        for (int i = 0; i < numberOfElements; i++) 
        {
            listOfRandomItems[i] = magicItemsList[(int)(Math.random() * magicItemsList.length)];
        }
        return listOfRandomItems;
    }
	
	private static void readFileMagicItems() throws FileNotFoundException 
	{
            int magicItemPosition = 0;
            String currentLine;
            Scanner input = new Scanner(theFile);
            while (input.hasNext()) 
            {
                currentLine = input.nextLine();
                currentLine = input.nextLine();
                currentLine = currentLine.replaceAll("[0-9+,_()/.]", "");
                currentLine = currentLine.replaceAll("\\s", "");
                currentLine = currentLine.replaceAll("'", "");
                currentLine = currentLine.replaceAll("-", "");
                currentLine = currentLine.toLowerCase();
                currentLine = currentLine.substring(0,1).toUpperCase() + currentLine.substring(1).toLowerCase();
                magicItemsList[magicItemPosition] = currentLine;
                magicItemPosition++;
            }
            input.close();
    }

    // Perform Binary Search Tree operations: get 42 random items and search for them while
    // calculating results
    private static void binarySearchTreeResults() 
    {
        int avgcomp = 0;
        String[] list = randomItems();
        BSTree Tree = new BSTree();
        for (int i = 0; i < list.length; i++) 
        {
        	Tree.addNode(list[i]);
        }
        System.out.println("================BST===================");
        System.out.println("You touched the following nodes, in that order: ");
        Tree.TreeTraverseinOrder(Tree.getRoot());
        System.out.println("-----------------------------------");
        for (int j = 0; j < list.length; j++) {
            System.out.println("Search for " + list[j]);
            System.out.println("You found " + Tree.findNode(list[j]) +
                    " with " + Tree.getCount() + " comparisons");
            avgcomp = avgcomp + Tree.getCount();
        }
        System.out.println("-----------------------------------");
        System.out.println("Average number of comparisons: " + avgcomp / list.length);
        System.out.println("===================================");
    }

    // Not a fan of how I made this class, but I don't have time to make it look any cleaner
    public static void main(String[] args) throws FileNotFoundException 
    {
        readFileVertexAndMakeGraph();
        readFileMagicItems();
        binarySearchTreeResults();
    }


}
