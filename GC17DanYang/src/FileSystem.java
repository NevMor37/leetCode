import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileSystem {

	private String fileName;
	private ArrayList<String> fileRows;

	public FileSystem(String file) {
		fileName = file;
		fileRows = new ArrayList<String>();
		readFile(fileName);
	}

	public void readFile(String fileName) {

		// ArrayList<String> adjMatrixRows = new ArrayList<String>();

		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				fileRows.add(line);
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}

	}

	public void writeFile(String fileName, String temp) {

		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Note that write() does not automatically
			// append a newline character.
			bufferedWriter.write(temp);

			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}
	public ArrayList<String> getFileRows(){
		return fileRows;
	}
	public int[][] getAdjMatrix() {

		int[][] adjMatrix = findMatrix(fileRows, 0);

		return adjMatrix;
	}

	public int[][] getBandwidthMatrix() {

		int[][] linkMatrix = findMatrix(fileRows, 1);

		return linkMatrix;
	}

	public int[][] getSubcarrier() {

		int[][] subcarrierMatrix = findMatrix(fileRows, 2);

		return subcarrierMatrix;
	}

	public int[][] getResourceMatrix() {

		int[][] resourceMatrix = findMatrix(fileRows, 3);

		return resourceMatrix;
	}

	public int[][] findMatrix(ArrayList<String> fileRows, int type) {

		int[][] temp;
		String row[];
		int start;

		switch (type) {
		case 0: {
			temp = new int[fileRows.size() / 4][fileRows.size() / 4];
			row = new String[fileRows.size() / 4];
			start = type * fileRows.size() / 4;
			break;
		}
		case 1: {
			temp = new int[fileRows.size() / 4][fileRows.size() / 4];
			row = new String[fileRows.size() / 4];
			start = type * fileRows.size() / 4 + 1;
			break;
		}
		case 2: {
			temp = new int[fileRows.size() / 4][fileRows.size() / 4];
			row = new String[fileRows.size() / 4];
			start = type * fileRows.size() / 4 + 1;
			break;
		}
		case 3: {
			temp = new int[fileRows.size() / 4][2];
			row = new String[2];
			start = type * fileRows.size() / 4 + 1;
			break;
		}
		default: {
			temp = null;
			row = null;
			start = 0;
			break;
		}
		}

		for (int i = start; i < start + fileRows.size() / 3; i++) {
			if (fileRows.get(i).length() != 0) {

				row = fileRows.get(i).split(":");

				for (int j = 0; j < row.length; j++) {
					temp[i - start][j] = Integer.valueOf(row[j]);

				}

			}
		}

		return temp;
	}

}