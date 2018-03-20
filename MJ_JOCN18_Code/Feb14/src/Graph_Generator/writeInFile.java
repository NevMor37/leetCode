/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_Generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mjalalitabar1
 */
public class writeInFile {
    
    private int adjacencyMatrix[][];

    public writeInFile(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public writeInFile() {
    }
    
    
     public void writeFile(int[][] Matrix, int t){
         
         System.out.println("We are writing in:  " + "SR_" + t +".txt");
         
         
         for (int i = 0; i < Matrix.length; i++) {
             for (int j = 0; j < Matrix.length; j++) {
                 System.out.println(Matrix[i][j] + " ");
                 
             }
             System.out.println("");
         }
         
         
         
          
                 // String fileNameh2 = "adjMat.txt";
                  File f = new File("SR_" + t +".txt");
        try {
  
            
            FileWriter fw = new FileWriter(f, false); //the true will append the new data
            for (int i = 0; i < Matrix.length; i++) 
            {
                for (int j = 0; j < Matrix.length; j++) 
                   // fw.write(adjacencyMatrix[i][j] +",");//appends the string to the file
                    fw.write(Matrix[i][j] + ((j == Matrix[i].length-1) ? "" : ","));
                    fw.write("\r\n");//appends the string to the file
                   // System.out.print(adjacencyMatrix[i][j] + " ");            
            }
            fw.close();
            
 
            System.out.println("Done");
 
        } catch (IOException e) {}               
          
      }
     
     
     
       public void writeFilesecond(int[][] Matrix, int t){
           
           
           //System.out.println("MatrixMatrix" + Matrix);
          
                 String fileNameh2 = "SR_" + t +".txt";
                // File f = new File("SR_" + t +".txt");
        try {
  
            
            FileWriter fw = new FileWriter(fileNameh2, true); //the true will append the new data
            for (int i = 0; i < Matrix.length; i++) 
            {
                for (int j = 0; j < Matrix.length; j++) 
                   // fw.write(adjacencyMatrix[i][j] +",");//appends the string to the file
                    fw.write(Matrix[i][j] + ((j == Matrix[i].length-1) ? "" : ","));
                    fw.write("\r\n");//appends the string to the file
                   // System.out.print(adjacencyMatrix[i][j] + " ");            
            }
            fw.close();
            
 
            System.out.println("Done");
 
        } catch (IOException e) {}               
          
      }
       
       
       ////////////////////////////////////////
       
       
         public void writeFilesecondTrans(int[][] Matrix, String  t){
           
           
           //System.out.println("MatrixMatrix" + Matrix);
          
                 String fileNameh2 = t;
                // File f = new File("SR_" + t +".txt");
        try {
  
            
            FileWriter fw = new FileWriter(fileNameh2, true); //the true will append the new data
            for (int i = 0; i < Matrix.length; i++) 
            {
                for (int j = 0; j < Matrix.length; j++) 
                   // fw.write(adjacencyMatrix[i][j] +",");//appends the string to the file
                    fw.write(Matrix[i][j] + ((j == Matrix[i].length-1) ? "" : ","));
                    fw.write("\r\n");//appends the string to the file
                   // System.out.print(adjacencyMatrix[i][j] + " ");            
            }
            fw.close();
            
 
            System.out.println("Done");
 
        } catch (IOException e) {}               
          
      }
       
       ///////////////////////////////////////
     
         public void writeFileVirtual(int[][] Matrix){
          
                  String fileNameh2 = "servReq.txt";
        try {
  
            
            FileWriter fw = new FileWriter(fileNameh2, true); //the true will append the new data
            for (int i = 0; i < Matrix.length; i++) 
            {
                for (int j = 0; j < Matrix.length; j++) 
                   // fw.write(adjacencyMatrix[i][j] +",");//appends the string to the file
                    fw.write(Matrix[i][j] + ((j == Matrix[i].length-1) ? "" : ","));
                    fw.write("\r\n");//appends the string to the file
                   // System.out.print(adjacencyMatrix[i][j] + " ");            
            }
            fw.close();
            
 
            System.out.println("Done");
 
        } catch (IOException e) {}               
          
      }
 ////////////////////////////////////////////////////////// 
      public void writeFileEdge(int[][] Matrix){
          
                  String fileNameh2 = "NSFNET14.txt";
        try {
  
            
            FileWriter fw = new FileWriter(fileNameh2, true); //the true will append the new data
            for (int i = 0; i < Matrix.length; i++) 
            {
                for (int j = 0; j < Matrix.length; j++) 
                   // fw.write(adjacencyMatrix[i][j] +",");//appends the string to the file
                    fw.write(Matrix[i][j] + ((j == Matrix[i].length-1) ? "" : ","));
                    fw.write("\r\n");//appends the string to the file
                   // System.out.print(adjacencyMatrix[i][j] + " ");            
            }
            fw.close();
            
 
            System.out.println("Done");
 
        } catch (IOException e) {}               
          
      }   
         
 //////////////////////////////////////////////////////////    
     
       public void writeFileFunc(int[][] Matrix){
          
                  String fileNameh2 = "NSFNET14.txt";
        try {
  
            
            FileWriter fw = new FileWriter(fileNameh2, true); //the true will append the new data
            for (int i = 0; i < Matrix.length; i++) 
            {
                for (int j = 0; j < Matrix[i].length; j++) 
                   // fw.write(adjacencyMatrix[i][j] +",");//appends the string to the file
                    fw.write(Matrix[i][j] + ((j == 1) ? "" : ","));
                    fw.write("\r\n");//appends the string to the file
                   // System.out.print(adjacencyMatrix[i][j] + " ");            
            }
            fw.close();
            
 
            System.out.println("Done");
 
        } catch (IOException e) {}               
          
      }
       
       
        public void writeFileOriginal(int numOfNodes){
          
        int[][] Matrix;
        Matrix=new int[numOfNodes][numOfNodes];
        
            for (int i = 0; i < numOfNodes; i++) {
                for (int j = 0; j < numOfNodes; j++) {
                 Matrix[i][j]=4;   
                }
                
            }
                  String fileNameh2 = "serviceRequest.txt";
                  
                 // String key = "file" + item;
        try {
  
            
            FileWriter fw = new FileWriter(fileNameh2, true); //the true will append the new data
            for (int i = 0; i < Matrix.length; i++) 
            {
                for (int j = 0; j < Matrix.length; j++) 
                   // fw.write(adjacencyMatrix[i][j] +",");//appends the string to the file
                    fw.write(Matrix[i][j] + ((j == Matrix[i].length-1) ? "" : ","));
                    fw.write("\r\n");//appends the string to the file
                   // System.out.print(adjacencyMatrix[i][j] + " ");            
            }
            fw.close();
            
 
            System.out.println("Done");
 
        } catch (IOException e) {}               
          
      }
        
          public void writeFileFinal(int[][] Matrix){
          
                  String fileNameh2 = "final.txt";
        try {
  
            
            FileWriter fw = new FileWriter(fileNameh2, true); //the true will append the new data
            for (int i = 0; i < Matrix.length; i++) 
            {
                for (int j = 0; j < Matrix.length; j++) 
                   // fw.write(adjacencyMatrix[i][j] +",");//appends the string to the file
                    fw.write(Matrix[i][j] + ((j == Matrix[i].length-1) ? "" : ","));
                    fw.write("\r\n");//appends the string to the file
                   // System.out.print(adjacencyMatrix[i][j] + " ");            
            }
            fw.close();
            
 
            System.out.println("Done");
 
        } catch (IOException e) {}               
          
      }
       
       
}
