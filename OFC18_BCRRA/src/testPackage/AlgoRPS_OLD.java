package testPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import topologyGenerator.*;
import graphGenerator.*;

public class AlgoRPS_OLD {

	private Vertex endPoint = new Vertex(Integer.MIN_VALUE);
	private double reliability = 1.;
	private int numberOfHop;
	private List<Vertex> finalTree;

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

		System.out.println(Arrays.toString(constructedTree.toArray()));

		double totalReliability = this.reliability;
		System.out.println("Total Reliability:\t" + totalReliability);

		this.numberOfHop = constructedTree.size() - 1;
		this.finalTree = constructedTree;

	}

	private List<Vertex> findTree(Vertex startPoint, int[] is) {
		List<Vertex> tree = new ArrayList<Vertex>();

		startPoint.CPU = is[0] - startPoint.CPU;
		startPoint.RAM = 1.;
		startPoint.parent = null;
		// int CPU = 120 - startPoint.CPU;

		int BW = is[1];
//		System.out.println(startPoint.CPU + "\t" + BW + "\t" + startPoint.RAM + "\t" + startPoint);

		List<Vertex> neighbors = new ArrayList<Vertex>();

		neighbors = addNeighbors(startPoint, BW);

//		System.out.println("Neighbors:\t" + Arrays.toString(neighbors.toArray()));
		
//		for (int i = 0; i < neighbors.size(); i++) {
//			System.out.println("Parent of " + neighbors.get(i) + ":\t" + neighbors.get(i).parent);
//		}

		// tree.add(startPoint);
//		System.out.println("Tree:\t" + Arrays.toString(tree.toArray()));

		while (checkCPU(neighbors)) {
			// System.out.println("-------");
			neighbors = addRPSNeighbors(startPoint, neighbors, tree, BW);
		}

		this.reliability = this.endPoint.RAM;
		tree.addAll(findTreeList(this.endPoint));

		return tree;
	}

	private List<Vertex> addRPSNeighbors(Vertex start, List<Vertex> neighbors, List<Vertex> tree, int bW) {
		List<Vertex> adjacentNodes = new ArrayList<Vertex>();

		adjacentNodes.addAll(neighbors);
		System.out.println("Adjacencies:\t" + Arrays.toString(adjacentNodes.toArray()));

		for (Vertex vertex : neighbors) {

			for (Edge edge : vertex.adjacencies) {
				// System.out.println(vertex+" --> Parent: "+vertex.parent);
//				System.out.println("Vertex:" + vertex + "\tEdge Target: " + edge.target);

				if (edge.target.parent != null) {

					// int CPU = vertex.CPU - edge.target.originalCPU;
					double RAM = vertex.RAM * edge.reliability;

					if (RAM > edge.target.RAM && edge.target.name != start.name) {
						edge.target.RAM = RAM;
						edge.target.CPU = vertex.CPU - edge.target.originalCPU;

						edge.target.parent = vertex;

						boolean flag = true;
						
						for (int i = 0; i < adjacentNodes.size(); i++) {

							if (adjacentNodes.get(i).name == edge.target.name) {
								adjacentNodes.remove(i);
								adjacentNodes.add(edge.target);
								flag = false;
							}

						}
						if (flag) {
							adjacentNodes.add(edge.target);
						}

					}

				} else if (edge.target.parent == null && edge.target.name != start.name) {

					// System.out.println("-------");
					edge.target.CPU = vertex.CPU - edge.target.originalCPU;
					edge.target.RAM = vertex.RAM * edge.reliability;
					edge.target.parent = vertex;
					// System.out.println("-------2");
					adjacentNodes.add(edge.target);
				}

				System.out.println("Edge target "+edge.target+" , CPU:"+edge.target.CPU);

			}
//			System.out.println("Adjacencies:\t" + Arrays.toString(adjacentNodes.toArray()));
			System.out.println("-----------------------------------------------------------");

		}

		return adjacentNodes;
	}

	private List<Vertex> findTreeList(Vertex endPoint2) {

		List<Vertex> path = new ArrayList<Vertex>();

		while (endPoint2.parent != null) {
			path.add(endPoint2);
			endPoint2 = endPoint2.parent;
		}
		path.add(endPoint2);
		return path;
	}

	private boolean checkCPU(List<Vertex> neighbors) {

		double maxReliability = Double.MIN_VALUE;

		boolean flag = true;

//		System.out.println("Neighbors:\t" + Arrays.toString(neighbors.toArray()));

		for (Vertex vertex : neighbors) {

			System.out.println("Vertex:" + vertex + "\tCPU:" + vertex.CPU + "\tRAM:" + vertex.RAM);

			if (vertex.CPU <= 0 && vertex.RAM > maxReliability) {
				this.endPoint = vertex;
				maxReliability = vertex.RAM;
				flag = false;
			}

		}

		return flag;
	}

	private List<Vertex> addNeighbors(Vertex startPoint, int BW) {
		List<Vertex> adjacentNodes = new ArrayList<Vertex>();

		for (Edge edge : startPoint.adjacencies) {

			// System.out.println("Target:\t" + edge.target);

			if (edge.bandWidth >= BW) {

				edge.target.CPU = startPoint.CPU - edge.target.originalCPU;
				edge.target.RAM = startPoint.RAM * edge.reliability;
				edge.target.parent = startPoint;

				adjacentNodes.add(edge.target);

			}
		}

		return adjacentNodes;
	}

	private List<Vertex> sortVertices(List<Vertex> substrate) {

		SortRPS sortObj = new SortRPS();

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
