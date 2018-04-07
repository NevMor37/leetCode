//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. 
//The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//How many possible unique paths are there?
public class Solution {
	public int uniquePaths(int m, int n) {
		int ans = 0;
		int [][]matrix = new int[m][n];
		for(int i=0;i<n;i++){
			matrix[0][i] = 1;
		}
		for(int i=0;i<m;i++){
			matrix[i][0] = 1;
		}
		for(int i = 1;i<m;i++){
			for(int j = 1;j<n;j++){
				matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
			}
		}
		ans = matrix[m-1][n-1];
		return ans;
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		System.out.println(obj.uniquePaths(2,1));
	}
}
