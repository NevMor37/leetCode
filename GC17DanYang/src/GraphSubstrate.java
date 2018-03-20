import java.util.List;
import java.util.Random;

public class GraphSubstrate {

	private int vertex;
	private int edge;
	private String fileName;

	private int[][] weightedAdjacencyMatrix;
	private int[][] vertexCPURAM;
	private int[][] edgeCapacity;

	public GraphSubstrate(String fileName) {

		System.out.println("Graph Substrate Copy Obj has been created.");

		getAdjMatrixFromFile(fileName);

		vertex = weightedAdjacencyMatrix.length;

	}

	public void Substrate(int[] bw, int[] cpu, int copy) {

		for (int run = 1; run <= copy; run++) {

			this.vertexCPURAM = new int[vertex][2];
			this.edgeCapacity = new int[vertex][vertex];

			setLinkCapacity(bw[0], bw[1]);
			setVertexResource(cpu[0], cpu[1]);

			fileName = "substrate_" + vertex + "_" + edge + "_" + run + ".txt";
			FileSystem file = new FileSystem(fileName);
			file.writeFile(fileName, allMatrices());

		}
		System.out.println("Substrate network has been generated.");

	}

	public void getAdjMatrixFromFile(String fileName) {

		FileSystem file = new FileSystem(fileName);

		List<String> rows = file.getFileRows();

		int[][] adjMatrix = new int[rows.size()][rows.size()];

		int edgeCounter = 0;

		for (int i = 0; i < adjMatrix.length - 1; i++) {

			String[] temp = rows.get(i).split(":");

			for (int j = i + 1; j < adjMatrix[i].length; j++) {

				if (Integer.parseInt(temp[j]) == 0) {
					adjMatrix[i][j] = 0;
					adjMatrix[j][i] = 0;
				} else {
					adjMatrix[i][j] = 1;
					adjMatrix[j][i] = 1;
					edgeCounter++;
				}

			}
		}

		this.weightedAdjacencyMatrix = adjMatrix;
		this.edge = edgeCounter;
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
		int range = (max - min) + 1;
		for (int i = 0; i < vertexCPURAM.length; i++) {

			// Define the CPU Capacity
			vertexCPURAM[i][0] = (randValue.nextInt(range) + 1) + min;
			// Define the RAM Capacity
			vertexCPURAM[i][1] = (randValue.nextInt(range) + 1) * 5;

		}
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
