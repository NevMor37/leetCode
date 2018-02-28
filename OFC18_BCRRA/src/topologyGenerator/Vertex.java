package topologyGenerator;


import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
	public final int name;
	public ArrayList<Edge> adjacencies;
	public double minDistance = Double.NEGATIVE_INFINITY;
	public Vertex previous;
	public int CPU;
	public int originalCPU;
	public double RAM;
//	public Vertex parent;
//	public Vertex child;
	private ArrayList<Vertex> parent;
	private ArrayList<Vertex> child;

	public Vertex(int argName) {
		name = argName;
	}

	public String toString() {
		
		return String.valueOf(name);
	}

	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}

	public void setCPU(int cpu) {
		CPU = cpu;
	}

}