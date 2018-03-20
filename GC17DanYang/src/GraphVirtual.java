import java.util.Random;

public class GraphVirtual {

	private String fileName;

	private int[][] weightedAdjacencyMatrix;
	private int[][] vertexCPURAM;
	private int[][] edgeCapacity;

	public GraphVirtual() {
		System.out.println("Virtual Graph has been started:");

	}

	public void Virtual(int BW, int CPU, int[] node, int copy) {

		for (int run = 1; run <= copy; run++) {

			for (int vertex = node[0]; vertex <= node[1]; vertex++) {

				// int edge = vertex - 1;
				this.weightedAdjacencyMatrix = new int[vertex][vertex];
				this.vertexCPURAM = new int[vertex][2];
				this.edgeCapacity = new int[vertex][vertex];

				// setLinkWeight(1, 1);
				weightedAdjacencyMatrix = treeMatrix(vertex);
				setLinkCapacity(BW, BW);
				setVertexResource(CPU, CPU);

				fileName = "virtual_" + vertex + "_" + CPU + "_" + BW + "_" + run + ".txt";
				FileSystem file = new FileSystem(fileName);
				file.writeFile(fileName, allMatrices());

				System.out.println("virtual_" + vertex + "_" + CPU + "_" + BW + "_" + run + ".txt");

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

	public static int GR(int n) {
		Random R = new Random();
		int a = R.nextInt(n);
		return a;
	}

	public static int[][] treeMatrix(int n) {
		int adj[][] = new int[n][n];
		int i;
		for (int j = 1; j < n; j++) {
			i = GR(j);
			adj[i][j] = 1;
			adj[j][i] = 1;
		}
		return adj;
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
}
