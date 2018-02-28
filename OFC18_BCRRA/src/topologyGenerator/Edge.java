package topologyGenerator;

public class Edge {
	public final Vertex start;
	public final Vertex target;
	public final double weight;
	public int startIndex;
	public int bandWidth;
	public int endIndex;
	public double reliability;

	public Edge(Vertex argStart, Vertex argTarget, double argWeight) {
		start = argStart;
		target = argTarget;
//		weight = argWeight;
		weight = 1.0;
		bandWidth = 0;
		startIndex = 0;
		endIndex = 45;
		reliability = argWeight;
	}

	public void setBW(int bw, int start) {
		bandWidth = bw;
		this.startIndex = start;

		this.endIndex = this.startIndex + bw - 1;
	}

	public String toString() {
		return "-->" + target.toString();
	}

}