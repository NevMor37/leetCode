package testPackage;

import topologyGenerator.*;

import java.util.ArrayList;
import java.util.List;

public class SortRPS {

	public SortRPS() {

	}

	public static List<Vertex> sortList(List<Vertex> vertexList) {

		Vertex[] vertices = new Vertex[vertexList.size()];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = vertexList.get(i);
		}
		List<Vertex> sortedList = new ArrayList<Vertex>();

		bubbleSort(vertices);

		for (Vertex vertex : vertices) {
			sortedList.add(vertex);
		}

		return sortedList;
	}

	public static void bubbleSort(Vertex[] v) {
		int j;
		boolean flag = true; // set flag to true to begin first pass
		Vertex temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			for (j = 0; j < v.length - 1; j++) {
				
				double currentReliability = findCumulativeReliability(v[j]);
				double nextReliability = findCumulativeReliability(v[j+1]);
				
				double currentCPU = findCumulativeCPU(v[j]);
				double nextCPU = findCumulativeCPU(v[j+1]);
				
				double currentAverage = currentCPU*currentReliability;
				double nextAverage = nextCPU*nextReliability;
				
//				System.out.println("First:\t"+currentCPU+", Second:\t"+nextCPU);
				
				if (currentAverage < nextAverage) // change to > for ascending sort
				{
					temp = v[j]; // swap elements
					v[j] = v[j + 1];
					v[j + 1] = temp;
					flag = true; // shows a swap occurred
				}
			}
		}
	}

	private static double findCumulativeReliability(Vertex vertex) {

		double cpu = .0;
		int counter = 0;
		
		for (Edge edge : vertex.adjacencies) {
//			System.out.println(vertex+"-"+edge.target+":\t"+edge.reliability);
			cpu+= edge.reliability;
			counter++;
		}
		
		return cpu/counter;
	}

	private static double findCumulativeCPU(Vertex vertex) {

		int cpu = vertex.CPU;
		int counter = 1;
		
		for (Edge edge : vertex.adjacencies) {
			
			cpu+= edge.target.CPU;
			counter++;
		}
		
		return (double)cpu/counter;
	}
	
//	private static int maxBandwidth(Vertex v) {
//
//		int max = Integer.MIN_VALUE;
//
//		for (int i = 0; i < v.adjacencies.size(); i++) {
//			if (max < v.adjacencies.get(i).bandWidth) {
//				max = v.adjacencies.get(i).bandWidth;
//			}
//		}
//
//		return max;
//	}
//
//	private static int maxDegree(Vertex v) {
//
//		return v.adjacencies.size();
//	}

}
