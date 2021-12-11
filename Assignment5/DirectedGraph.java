/** @author Tyler Vultaggio
* Assignment 4
* Due Friday 12/10/2021
* Algorithms
*/

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class DirectedGraph 
{
	private static final String FILE_NAME = "graphs2.txt";
	private static final File myFile = new File(FILE_NAME);
	
	
	private static void readFileVertexAndMakeGraph() throws FileNotFoundException 
	{
            String[] regVertex;
            String[] regEdges;
            Scanner input = new Scanner(myFile);
            String currentLine;
            Graphs graph = new Graphs();
            int numGraph = 0;
            while (input.hasNextLine()) 
            {
                currentLine = input.nextLine();
                if (currentLine.equals("new graph")) 
                {
                	graph = new Graphs();
                    numGraph++;
                } 
                else if (!(currentLine.equals("")) && (currentLine.charAt(0) != '-')) 
                {
                    if (currentLine.charAt(4) == 'v') 
                    {
                        // add vertex
                        regVertex = currentLine.split("add vertex ");
                        graph.addVertex(Integer.parseInt(regVertex[1]));
                    } 
                    else if (currentLine.charAt(4) == 'e') 
                    {
                        // add edge
                        regEdges = currentLine.split("\\s+");
                        graph.addEdgetoGraph(Integer.parseInt(regEdges[2]), Integer.parseInt(regEdges[4]), Integer.parseInt(regEdges[5]));
                    }
                } 
                else if (currentLine.trim().isEmpty()) 
                {
                    System.out.println("\n=============================================");
                    System.out.println("Graph # " + numGraph);
                    System.out.println("=============================================");
                    System.out.println("\n---------------------------------------------");
                    System.out.println("Linked Object");
                    System.out.println("---------------------------------------------");
                    graph.GraphDetails();
                    System.out.println("\n---------------------------------------------");
                    System.out.println("Paths");
                    System.out.println("---------------------------------------------");
                    graph.BellmanFord(graph, graph.getVertices().get(0));
                }
            }
            //input.close();
    }

    // Not a fan of how I made this class, but I don't have time to make it look any cleaner
    public static void main(String[] args) throws FileNotFoundException 
    {
        readFileVertexAndMakeGraph();	
    }


}
