import java.util.*;
public class Solution {
	public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
		Queue<int[]> queue = new LinkedList<>();
		int r = matrix.size();
		int c = matrix.get(0).size();
		//initiation
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(matrix.get(i).get(j) == 0){
				   queue.offer(new int []{i, j}); // systax to add an array to a queue
				}else{
					matrix.get(i).set(j, Integer.MAX_VALUE);//Syntax for setting a value in a list 
				}
			}
		}
		//define 4 directions
		int [][] dirs = {
				{-1, 0},
				{1, 0},
				{0, -1},
				{0, 1}
		};
		/*
		while(queue.size()>0){
			int []shubin = queue.poll();
			System.out.println(shubin[0]+" "+shubin[1]);
		}
		*/
		
		while(!queue.isEmpty()){
			int [] shubin = queue.poll();
			int ox = shubin[0];
			int oy = shubin[1];
			for(int i=0;i<4;i++){
				int nx = dirs[i][0] + ox;
				int ny = dirs[i][1] + oy;
				if(nx <0 || nx >= r || ny < 0 || ny >=c || matrix.get(nx).get(ny) <= matrix.get(ox).get(oy) + 1) continue;
				queue.add(new int []{nx, ny});			
				matrix.get(nx).set(ny, matrix.get(ox).get(oy) + 1);
			}
		}
		return matrix;
	}
	public static void main(String[] args) {
		Solution obj = new Solution();
		List<List<Integer>> test = new LinkedList<>();
		test.add(new ArrayList<Integer>());
		test.get(0).add(0);
		test.get(0).add(0);
		test.get(0).add(0);
		test.add(new ArrayList<Integer>());
		test.get(1).add(0);
		test.get(1).add(1);
		test.get(1).add(0);
		test.add(new ArrayList<Integer>());
		test.get(2).add(1);
		test.get(2).add(1);
		test.get(2).add(1);
		List<List<Integer>> testArr = obj.updateMatrix(test);
		//List<List<Integer>> testArr =test;
		int r = testArr.size();
		int c = testArr.get(0).size();
		//System.out.println(r);
		
		for (int i = 0; i < r; i++) {
             for(int j=0;j<c;j++){
            	 System.out.printf("%d ", testArr.get(i).get(j));
             }
             System.out.println();
		}

	}
}
