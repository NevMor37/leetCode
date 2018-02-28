package graphGenerator;
import java.util.ArrayList;
import java.util.List;

public class Virtual_BCR {
	
	public Virtual_BCR() {
		System.out.println("Virtual Multicast Tree- BCR has been started:");

	}

	public List<int[]> createRequestList(int minCPU, int maxCPU, int range) {

		
		List<int[]> request = new ArrayList<int[]>();
		
		for (int i = minCPU; i <=maxCPU; i+=range) {
			
			for (int j = 5; j <= 25 ; j+=5) {
				int[] tempRequest = new int[2];
				tempRequest[0] = i;
				tempRequest[1] = j;
				request.add(tempRequest);
			}
			
		}
	
		return request;

	}

}
