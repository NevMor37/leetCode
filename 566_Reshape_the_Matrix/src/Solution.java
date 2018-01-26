
public class Solution {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
           int [][]ans = new int [r][c];
           int amount = r * c;
           int []temp = new int [amount];
           int ox = nums.length;
           int oy = nums[0].length;
           if ((ox * oy) != amount){
        	   return nums;
           }
           int count = 0;
           for(int i=0; i<ox; i++){
        	   for(int j = 0; j< oy; j++){
        		   temp[count] = nums[i][j];  
        		   count++;
        	   }
           }
           count = 0;
           for(int i = 0; i<r; i++){
        	   for(int j=0;j<c; j++){
        		   ans[i][j] = temp[count];
        		   count ++;
        	   }
           }
           return ans;
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		int[][] test= new int[][]{
			{1, 2},
			{3, 4}
		};
		int [][] testObj = obj.matrixReshape(test, 1, 4);
		for(int i=0;i<1;i++){
			for(int j=0;j<4;j++){
				System.out.printf("%d ", testObj[i][j]);
			}
			System.out.println();
		}
	}
}
