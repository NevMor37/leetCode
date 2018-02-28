package topologyGenerator;


import java.util.ArrayList;
import java.util.List;

public class GenerateVertex {

	public List<Vertex> setVertices(String fileName) {

		
		List<Vertex> list = new ArrayList<Vertex>();
		Vertex[] vertices;
		try {
			vertices = getVertex(fileName);
			for (Vertex vertex : vertices) {
				list.add(vertex);

			}

		} catch (Exception e) {
			System.err.println(e.toString());
		}

		return list;
	}

	private Vertex[] getVertex(String fileName) {
		FileSystem file = new FileSystem(fileName);
		int[][] adjMatrix = file.getAdjMatrix();
		int[][] adjBWMatrix = file.getBandwidthMatrix();
		int[][] adjSubcarrier = file.getSubcarrier();
		int[][] resourceMatrix = file.getResourceMatrix();
		Edge temp;
		Vertex[] vertices = new Vertex[adjMatrix.length];
		// Define all vertex variables as Vertex object
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vertex(i);
			vertices[i].CPU = resourceMatrix[i][0];
			vertices[i].originalCPU = resourceMatrix[i][0];
			vertices[i].RAM = 0.0;
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
					temp = new Edge(vertices[i], vertices[j], (adjMatrix[i][j]/100.0));
//					temp.bandWidth = adjBWMatrix[i][j];
					temp.setBW(adjBWMatrix[i][j],adjSubcarrier[i][j]);
					edge.add(temp);
				}
			}
			vertices[i].adjacencies = edge;
			// System.out.println("=========================================");

		}

		return vertices;
	}

}
