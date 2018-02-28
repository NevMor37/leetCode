package testPackage;

import topologyGenerator.Edge;
import topologyGenerator.Vertex;

import java.util.ArrayList;
import java.util.List;

public class SortRB {

	public List<Vertex> kMaxVertices(List<Vertex> substrate, double[] rb, int k){

		List<Vertex> maxNodes = new ArrayList<Vertex>();

		for (int i =0; i<k; i++){

			double max = .0;
			int savedIndex = -1;

			for (int j=0; j<rb.length;j++){

				if (rb[j]>max){
					max= rb[j];
					savedIndex = j;
				}

			}


			maxNodes.add(substrate.get(savedIndex));
			rb[savedIndex] = .0;

		}


		return maxNodes;
	}

}
