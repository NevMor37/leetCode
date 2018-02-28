package graphGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Substrate_BCR {

	private int vertex;
	private int edge;
	private String fileName;

	private int[][] weightedAdjacencyMatrix;
	private int[][] vertexCPURAM;
	private int[][] edgeCapacity;
	private int[][] startingIndex;

	private static List<String> node;

	public Substrate_BCR() {
		System.out.println("Substrate DBMOVNE files have been created.");

	}

	public void Substrate(String fName, int spectrum,int copy) {

		this.vertex = getNumberOfVertices(fName);
		this.edge = getNumberOfEdges(fName);
		this.weightedAdjacencyMatrix = getAdjMatrixFromFile(fName);
		
		String entryName[] = fName.split("\\.");
		
		for (int run = 1; run <= copy; run++) {

			// this.weightedAdjacencyMatrix = new int[vertex][vertex];
			this.vertexCPURAM = new int[vertex][2];
			this.edgeCapacity = new int[vertex][vertex];
			this.startingIndex = new int[vertex][vertex];

			// setLinkWeight(5, 15);
			setLinkCapacity(30, spectrum);
			setSubcarrier(spectrum);
			setVertexResource(5, 35);
			setLinkReliability();

			fileName = "substrate_"+entryName[0]+"_BCR_" + vertex + "_" + edge + "_" + run + ".txt";
			FileSystem file = new FileSystem(fileName);
			file.writeFile(fileName, allMatrices());

			// Show the output of all matrices
			System.out.println(showMatrices());

		}
		System.out.println("Substrate network has been generated.");

	}

	private void setLinkReliability() {
		
		Random randValue = new Random();

		for (int i = 0; i < weightedAdjacencyMatrix.length; i++) {
			for (int j = i + 1; j < weightedAdjacencyMatrix[i].length; j++) {
				if (i != j && weightedAdjacencyMatrix[i][j] != 0) {
					weightedAdjacencyMatrix[i][j] = randValue.nextInt(15) + 85;
					weightedAdjacencyMatrix[j][i] = weightedAdjacencyMatrix[i][j];
				}
			}
		}
		
	}

	private int[][] getAdjMatrixFromFile(String fName) {
		
		FileSystem fObj = new FileSystem(fName);
		
		List<String> lines = fObj.getFileRows();
		
		int[][] adjMatrix = new int[lines.size()][lines.size()];
		
		for (int i = 0; i < adjMatrix.length; i++) {
			
			String temp[] = lines.get(i).split("\t");
			
			for (int j = 0; j < adjMatrix.length; j++) {
				adjMatrix[i][j] = Integer.parseInt(temp[j]);
			}
			
		}
		
		
		return adjMatrix;
	}

	private int getNumberOfEdges(String fName) {
		
		FileSystem fObj = new FileSystem(fName);
		
		List<String> lines = fObj.getFileRows();
		
		int edgeCounter = 0;
		
		for (int i = 0; i < lines.size(); i++) {
			
			String temp[] = lines.get(i).split("\t");
			
			for (int j = i+1; j < temp.length; j++) {
				
				if (Integer.parseInt(temp[j])!=0) {
					edgeCounter++;
				}
			}
			
		}
		
		lines.clear();
		
		return edgeCounter;
	}

	private int getNumberOfVertices(String fName) {
		
		FileSystem fObj = new FileSystem(fName);
		
		return fObj.getFileRows().size();
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

	private void setSubcarrier(int s) {
		Random randValue = new Random();

		for (int i = 0; i < weightedAdjacencyMatrix.length; i++) {
			for (int j = i + 1; j < weightedAdjacencyMatrix[i].length; j++) {
				if (i != j && weightedAdjacencyMatrix[i][j] != 0) {
					startingIndex[i][j] = randValue.nextInt(s - edgeCapacity[i][j] + 1);
					startingIndex[j][i] = startingIndex[i][j];
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
			// We change RAM as reliability factor
//			vertexCPURAM[i][1] = randValue.nextInt(max - min + 1) + min;
			vertexCPURAM[i][1] = randValue.nextInt(10) + 90;

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

		for (int i = 0; i < startingIndex.length; i++) {
			temp += startingIndex[i][0];
			for (int j = 1; j < startingIndex[i].length; j++) {
				temp += ":" + startingIndex[i][j];
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
