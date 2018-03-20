
public class GraphGenerator {

	public static void main(String[] args) {

		// GraphSubstrate substrate = new GraphSubstrate("hypercube5.txt");

		// int[] bw = {35,50};
		// int[] cpu = {35,50};

		// substrate.Substrate(bw,cpu,1);

		GraphVirtual virtualObj = new GraphVirtual();
		
		int[] node ={3,7};

		for (int bw = 5; bw <= 10; bw+=5) {

			for (int cpu = 5; cpu <=10; cpu+=5) {
				
				virtualObj.Virtual(bw, cpu,node, 1);
				
			}
		}

	}

}
