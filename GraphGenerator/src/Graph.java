import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Graph {

	private int vertex;
	private int edge;
	private String fileName;

	private int[][] weightedAdjacencyMatrix;
	private int[][] vertexCPURAM;
	private int[][] edgeCapacity;

	private static List<String> node;

	public Graph() {

		System.out.println("Graph Obj has been created.");

	}

	public void Substrate() {

		for (int vertex = 30; vertex <= 30; vertex += 10) {
			for (int edge = 2 * vertex; edge < vertex * (vertex - 1) / 2; edge += 10) {

				this.vertex = vertex;
				this.edge = edge;

				this.weightedAdjacencyMatrix = new int[vertex][vertex];
				this.vertexCPURAM = new int[vertex][2];
				this.edgeCapacity = new int[vertex][vertex];

				setLinkWeight(5, 15);
				setLinkCapacity(15, 45);
				setVertexResource(5, 35);

				fileName = "substrate_" + vertex + "_" + edge + ".txt";
				FileSystem.writeFile(fileName, allMatrices());

				// Show the output of all matrices
				// System.out.println(showMatrices());

			}
		}

	}

	public void Virtual() {

		for (int vertex = 4; vertex <= 7; vertex++) {
			for (int edge = vertex - 1; edge < vertex * (vertex - 1) / 2; edge += 2) {

				this.vertex = vertex;
				this.edge = edge;

				this.weightedAdjacencyMatrix = new int[vertex][vertex];
				this.vertexCPURAM = new int[vertex][2];
				this.edgeCapacity = new int[vertex][vertex];

				setLinkWeight(1, 1);
				setLinkCapacity(10, 35);
				setVertexResource(5, 25);

				fileName = "virtual_" + vertex + "_" + edge + ".txt";
				FileSystem.writeFile(fileName, allMatrices());

				// Show the output of all matrices
				// System.out.println(showMatrices());

			}
		}

	}

	public void Virtual(int BW) {

		for (int vertex = 5; vertex <= 7; vertex++) {
			for (int edge = vertex - 1; edge < vertex * (vertex - 1) / 2; edge += 2) {

				this.vertex = vertex;
				this.edge = edge;

				this.weightedAdjacencyMatrix = new int[vertex][vertex];
				this.vertexCPURAM = new int[vertex][2];
				this.edgeCapacity = new int[vertex][vertex];

				setLinkWeight(1, 1);
				setLinkCapacity(BW, BW);
				setVertexResource(5, 15);

				fileName = "virtual_" + vertex + "_" + edge + "_" + BW + ".txt";
				FileSystem.writeFile(fileName, allMatrices());

				// Show the output of all matrices
				// System.out.println(showMatrices());

			}
		}

	}
	
	public void Virtual(int nVertex,int nEdge,int BW) {

//		for (int vertex = 5; vertex <= 7; vertex++) {
//			for (int edge = vertex - 1; edge < vertex * (vertex - 1) / 2; edge += 2) {

				this.vertex = nVertex;
				this.edge = nEdge;

				this.weightedAdjacencyMatrix = new int[vertex][vertex];
				this.vertexCPURAM = new int[vertex][2];
				this.edgeCapacity = new int[vertex][vertex];

				setLinkWeight(1, 1);
				setLinkCapacity(BW, BW);
				setVertexResource(5, 25);

				fileName = "virtual_" + vertex + "_" + edge + "_" + BW + ".txt";
				FileSystem.writeFile(fileName, allMatrices());

				// Show the output of all matrices
				// System.out.println(showMatrices());

//			}
//		}

	}
	public void Virtual(int nVertex,int nEdge, String run) {

//		for (int vertex = 5; vertex <= 7; vertex++) {
//			for (int edge = vertex - 1; edge < vertex * (vertex - 1) / 2; edge += 2) {

				this.vertex = nVertex;
				this.edge = nEdge;

				this.weightedAdjacencyMatrix = new int[vertex][vertex];
				this.vertexCPURAM = new int[vertex][2];
				this.edgeCapacity = new int[vertex][vertex];

				setLinkWeight(1, 1);
				setLinkCapacity(10,35);
				setVertexResource(5, 25);

				fileName = "virtual_" + vertex + "_" + edge + "_R"+run +".txt";
				FileSystem.writeFile(fileName, allMatrices());

				// Show the output of all matrices
				// System.out.println(showMatrices());

//			}
//		}

	}
	
	public void Substrate(int nVertex, int nEdge) {

//		for (int vertex = 30; vertex <= 30; vertex += 10) {
//			for (int edge = 2 * vertex; edge < vertex * (vertex - 1) / 2; edge += 10) {

				this.vertex = nVertex;
				this.edge = nEdge;

				this.weightedAdjacencyMatrix = new int[vertex][vertex];
				this.vertexCPURAM = new int[vertex][2];
				this.edgeCapacity = new int[vertex][vertex];

				setLinkWeight(5, 15);
				setLinkCapacity(15, 45);
				setVertexResource(5, 35);

				fileName = "substrate_" + vertex + "_" + edge + ".txt";
				FileSystem.writeFile(fileName, allMatrices());

				// Show the output of all matrices
				// System.out.println(showMatrices());

//			}
//		}

	}


	private void setLinkCapacity(int min, int max) {
		Random randValue = new Random();

		for (int i = 0; i < weightedAdjacencyMatrix.length; i++) {
			for (int j = i + 1; j < weightedAdjacencyMatrix[i].length; j++) {
				if (i != j && weightedAdjacencyMatrix[i][j] != 0) {
					edgeCapacity[i][j] = randValue.nextInt(max - min + 1) + min;
					edgeCapacity[j][i] = edgeCapacity[i][j];
				}
			}
		}

	}

	private void setVertexResource(int min, int max) {
		Random randValue = new Random();
		
		ArrayList<Integer> functionList = new ArrayList<Integer>();
		for(int i=0; i < vertexCPURAM.length; i++){
			functionList.add(i);
		}
		Collections.shuffle(functionList);

		for (int i = 0; i < vertexCPURAM.length; i++) {

			// Define the CPU Capacity
			vertexCPURAM[i][0] = randValue.nextInt(max - min + 1) + min;
			// Define the RAM Capacity
//			vertexCPURAM[i][1] = randValue.nextInt(max - min + 1) + min;
			vertexCPURAM[i][1] = functionList.get(i);

		}
	}

	private void setLinkWeight(int start, int end) {

		Random randValue = new Random();
		int count = 0;
		int column;
		int row;

		node = new ArrayList<String>();
		for (int i = 0; i < weightedAdjacencyMatrix.length; i++) {
			node.add("" + i);
		}
		Collections.shuffle(node);
		// System.out.println(Arrays.toString(node.toArray()));

		do {

			if (node.size() != 0) {
				int[] nodeNumber = getNodeNumbers(node);
				row = nodeNumber[0];
				column = nodeNumber[1];
			} else {

				row = randValue.nextInt(vertex);
				column = randValue.nextInt(vertex);
			}
			// column = randValue.nextInt(vertex);
			// row = randValue.nextInt(vertex);
			if (row != column && weightedAdjacencyMatrix[row][column] == 0
					&& weightedAdjacencyMatrix[column][row] == 0) {
				weightedAdjacencyMatrix[row][column] = randValue.nextInt(end - start + 1) + start;
				weightedAdjacencyMatrix[column][row] = weightedAdjacencyMatrix[row][column];
				count++;
			}
		} while (count < edge);

	}

	private int[] getNodeNumbers(List<String> node) {

		Random rnd = new Random();

		int row, column;

		int first, second;

		if (node.size() > 1) {

			// System.out.println("Size of node:"+node.size());
			first = rnd.nextInt(node.size());
			// System.out.println("First:"+first);

			row = Integer.parseInt(node.get(first));
			node.remove(first);

			// System.out.println("Size of node:"+node.size());
			second = rnd.nextInt(node.size());
			// System.out.println("Second:"+second);

			column = Integer.parseInt(node.get(second));
			node.remove(second);
		} else {
			row = Integer.parseInt(node.get(0));
			column = rnd.nextInt(vertex);
			node.remove(0);
		}

		int[] nodeNumber = { row, column };

		return nodeNumber;
	}

	public int[][] getAdjacencyMatrix() {
		return weightedAdjacencyMatrix;
	}

	private String allMatrices() {
		String temp = "";
		for (int i = 0; i < weightedAdjacencyMatrix.length; i++) {
			temp += weightedAdjacencyMatrix[i][0];
			for (int j = 1; j < weightedAdjacencyMatrix[i].length; j++) {
				temp += ":" + weightedAdjacencyMatrix[i][j];
			}
			temp += "\n";
		}

		temp += "\n";

		for (int i = 0; i < edgeCapacity.length; i++) {
			temp += edgeCapacity[i][0];
			for (int j = 1; j < edgeCapacity[i].length; j++) {
				temp += ":" + edgeCapacity[i][j];
			}
			temp += "\n";
		}
		temp += "\n";

		for (int i = 0; i < vertexCPURAM.length; i++) {
			temp += vertexCPURAM[i][0] + ":" + vertexCPURAM[i][1] + "\n";
		}

		return temp;
	}

	private String showMatrices() {
		String temp = "Weighted Adjacency Matrix:\n";
		for (int i = 0; i < weightedAdjacencyMatrix.length; i++) {
			temp += weightedAdjacencyMatrix[i][0];
			for (int j = 1; j < weightedAdjacencyMatrix[i].length; j++) {
				temp += "\t" + weightedAdjacencyMatrix[i][j];
			}
			temp += "\n";
		}

		temp += "\n";
		temp += "Bandwidth Capacities of each edge:\n";

		for (int i = 0; i < edgeCapacity.length; i++) {
			temp += edgeCapacity[i][0];
			for (int j = 1; j < edgeCapacity[i].length; j++) {
				temp += "\t" + edgeCapacity[i][j];
			}
			temp += "\n";
		}
		temp += "\n";
		temp += "CPU and RAM Capacities of each vertez:\n";

		for (int i = 0; i < vertexCPURAM.length; i++) {
			temp += vertexCPURAM[i][0] + "\t" + vertexCPURAM[i][1] + "\n";
		}

		return temp;

	}

}
