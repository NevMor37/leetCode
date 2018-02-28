package testPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import graphGenerator.Virtual_BCR;
import topologyGenerator.*;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		List<String> substrateFile = readAllFiles.substrateFileName();
		DecimalFormat myFormatter = new DecimalFormat("#.####");
		GenerateVertex sGraph = new GenerateVertex();
		Virtual_BCR vRequest = new Virtual_BCR();
		List<int[]> request = vRequest.createRequestList(100, 200, 20);

		FileWriter fileWriter = new FileWriter("SimulationResults.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		for (String fileName : substrateFile) {
			List<Vertex> substrate = sGraph.setVertices(fileName);
			showNetworkTopology(substrate);

			for (int i = 0; i < request.size(); i++) {

				int[] requestValue = request.get(i);

				AlgoCupa cupaObj = new AlgoCupa();
				cupaObj.nodeMapping(fileName, requestValue);
				double reliabilityCupa = cupaObj.getReliability();
				int hopCupa = cupaObj.getHop();
				List<Vertex> treeCupa = cupaObj.getTree();

				System.out.println("CUPA============================================");
				AlgoRPA rpaObj = new AlgoRPA();
				rpaObj.nodeMapping(fileName, requestValue);
				double reliabilityRpa = rpaObj.getReliability();
				int hopRpa = rpaObj.getHop();
				List<Vertex> treeRpa = rpaObj.getTree();
				

				System.out.println("RPA============================================");
//				AlgoRPS rpsObj = new AlgoRPS();
//				rpsObj.nodeMapping(fileName, requestValue);
//				double reliabilityRps = rpsObj.getReliability();
//				int hopRps = rpsObj.getHop();
//				List<Vertex> treeRps = rpsObj.getTree();
//
//				System.out.println("RPS============================================");
				AlgoNew rpsObj = new AlgoNew();
				rpsObj.nodeMapping(fileName, requestValue,3);
				double reliabilityRps = rpsObj.getReliability();
				int hopRps = rpsObj.getHop();
				List<Vertex> treeRps = rpsObj.getTree();

				System.out.println("RPSNEW============================================");

				
				String oTreeCupa = "";
				if (treeCupa!=null) {
					oTreeCupa = Arrays.toString(treeCupa.toArray());
				}
				String oTreeRpa = "";
				if (treeRpa!=null) {
					oTreeRpa = Arrays.toString(treeRpa.toArray());
				}
				String oTreeRps = "";
				if (treeRps!=null) {
					oTreeRps = Arrays.toString(treeRps.toArray());
				}
				
				System.out.printf("Cupa:\tHop:%d\tReliability:%.3f\tTree:%s", hopCupa, reliabilityCupa,
						oTreeCupa);
				System.out.printf("RPA:\tHop:%d\tReliability:%.3f\tTree:%s", hopRpa, reliabilityRpa,
						oTreeRpa);
				System.out.printf("RPS:\tHop:%d\tReliability:%.3f\tTree:%s", hopRps, reliabilityRps,
						oTreeRps);

				System.out.println(hopCupa + "\t" + myFormatter.format(reliabilityCupa) + "\t" + hopRpa + "\t" + myFormatter.format(reliabilityRpa)+"\t" + hopRps + "\t"
						+ myFormatter.format(reliabilityRps) + "\t" + oTreeCupa + "\t"
						+ oTreeRpa + "\t" + oTreeRps + "\t"
						+ requestValue[0] + "\t" + requestValue[1]);
				
				String row = hopCupa + "\t" + myFormatter.format(reliabilityCupa) + "\t" + hopRpa + "\t" + myFormatter.format(reliabilityRpa)+"\t" + hopRps + "\t"
						+ myFormatter.format(reliabilityRps) + "\t" + oTreeCupa + "\t"
						+ oTreeRpa + "\t" + oTreeRps + "\t"
						+ requestValue[0] + "\t" + requestValue[1] + "\n";
				bufferedWriter.write(row);

			}
		}

		bufferedWriter.close();

	}

	private static void showNetworkTopology(List<Vertex> substrate) {
		for (Vertex vertex : substrate) {
			System.out.print(vertex + "\t");
			for (Edge edge : vertex.adjacencies) {
				System.out.print(edge + "\t");
			}
			System.out.println();
		}
		System.out.println("====================");

	}

}
