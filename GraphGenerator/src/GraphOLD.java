import java.util.Random;

public class GraphOLD {

	private int vertex;
	private int edge;
	private String fileName;

	private int[][] weightedAdjacencyMatrix;
	private int[][] vertexCPURAM;
	private int[][] edgeCapacity;

	public GraphOLD() {

		System.out.println("Graph Obj has been created.");

	}

	public void Substrate() {

		for (int vertex = 20; vertex <= 40; vertex += 10) {
			for (int edge = 2 * vertex; edge < vertex * (vertex - 1) / 2; edge += 10) {

				this.vertex = vertex;
				this.edge = edge;

				this.weightedAdjacencyMatrix = new int[vertex][vertex];
				this.vertexCPURAM = new int[vertex][2];
				this.edgeCapacity = new int[vertex][vertex];

				setLinkWeight(5, 15);
				setLinkCapacity(25, 45);
				setVertexResource(15, 35);

				fileName = "substrate_" + vertex + "_" + edge + ".txt";
				FileSystem.writeFile(fileName, allMatrices());

				// Show the output of all matrices
				// System.out.println(showMatrices());

			}
		}

	}

	public void Virtual() {

		for (int vertex = 3; vertex <= 7; vertex++) {
			for (int edge = vertex - 1; edge < vertex * (vertex - 1) / 2; edge += 2) {

				this.vertex = vertex;
				this.edge = edge;

				this.weightedAdjacencyMatrix = new int[vertex][vertex];
				this.vertexCPURAM = new int[vertex][2];
				this.edgeCapacity = new int[vertex][vertex];

				setLinkWeight(1, 1);
				setLinkCapacity(5, 10);
				setVertexResource(5, 10);

				fileName = "virtual_" + vertex + "_" + edge + ".txt";
				FileSystem.writeFile(fileName, allMatrices());

				// Show the output of all matrices
				// System.out.println(showMatrices());

			}
		}

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

		for (int i = 0; i < vertexCPURAM.length; i++) {

			// Define the CPU Capacity
			vertexCPURAM[i][0] = randValue.nextInt(max - min + 1) + min;
			// Define the RAM Capacity
			vertexCPURAM[i][1] = randValue.nextInt(max - min + 1) + min;

		}
	}

	private void setLinkWeight(int start, int end) {

		Random randValue = new Random();
		int count = 0;
		int column;
		int row;

		do {
			column = randValue.nextInt(vertex);
			row = randValue.nextInt(vertex);
			if (row != column && weightedAdjacencyMatrix[row][column] == 0
					&& weightedAdjacencyMatrix[column][row] == 0) {
				weightedAdjacencyMatrix[row][column] = randValue.nextInt(end - start + 1) + start;
				weightedAdjacencyMatrix[column][row] = weightedAdjacencyMatrix[row][column];
				count++;
			}
		} while (count < edge);

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
