import java.util.*;
import java.io.*;
import java.lang.*;

public class randomDAG {
	private Formatter x;
	// Check if there is a cycle on addition of a new edge
	public boolean checkAcyclic(int [][]edge, int ed, int numOfVertex) {		
		if(edge.length == 0 || numOfVertex == 0) return true;
		HashMap<Integer, Integer> map= new HashMap<>();
		for(int i = 0;i<edge.length;i++){
			int temp = edge[i][0] * 10 + edge[i][1];
			if(!map.containsKey(temp)){
				map.put(temp, temp);
			}else{
				return false;
				
			}
		}
		List<List<Integer>> nodesList = new ArrayList<>(numOfVertex);
		for (int i = 0; i < numOfVertex; i++) {
			nodesList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < edge.length; i++) {
			nodesList.get(edge[i][0]).add(edge[i][1]);
		}
		int[] checkVisited = new int[numOfVertex];
		for (int i = 0; i < numOfVertex; i++) {
			if (!dfs(i, nodesList, checkVisited)) {
				return false;
			}
		}
		return true;
	}

	public boolean dfs(int node, List<List<Integer>> nodesList, int[] checkVisited) {
		checkVisited[node] = 1;
		List<Integer> eligibleNodes = new ArrayList<>();
		eligibleNodes = nodesList.get(node);
		for (int i = 0; i < eligibleNodes.size(); i++) {
			int tempNode = eligibleNodes.get(i);
			if (checkVisited[tempNode] == 1) {
				return false;
			} else if (checkVisited[tempNode] == 0) {
				if (!dfs(tempNode, nodesList, checkVisited)) {
					return false;
				}
			}
		}
		checkVisited[node] = 2;
		return true;
	}

	public void generateDAG(int e, int v) {
		Random rand = new Random();
		int i;
		int [][]edge = new int[e][2];
		i = 0;
		while (i < e) {
			
			edge[i][0] = rand.nextInt(v);
			edge[i][1] = rand.nextInt(v);
			int [][]tempEdge = new int[i+1][2];
			for(int j = 0;j<i+1;j++){
				  tempEdge[j][0] = edge[j][0];
				  tempEdge[j][1] = edge[j][1];
			}
			if (checkAcyclic(tempEdge, i+1, v) == true) {
				System.out.println(edge[i][0] + " -> " + edge[i][1]);
				i++;
			}
		}
	
       
		System.out.println("The generated random graph is: ");
		int [][] adjMatrix = new int [v][v];
		for(int edg = 0;edg <e;edg++){
			  adjMatrix[edge[edg][0]][edge[edg][1]] = 1;
		}
		for(int row = 0;row<v;row++){
			for(int col=0;col<v;col++){
				 System.out.printf("%d ",adjMatrix[row][col]);
			}
			System.out.println();
		}
	    //Write to a file
		
		try{
			 x = new Formatter("1-5-5.txt");
		}catch(Exception q){
			 System.out.println("There is an error.");
		}
		for(int row = 0;row<v;row++){
			for(int col=0;col<v;col++){
				 x.format("%d ",adjMatrix[row][col]);
			}
			x.format("\n");
		}
		x.close();
	}
    
	public static void main(String[] args) {
		randomDAG obj = new randomDAG();
		obj.generateDAG(1, 5);
	}
}
