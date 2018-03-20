/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

/**
 *
 * @author mjalalitabar1
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Iterator;    
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import Graph_Generator.*;
import Graph_Reader.graphEdges;
 

public class DijkstraAlgorithm1 {

  private final List<Vertex> nodes;
  private final List<graphEdge> edges;
  private Set<Integer> settledNodes;
  private Set<Integer> unSettledNodes;
  private Map<Integer, Integer> predecessors;
  private Map<Integer, Integer> distance;

  int BW;

  public DijkstraAlgorithm1(ArrayList<Vertex> nodes, ArrayList<graphEdge>graphEdges ) {
    // create a copy of the array so that we can operate on this array
    this.nodes = nodes;
    this.edges = graphEdges;
  }

  public void execute(int source, int initialRate) {
    Vertex verHere=new Vertex();
    verHere=getVer(source);
    settledNodes = new HashSet<Integer>();
    unSettledNodes = new HashSet<Integer>();
    distance = new HashMap<Integer, Integer>();
    predecessors = new HashMap<Integer, Integer>();
    distance.put(source, 0);
    unSettledNodes.add(source);
    while (unSettledNodes.size() > 0) {
      Integer node = getMinimum(unSettledNodes);
   //   System.out.println("node from getMin: " +node);
      settledNodes.add(node);
//      for (Integer temp : settledNodes) {
//        System.out.println("settledNodes: "+ temp);
//     }
      unSettledNodes.remove(node);     
      // Here, we need to define a BW
      // Then, send BW attribute to find the shortest path      
      BW=initialRate;
      findMinimalDistances(node,BW);
    }
  }

 // Updated findMinimalDistance with adding BW attributes
  private void findMinimalDistances(Integer node, int BW) {
      
     // System.out.println("findMinimalDistances node" + node.getNumber());
      // Adding BW for finding neighbors that are satisfying BW constraint
    List<Integer> adjacentNodes = getNeighbors(node,BW);
      //  List<Vertex> adjacentNodestocheck = getNeighborstocheck(node,BW);

     // System.out.println("in findMinimalDistances"  + adjacentNodes + " For nod: " + node+ " the needed BW: "+ BW);
    //   System.out.println("in findMinimalDistances"  + adjacentNodestocheck + " For nod: " + node+ " the needed BW: "+ BW);

//    for (int i = 0; i < adjacentNodes.size(); i++) {
//       System.out.println("returned from  getNeighbors " +adjacentNodes.get(i));   
//      }
//    if (adjacentNodes.isEmpty()){
//        
//          System.out.println("adjacentNodes isEmpty");
//    }
    
    for (Integer target : adjacentNodes) {
        
    //    System.out.println("getShortestDistance(target)" + getShortestDistance(target));
        
       // System.out.println("getShortestDistance(node)bbbbbb" + getShortestDistance(node));
        int s=0;
        s=getShortestDistance(node)+ getDistance(node, target);
       // System.out.println("getShortestDistance(node)+ getDistance(node, target)" + s);
      if (getShortestDistance(target) > s) {
        //  System.out.println("NNNNNNNNNNNNNNNNNN");
          
//          System.out.println("getShortestDistance(target)" + getShortestDistance(target));
//          System.out.println("getShortestDistance(node)+ getDistance(node, target)" + getShortestDistance(node)+ getDistance(node, target));

          //System.out.println("New distance: " +  getShortestDistance(node) + getDistance(node, target) );
        int sw=0;
        sw=getShortestDistance(node)+ getDistance(node, target);
       // System.out.println("aaaaaaaagetShortestDistance(node)+ getDistance(node, target)" + sw);
          
       //   System.out.println("target hererrrr"+ target.getNumber());
        
       //   System.out.println("final test " + target + "%%%%%%%" + getShortestDistance(node) + getDistance(node, target));
        distance.put(target, getShortestDistance(node) + getDistance(node, target));
       //   System.out.println("distanceXXXXXX" + distance);
        
        predecessors.put(target, node);
        unSettledNodes.add(target);
      //    System.out.println("<<<<<<<<<<<<");
      }
    }

      for (int name: distance.keySet()){
            int key =name;
            String value = distance.get(name).toString();  
           // System.out.println(key + " ditance set" + value);  
}
      System.out.println("");
  }

 private int getDistance(Integer node, Integer target) {
     // System.out.println("getDistance node" + node.getNumber());
     // System.out.println("getDistance target" + target.getNumber());
    for (graphEdge edge : edges) {

      if (edge.getSource()==node&& edge.getDestination()==target) {
                   // System.out.println("edge.getWeight();" + edge.getWeight());

    return edge.getWeight();

        
      }
    }
    throw new RuntimeException("Should not happen");
  }

  // Adding BW variable to check all connections that are
  // satisfying the requested BW
  private List<Integer> getNeighbors(Integer node, int BW) {      
   //  System.out.println("in getNeighbors for node:  " +node);
    List<Integer> neighbors = new ArrayList<Integer>();
    for (graphEdge edge : edges) {
      // System.out.println("end of edge " +edge.getDestination());
 
//       if (isSettled(edge.getDestination()))
//           System.out.println("second match");
//       if (edge.getBW()>=BW)
//            System.out.println("third match");
      if (edge.getSource()==node && isSettled(edge.getDestination())==false && edge.getBW()>=BW) {
       //  System.out.println("dddddddd " );
       //  System.out.println("sor " +edge.getSource() + " dest" + edge.getDestination());
        neighbors.add(edge.getDestination());
      }
    }
//      for (int i = 0; i < neighbors.size(); i++) {
//      System.out.println("in getNeighbors for; "  + node + " are: "+neighbors.get(i));   
//      }  
//      if (neighbors.isEmpty()) {          
//          System.out.println("no neigheeee");          
//      }
    return neighbors;
  }
  
    public Vertex getVer(int num) {
        Vertex org=new Vertex();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getNumber()==num)
                org= nodes.get(i);           
        }      
        return  org;     
    }

    //The next node to proceed
  private Integer getMinimum(Set<Integer> vertexes) {      
    Integer minimum = null;
    for (Integer vertex : vertexes) {
      if (minimum == null) {
        minimum = vertex;
       //   System.out.println("minimum" + minimum.getNumber());
      } else {
        if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
          minimum = vertex;
        }
      }
    }
    return minimum;
  }

  private boolean isSettled(Integer vertex) {
      boolean check=false;

       for (Integer temp : settledNodes) {
    
           if (temp==vertex) {
            check=true;
           // System.out.println("tempfff: "  +temp);
           // System.out.println("verte:  "+ vertex);
           // System.out.println("match in isSet " );
           }

     }
       
//        for (Integer temp : settledNodes) {
//        System.out.println("tem: " + temp);
//     }
//      System.out.println("dest in isSet: " + vertex);
    return check;
    
  }

  
  
  
  //Obtaining the distance

  public int getShortestDistance(Integer destination) {   
  Integer d = distance.get(destination);
    if (d == null) {    
    return Integer.MAX_VALUE;  
    } 
    else 
    {
      return d;         
    }   
  }

  /*
   * This method returns the path from the source to the selected target and
   * NULL if no path exists
   */
  public LinkedList<Integer> getPath(Vertex target) {
      
   //   System.out.println("Target: " + target);
    LinkedList<Integer> path = new LinkedList<Integer>();
    int step = target.getNumber();
    // check if a path exists
    if (predecessors.get(step) == null) {
      return null;
    }
    path.add(step);
    while (predecessors.get(step) != null) {
      step = predecessors.get(step);
      path.add(step);
    }
    // Put it into the correct order
    Collections.reverse(path);
    //System.out.println("path" + path);
    return path;
    
  
  }

} 

