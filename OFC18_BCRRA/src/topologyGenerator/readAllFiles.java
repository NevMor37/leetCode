package topologyGenerator;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class readAllFiles {

	public static void readTopologies() throws IOException {
		String target_dir = "./";
		File dir = new File(target_dir);
		File[] files = dir.listFiles();

		int counter = 0;

		for (File f : files) {

			System.out.println("FileName:" + f.getName());

			if (f.isFile() && f.getName().contains("substrate")) {
				BufferedReader inputStream = null;
				try {
					inputStream = new BufferedReader(new FileReader(f));
					String line;

					while ((line = inputStream.readLine()) != null) {
						System.out.println(line);
					}
				} finally {
					if (inputStream != null) {
						inputStream.close();
					}
				}

				counter++;
			}

		}

		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println("Directory file size = " + files.length);
		System.out.println("Counter = " + counter);
	}

	public static List<String> substrateFileName() {
		String target_dir = "./";
		File dir = new File(target_dir);
		File[] files = dir.listFiles();

		List<String> fileNames = new ArrayList<String>();

		for (File f : files) {

			if (f.isFile() && f.getName().contains("substrate")) {
				fileNames.add(f.getName());
			}
		}

		return fileNames;
	}
	public static List<String> virtualFileName() {
		String target_dir = "./";
		File dir = new File(target_dir);
		File[] files = dir.listFiles();

		List<String> fileNames = new ArrayList<String>();

		for (File f : files) {

			if (f.isFile() && f.getName().contains("virtual")) {
				fileNames.add(f.getName());
			}
		}

		return fileNames;
	}
	
	public static void removeAllFiles() {
		String target_dir = "./";
		File dir = new File(target_dir);
		File[] files = dir.listFiles();

		List<String> fileNames = new ArrayList<String>();

		for (int i = 0; i < files.length; i++) {
			
			if (files[i].isFile()) {
				files[i].delete();
			}
		}
	}
}