package testPackage;

import topologyGenerator.FileSystem;
import topologyGenerator.readAllFiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Prims
{
    private boolean unsettled[];
    private boolean settled[];
    private int numberofvertices;
    private int adjacencyMatrix[][];
    private int key[];
    public static final int INFINITE = Integer.MAX_VALUE;
    private int parent[];

    public Prims(int numberofvertices)
    {
        this.numberofvertices = numberofvertices;
        unsettled = new boolean[numberofvertices + 1];
        settled = new boolean[numberofvertices + 1];
        adjacencyMatrix = new int[numberofvertices + 1][numberofvertices + 1];
        key = new int[numberofvertices + 1];
        parent = new int[numberofvertices + 1];
    }

    public int getUnsettledCount(boolean unsettled[])
    {
        int count = 0;
        for (int index = 0; index < unsettled.length; index++)
        {
            if (unsettled[index])
            {
                count++;
            }
        }
        return count;
    }

    public void primsAlgorithm(int adjacencyMatrix[][])
    {
        int evaluationVertex;
        for (int source = 1; source <= numberofvertices; source++)
        {
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                this.adjacencyMatrix[source][destination] = adjacencyMatrix[source][destination];
            }
        }

        for (int index = 1; index <= numberofvertices; index++)
        {
            key[index] = INFINITE;
        }
        key[1] = 0;
        unsettled[1] = true;
        parent[1] = 1;

        while (getUnsettledCount(unsettled) != 0)
        {
            evaluationVertex = getMimumKeyVertexFromUnsettled(unsettled);
            unsettled[evaluationVertex] = false;
            settled[evaluationVertex] = true;
            evaluateNeighbours(evaluationVertex);
        }
    }

    private int getMimumKeyVertexFromUnsettled(boolean[] unsettled2)
    {
        int max = Integer.MIN_VALUE;
        int node = 0;
        for (int vertex = 1; vertex <= numberofvertices; vertex++)
        {
            if (unsettled[vertex] == true && key[vertex] > max)
            {
                node = vertex;
                max = key[vertex];
            }
        }
        return node;
    }

    public void evaluateNeighbours(int evaluationVertex)
    {

        for (int destinationvertex = 1; destinationvertex <= numberofvertices; destinationvertex++)
        {
            if (settled[destinationvertex] == false)
            {
                if (adjacencyMatrix[evaluationVertex][destinationvertex] != INFINITE)
                {
                    if (adjacencyMatrix[evaluationVertex][destinationvertex] < key[destinationvertex])
                    {
                        key[destinationvertex] = adjacencyMatrix[evaluationVertex][destinationvertex];
                        parent[destinationvertex] = evaluationVertex;
                    }
                    unsettled[destinationvertex] = true;
                }
            }
        }
    }

    public int[][] printMST()
    {
        System.out.println("SOURCE  : DESTINATION = WEIGHT");
        for (int vertex = 2; vertex <= numberofvertices; vertex++)
        {
            System.out.println(parent[vertex] + "\t:\t" + vertex +"\t=\t"+ adjacencyMatrix[parent[vertex]][vertex]);
        }

        int[][] primTreeMatrix = new int[numberofvertices][numberofvertices];

        for (int vertex = 2; vertex<=numberofvertices;vertex++){
            primTreeMatrix[parent[vertex]-1][vertex-1] = adjacencyMatrix[parent[vertex]][vertex];
        }

        for (int i=0;i<primTreeMatrix.length;i++){
            for (int j=0; j<primTreeMatrix.length; j++){
                if (primTreeMatrix[i][j]!=0){
                    primTreeMatrix[j][i] = primTreeMatrix[i][j];
                }
            }
        }


        return primTreeMatrix;
    }

    public static int[][] runPrim(int[][] adjMatrix)
    {
        int adjacency_matrix[][];
        int number_of_vertices;
        Scanner scan = new Scanner(System.in);

//        ArrayList<String> substrate = (ArrayList<String>) readAllFiles.substrateFileName();
//
//        FileSystem fileObj = new FileSystem(substrate.get(0));
//        System.out.println(substrate.get(0));
//
//        int[][] adjMatrix = fileObj.getAdjMatrix();

        number_of_vertices = adjMatrix.length;

        int[][] updatedAdjMatrix = new int[number_of_vertices+1][number_of_vertices+1];

        for (int i = 1; i <= number_of_vertices; i++)
        {
            for (int j = 1; j <= number_of_vertices; j++)
            {
                updatedAdjMatrix[i][j] = adjMatrix[i-1][j-1];
                if (i == j)
                {
                    updatedAdjMatrix[i][j] = 0;
                    continue;
                }
                if (updatedAdjMatrix[i][j] == 0)
                {
                    updatedAdjMatrix[i][j] = INFINITE;
                }
            }
        }


            Prims prims = new Prims(number_of_vertices);
            prims.primsAlgorithm(updatedAdjMatrix);
            int[][] primMatrix = prims.printMST();
        return primMatrix;

    }
}