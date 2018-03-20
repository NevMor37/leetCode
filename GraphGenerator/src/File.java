import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File {

	private static String fileName;
	private static ArrayList<String> fileRows;

	public File(String file) {
		fileName = file;
		fileRows = new ArrayList<String>();
		readFile(fileName);
	}

	public void readFile(String fileName) {

		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				fileRows.add(line);
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}

	}

	public void writeFile(String fileName, String temp) {

		try {
			FileWriter fileWriter = new FileWriter(fileName);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(temp);

			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
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

	public int[][] getResourceMatrix() {

		int[][] resourceMatrix = findMatrix(fileRows, 2);

		return resourceMatrix;
	}

	public int[][] findMatrix(ArrayList<String> fileRows, int type) {

		int[][] temp;
		String row[];
		int start;

		switch (type) {
		case 0: {
			temp = new int[fileRows.size() / 3][fileRows.size() / 3];
			row = new String[fileRows.size() / 3];
			start = type * fileRows.size() / 3;
			break;
		}
		case 1: {
			temp = new int[fileRows.size() / 3][fileRows.size() / 3];
			row = new String[fileRows.size() / 3];
			start = type * fileRows.size() / 3 + 1;
			break;
		}
		case 2: {
			temp = new int[fileRows.size() / 3][2];
			row = new String[2];
			start = type * fileRows.size() / 3 + 1;
			break;
		}
		default: {
			temp = null;
			row = null;
			start = 0;
			break;
		}
		}

		for (int i = start; i < start + fileRows.size()/3; i++) {
			if (fileRows.get(i).length() != 0) {

				row = fileRows.get(i).split("\t");

				for (int j = 0; j < row.length; j++) {
					temp[i - start][j] = Integer.valueOf(row[j]);

				}

			}
		}

		return temp;
	}

}