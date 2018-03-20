/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_Reader;

import Graph_Generator.Edge;
import Graph_Generator.Vertex;
import Graph_Generator.graphEdge;
import Graph_Generator.writeInFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author mjalalitabar1
 */
public class graphEdges {
    
        private ArrayList<Edge> edges;

    public graphEdges() {
      //  this.edges = null;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }
        
    public ArrayList<graphEdge> getAllEdges(){ //Get the edges

        System.out.println("/********************************");
        ArrayList<graphEdge> alledges=new ArrayList<graphEdge>();      
        List<Edge> edges;
        int [][] matrix1;
        int [][] matrix2;
        int[][] getAdjacencyMatrix;
         
        readFromFile rd=new readFromFile();        
        matrix1=rd.readfiles("NSFNET14.txt"); 
        matrix2=matrix1;
        int numOfVertices;
        numOfVertices=matrix1[0].length;
        //CPUmatrix=new int[numOfVertices][numOfVertices];
        int startIndexBW=numOfVertices;
        int endIndexBW=numOfVertices*2;
        Edge newEdge=new Edge();
        newEdge.setVertexCount(numOfVertices);
        newEdge.setAdjacencyMatrix(matrix1);
        int t=0;
        for (int i = startIndexBW; i < endIndexBW; i++) {
                for (int j = 0; j < numOfVertices; j++) {  
                    if (matrix1[i][j]>0){ 
                         
                    //Random rn = new Random();
                    int BW = matrix1[i][j];
                    alledges.add(newEdge.addEdge(t, i-14, j, 1, matrix1[i][j]));  
                     //  alledges.add(newEdge.addEdge(t, i-6, j, 1, matrix1[i][j]));                      

                      t++; 
                      matrix2[i][j]=BW;
              
                    }
     
                }
               //System.out.println("");               
            }

      for (int i = 0; i < alledges.size(); i++) {
              System.out.println("Edge number: " + alledges.get(i).getId()+ ">>>> Source: " + alledges.get(i).getSource() +
                      " Destination: " + alledges.get(i).getDestination() + " BW: " + alledges.get(i).getBW());            
        }
       
      writeInFile newAdj=new writeInFile();
       
    //newAdj.writeFileEdge(matrix2);
    return alledges;
    }
}
