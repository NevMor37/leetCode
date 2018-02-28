package topologyGenerator;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> substrateFiles = readAllFiles.substrateFileName();
		
		GenerateVertex vertices = new GenerateVertex();
		
		List<Vertex> substrateVertices;
		
		for (String string : substrateFiles) {
			
			substrateVertices = vertices.setVertices(string);
			for (Vertex vertex : substrateVertices) {
				System.out.print(vertex+"\t");
				for (Edge edge : vertex.adjacencies) {
					System.out.print(edge+":"+edge.reliability+"\t");
				}
				System.out.println();
			}
			System.out.println("====================");
		}
		
	}

}
