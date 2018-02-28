package testPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import topologyGenerator.*;
import graphGenerator.*;

public class AlgoRPA {

	private double reliability;
	private int numberOfHop;
	private List<Vertex> finalTree;
	private int bandwidth;


	public void nodeMapping(String sFilename, int[] request) {

		GenerateVertex topology = new GenerateVertex();

		List<Vertex> substrate = topology.setVertices(sFilename);

		// Virtual_BCR virtual = new Virtual_BCR();

		// List<int[]> request = virtual.createRequestList(100, 200, 20);

		List<Vertex> sortedSubstrate = sortVertices(substrate);

		// for (Vertex vertex : sortedSubstrate) {
		// System.out.println(vertex);
		// }

		Vertex startPoint = sortedSubstrate.get(0);
		System.out.println(startPoint);

		List<Vertex> constructedTree = findTree(startPoint, request);

		if (constructedTree!=null) {
			
		
		System.out.println(Arrays.toString(constructedTree.toArray()));

		double totalReliability = findReliability(constructedTree, this.bandwidth);
		System.out.println("Total Reliability:\t" + totalReliability);

		this.numberOfHop = constructedTree.size() - 1;
		this.reliability = totalReliability;
		this.finalTree = constructedTree;
		}else{
			System.out.println("No enough available resource.");
		}
	}

	private double findReliability(List<Vertex> constructedTree,int BW) {

		double reliability = 1.;

		for (int i = 0; i < constructedTree.size(); i++) {

//			System.out.println("Parent of " + constructedTree.get(i) + ":\t" + constructedTree.get(i).parent);

			if (constructedTree.get(i).parent != null) {
				Vertex parent = constructedTree.get(i).parent;
//				System.out.println("Vertex:\t" + constructedTree.get(i) + "\t Parent:\t" + parent);

				for (Edge edge : parent.adjacencies) {
					if (edge.target.name == constructedTree.get(i).name) {

//						System.out.println(
//								"Edge[" + parent + "," + constructedTree.get(i) + "] Reliability:" + edge.reliability);
//						reliability = reliability * edge.reliability;
						reliability = reliability * edge.reliability*(1.0-(.15)*((double)BW/edge.bandWidth));

					}
				}

			}

		}

		return reliability;
	}

	private List<Vertex> findTree(Vertex startPoint, int[] is) {
		List<Vertex> tree = new ArrayList<Vertex>();

		int CPU = is[0] - startPoint.CPU;
		// int CPU = 120 - startPoint.CPU;
		int BW = is[1];
		this.bandwidth = BW;
		System.out.println(CPU + "\t" + BW + "\t" + startPoint);

		List<Vertex> neighbors = new ArrayList<Vertex>();

		neighbors = addNeighbors(startPoint, neighbors, tree, BW);

//		System.out.println("Neighbors:\t" + Arrays.toString(neighbors.toArray()));

		tree.add(startPoint);

		while (CPU > 0) {
			Vertex node = findHighestNeighbor(neighbors);
//			System.out.println("Current highest neighbors:\t" + node);

			CPU -= node.CPU;
			tree.add(node);

//			System.out.println("Current tree:\t" + Arrays.toString(tree.toArray()));

			List<Vertex> temp = addNeighbors(node, neighbors, tree, BW);

			if (temp == null) {
				return null;
			}
			
			neighbors.clear();
			neighbors.addAll(temp);
			neighbors = removeUsedNeighbor(node, neighbors);

//			System.out.println("Neighbors:\t" + Arrays.toString(neighbors.toArray()));
//			System.out.println("CPU:\t" + CPU);
		}

		return tree;
	}

	private List<Vertex> removeUsedNeighbor(Vertex node, List<Vertex> neighbors) {

		for (int i = 0; i < neighbors.size(); i++) {
			if (node.name == neighbors.get(i).name) {
				neighbors.remove(i);
			}
		}

		return neighbors;
	}

	private Vertex findHighestNeighbor(List<Vertex> neighbors) {
		double max = Double.MIN_VALUE;

		Vertex highestNeighbors = new Vertex(Integer.MIN_VALUE);

		for (Vertex vertex : neighbors) {

			Vertex parent = vertex.parent;

			for (Edge edge : parent.adjacencies) {
				if (edge.target.name == vertex.name && edge.reliability > max) {
					highestNeighbors = edge.target;
					max = edge.reliability;
				}
			}

		}


		return highestNeighbors;
	}

	private List<Vertex> addNeighbors(Vertex startPoint, List<Vertex> neighbors, List<Vertex> tree, int BW) {
		List<Vertex> adjacentNodes = new ArrayList<Vertex>();

		// System.out.println("--Neighbors:\t" +
		// Arrays.toString(neighbors.toArray()));
		// System.out.println(startPoint + " edges:\t" +
		// Arrays.toString(startPoint.adjacencies.toArray()));

		// for (Vertex vertex : neighbors) {
		// adjacentNodes.add(vertex);
		// }

		adjacentNodes.addAll(neighbors);
		
		if (startPoint.adjacencies == null) {
			return null;
		}

		for (Edge edge : startPoint.adjacencies) {

			// System.out.println("Target:\t" + edge.target);

			if (BW <= edge.bandWidth) {
				boolean flag = true;

				for (Vertex vertex : neighbors) {

					if (edge.target.name == vertex.name) {
						flag = false;
					}
				}

				for (Vertex vertex : tree) {
					if (edge.target.name == vertex.name) {
						flag = false;
					}
				}

				if (flag) {
					adjacentNodes.add(edge.target);
					edge.target.parent = startPoint;
				}

			}
		}

		// for (
		//
		// int i = 0; i < adjacentNodes.size(); i++) {
		//
		// for (int j = i + 1; j < adjacentNodes.size(); j++) {
		//
		// if (adjacentNodes.get(i).name == adjacentNodes.get(j).name) {
		// adjacentNodes.remove(j);
		// j--;
		// }
		// }
		//
		// }
		//
		// for (int i = 0; i < tree.size(); i++) {
		//
		// for (int j = 0; j < adjacentNodes.size(); j++) {
		//
		// if (tree.get(i).name == adjacentNodes.get(j).name) {
		// adjacentNodes.remove(j);
		// j--;
		// }
		//
		// }
		// }

		return adjacentNodes;
	}

	private List<Vertex> sortVertices(List<Vertex> substrate) {

		SortReliability sortObj = new SortReliability();

		List<Vertex> sortedList = sortObj.sortList(substrate);
		return sortedList;
	}

	public double getReliability() {
		return this.reliability;
	}

	public int getHop() {
		return this.numberOfHop;
	}
	
	public List<Vertex> getTree(){
		return this.finalTree;
	}
}
