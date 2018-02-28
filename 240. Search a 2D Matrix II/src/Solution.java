
public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		    if(matrix.length == 0 || matrix == null) return false;
		    int i = 0;
		    int j = matrix[0].length-1;		    
		    return helper(i, j , matrix, target);
	}
	public boolean helper(int i, int j, int [][] matrix, int target){
		     if(matrix[i][j] > target){
		    	   if(j>0){
		    		 return helper(i, j-1 , matrix, target);
		    	   }
		    	   return false;
		     }
		     else if(matrix[i][j] < target){
		    	   if(i < matrix.length-1){
		    		 return helper(i+1, j , matrix, target);
		    	   }
		    	   return false;
		     }
		     return true;
	}
	public static void main(String [] args){
		
		 int [][] test = new int [][] {
				  {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}
		 };
		 // int [][]test = new int[][]{}; 
		 Solution obj = new Solution();
		 System.out.println(obj.searchMatrix(test, 20));
	}
}
