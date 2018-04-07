
public class Solution {
	public int numIslands(char[][] grid) {
		 int ans = 0;
		 if(grid.length == 0) return ans;
		 for(int i=0;i<grid.length;i++){
			 for(int j= 0;j<grid[0].length;j++){
				 if(grid[i][j] == '1'){
					 ans++;
					 helper(grid, i, j);
				 }
			 }
		 }
		 return ans;
	}
	private void helper(char[][] grid, int i, int j){
		/*
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
	    grid[i][j] = '0';
	    helper(grid, i + 1, j);
	    helper(grid, i - 1, j);
	    helper(grid, i, j + 1);
	    helper(grid, i, j - 1);
		*/
		  if(grid[i][j] == '0') return;
		  grid[i][j] = '0';
		  if(i > 0){
			  helper(grid, i-1, j);
		  }
		  if(i <grid.length-1){
			  helper(grid, i+1, j);
		  }
		  if(j > 0){
			  helper(grid, i, j-1);
		  }
		  if(j <grid[0].length-1){
			  helper(grid, i, j+1);
		  }
	}
	public static void main(String [] args){
		 Solution obj = new Solution();
		 char [][] test1 = new char[][]{
			 {'1','1','1','1','0'},
			 {'1','1','0','1','0'},
			 {'1','1','0','0','0'},
			 {'0','0','0','0','0'}
		 };
		 
		 char [][] test2 = new char[][]{
			 {'1','1','0','0','0'},
			 {'1','1','0','0','0'},
			 {'0','0','1','0','0'},
			 {'0','0','0','1','1'}
		 };
		 System.out.println(obj.numIslands(test1));
		 System.out.println(obj.numIslands(test2));
	}
}
