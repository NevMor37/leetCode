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
       // List<Edge> edges;
        int [][] matrix1;
        int [][] matrix2;         
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
                    int BW = matrix1[i][j];
                    alledges.add(newEdge.addEdge(t, i-14, j, 1, matrix1[i][j]));  
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
    
    public void getAllEdgesOptical(){
        
        System.out.println("NSFNET14Test.txt");
        Random ran = new Random();
       int [][] matrix1;
       int [][] matrix2;         
       readFromFile rd=new readFromFile();        
       matrix1=rd.readfiles("NSFNET14Test.txt"); 
       matrix2=matrix1;
       int numOfVertices;
        numOfVertices=matrix1[0].length;
        int startIndexBW=0;
        int endIndexBW=numOfVertices;
        Edge newEdge=new Edge();
        newEdge.setVertexCount(numOfVertices);
        newEdge.setAdjacencyMatrix(matrix1);
         ArrayList<graphEdge> alledges1=new ArrayList<graphEdge>(); 
       for (int i = 0; i < matrix2.length; i++) {
                for (int j = 0; j < matrix2[i].length; j++) {                   
                   System.out.print(matrix2[i][j] + " ");    
                }
               System.out.println("");               
            }
      
       for (int i = 0; i < matrix2.length; i++) {
                for (int j = 0; j < matrix2[i].length; j++) {
                    
                    if(matrix2[i][j]==1)
                        matrix2[i][j]=10;
                  // System.out.print(matrix2[i][j] + " ");    
                }
              // System.out.println("");               
            }
        System.out.println("NSFNET14Test after");
       for (int i = 0; i < matrix2.length; i++) {
                for (int j = 0; j < matrix2[i].length; j++) {                   
                   System.out.print(matrix2[i][j] + " ");    
                }
               System.out.println("");               
            }
       
        int t=0;
        for (int i = startIndexBW; i < endIndexBW; i++) {
                for (int j = 0; j < numOfVertices; j++) {  
                    if (matrix1[i][j]>0){ 
                    int BW = matrix1[i][j];
                    alledges1.add(newEdge.addEdge(t, i, j, 1, matrix1[i][j]));  
                    
                    
                    int x = ran.nextInt(40-BW);
                        System.out.println("random x: " + x);
                      t++; 
                    //  matrix2[i][j]=BW;
              
                    }
     
                }
               //System.out.println("");               
            }
      for (int i = 0; i < alledges1.size(); i++) {
              System.out.println("Edge number: " + alledges1.get(i).getId()+ "******************Source: " + alledges1.get(i).getSource() +
                      " Destination: " + alledges1.get(i).getDestination() + " BW: " + alledges1.get(i).getBW());            
        }
    }
}
