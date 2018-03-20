
package networksim;

import Algorithms.DijkstraAlgorithm1;
import Algorithms.findShortestPath;
import Graph_Generator.Edge;
import Graph_Generator.Vertex;
import Graph_Generator.graphEdge;
import Graph_Reader.readFromFile;
import java.io.FileNotFoundException;
import Graph_Reader.graphVertices;
import Graph_Reader.graphEdges;
import java.util.ArrayList;
import java.util.LinkedList;
import Algorithms.*;
import java.util.TreeMap;
import Graph_Generator.functionnode;
import Graph_Reader.requestVNFs;
import Graph_Generator.DepenGenerator;
import Graph_Generator.writeInFile;
import Graph_Generator.graphEdge;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;


public class NetworkSim {
    
    public static int getBW(String filename){
       
        int [][] matrix1;
        readFromFile rd=new readFromFile();        
        matrix1=rd.readfiles(filename);
        int numOfVertices;
        numOfVertices=matrix1[0].length;
        //int startIndexBW=numOfVertices;
        int endIndexBW=numOfVertices*2;
        
        int BW=matrix1[endIndexBW][0];
        return BW;
    }
    
    public static int numOfDep(String filename){
       
        int [][] matrix1;
        int NumOfDep=0;
        readFromFile rd=new readFromFile();        
        matrix1=rd.readfiles(filename);
        int numOfVertices;
        numOfVertices=matrix1[0].length;
        //int startIndexBW=numOfVertices;
        int endIndexBW=numOfVertices*2;
        
        for (int i = 0; i < matrix1[0].length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j]==1){
                    
                    NumOfDep++;
                }
            } 
        }
        return  NumOfDep;
    }
    
    public static boolean equal(final int[][] arr1, final int[][] arr2) {

  if (arr1 == null) {


return (arr2 == null);

  }


  if (arr2 == null) {
return false;
  }


if (arr1.length != arr2.length) {

return false;

  }


  for (int i = 0; i < arr1.length; i++) {


if (!Arrays.equals(arr1[i], arr2[i])) {


    return false;


}

  }

  return true;
    }
    

public static void main(String[] args) throws FileNotFoundException {
    

     ///uncomment thid block if you want to change the input files  
   /*   String fileName = "SR_" + i +".txt";   
        ArrayList<functionnode> VNFs=new ArrayList<functionnode>();
        requestVNFs all_VNFs=new requestVNFs();
        all_VNFs.finalRequestGenerator();
     
     */       
  int result[] = {0, 0, 0, 0, 0, 0,0}; //to be written in the Results file
  
// result[0] = initial rate(bw);
// result[1] = CPU
// result[2] = Number of nodes
// result[3] = Number of Dep
// result[4] = Flex cost
// result[5] = DFS cost
           
    for (int i = 34; i <35 ; i++) {
        
        String fileName = "SR_" + i +".txt";
        ArrayList<functionnode> VNFs=new ArrayList<functionnode>();
        requestVNFs all_VNFs=new requestVNFs(fileName);
        VNFs=all_VNFs.getAllVNFs(fileName);
        ArrayList<Vertex> Vertices=new ArrayList<Vertex>();        
        ArrayList<graphEdge> Edges=new ArrayList<graphEdge>();
        graphVertices allVer=new graphVertices();
        graphEdges allEdges=new graphEdges();
        Vertices= allVer.getAllVertices(VNFs.size());
        Edges= allEdges.getAllEdges(); 
        int BW;
        BW=getBW(fileName);
        int NumOfDep;
        NumOfDep=numOfDep(fileName);
        int flexCost;        
        int DFSCost;

      DynamicChain DC= new DynamicChain(Vertices, Edges, VNFs, fileName, BW);
      System.out.println("**************************************************************Starting the Dynamic mapping**************************************************************");
      flexCost=DC.mapping(); //Dynmaic grouping snd mapping

      System.out.println("**************************************************************Starting the DFS mapping**************************************************************");
     // FixChain FC= new FixChain(Vertices, Edges, VNFs,fileName,BW);
    //  DFSCost= FC.mappingDFS(); // Mapping based on the DFs
      
      
        result[0]=BW;
        result[1]=VNFs.get(0).getReqCPU();
        result[2]=VNFs.size();
        result[3]=NumOfDep;
        result[4]=flexCost;
       // result[5]=DFSCost;
        
        String fileNamefinal = "Results.txt";
        try {
            FileWriter fw = new FileWriter(fileNamefinal,true); //the true will append the new data

                System.out.println("***********");
                    fw.write(result[0] + "\t" + result[1] + "\t" + result[2] + "\t" + result[3] + "\t" + result[4]+ "\t" + result[5]);
                    fw.write("\r\n");
            fw.close();
            System.out.println("Done");

        } catch (IOException e) {   
        }

   }


    }
    
}
