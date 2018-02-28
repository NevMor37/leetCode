package testPackage;


import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import topologyGenerator.*;

public class ShortestPath {

    public Vertex source;
    public Vertex destination;
    public Vertex[] vertices;
    private String fileName;

    public ShortestPath() {
        source = null;
        destination = null;
        vertices = setVertices();
    }

    public ShortestPath(String file) {
        source = null;
        destination = null;
        fileName = file;
        vertices = setVertices();

    }

    public void computePaths(Vertex[] vertices, int source, int bandwidth) {
        // System.out.println("Source node:"+source.toString());
        Vertex sourceNode = vertices[source];

        sourceNode.minDistance = 1.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(sourceNode);
        // System.out.println("Queue size:"+vertexQueue.size());
        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            for (int i = 0; i < u.adjacencies.size(); i++) {
                Edge e = u.adjacencies.get(i);
                // System.out.println("Edge e:"+e.toString());
                if (e.bandWidth >= bandwidth) {
//                     System.out.println("Bandwidth of Edge "+e.toString()+":"+e.bandWidth);
                    Vertex v = e.target;

                    double weight = e.reliability;

                    double distanceThroughU = u.minDistance * weight;
//                    System.out.println("Edge Reliability + Cumulative:\t"+weight+","+distanceThroughU);
                    
//                    System.out.println("Target "+v+" minRelibility:\t"+v.minDistance);
                    
                    if (distanceThroughU > v.minDistance) {
                        vertexQueue.remove(v);
                        v.minDistance = distanceThroughU;

                        v.previous = u;

                        vertexQueue.add(v);
                    }
                }

            }

        }

        vertexQueue.clear();
    }

    public List<Vertex> getShortestPathTo(Vertex target) {

        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }

    public List<Vertex> defineShortestPath(int s, int d, int bandWidth) {

        vertices = setVertices();
        Vertex source = vertices[s];
        Vertex destination = vertices[d];

//		System.out.println("Source Node["+source.toString()+"] to Destination Node["+destination.toString()+"]");

        // Computation for the shortest path from source to destination
        computePaths(vertices, s, bandWidth); // run DijkShortest

        List<Vertex> path = getShortestPathTo(destination);
        
        if (path.size() > 1) {
			return path;
		} else {
			path.clear();
			return path;
		}

//        return path;
    }

    public double totalDistance(List<Vertex> totalPath) {

        double distance = 0;
//        FileSystem file = new FileSystem(fileName);
//        int[][] adjMatrix = file.getAdjMatrix();
//        for (int i = 0; i < totalPath.size() - 1; i++) {
//            distance += adjMatrix[Integer.valueOf(totalPath.get(i).toString())][Integer
//                    .valueOf(totalPath.get(i + 1).toString())];
//        }
        
        distance = totalPath.get(totalPath.size()-1).minDistance;
        
        return distance;
    }

    public Vertex[] setVertices() {

        FileSystem file = new FileSystem(fileName);
        int[][] adjMatrix = file.getAdjMatrix();
        int[][] adjBWMatrix = file.getBandwidthMatrix();
        int[][] resourceMatrix = file.getResourceMatrix();
        Edge temp;
        Vertex[] vertices = new Vertex[adjMatrix.length];
        // Define all vertex variables as Vertex object
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(i);
            vertices[i].CPU = resourceMatrix[i][0];
            vertices[i].RAM = resourceMatrix[i][1];
        }

        // Set adjacencies of each vertex
        for (int i = 0; i < adjMatrix.length; i++) {
            ArrayList<Edge> edge = new ArrayList<Edge>();
            // System.out.println("From Vertex " + i + " to:");
            for (int j = 0; j < adjMatrix[i].length; j++) {

                // check the neighbors of any node[i]
                if (adjMatrix[i][j] != 0) {
                    // System.out.println("Vertex:" + vertices[j].toString() +
                    // "\t Weight:" + adjMatrix[i][j]);
                    temp = new Edge(vertices[i], vertices[j], adjMatrix[i][j]/100.0);
                    temp.bandWidth = adjBWMatrix[i][j];
                    edge.add(temp);
                }
            }
            vertices[i].adjacencies = edge;
            // System.out.println("=========================================");

        }

        return vertices;
    }
}