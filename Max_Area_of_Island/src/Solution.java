
public class Solution {
	public int maxAreaOfIsland(int[][] grid) {
       int ans = 0;
      for(int i= 0;i<grid.length; i++){
    	  for(int j= 0; j<grid[0].length; j++){
    		  //System.out.printf(grid[i][j]+" ");
    			  int temp = dfs(i, j, grid);
    			  if(temp > ans){
    				  ans = temp;
    		  }
    	  }
    	  //System.out.println();
      }
      return ans;
	}
	public int dfs(int x, int y, int [][] m){
		int l=0;
		int r=0;
		int u=0;
		int d=0;
		
		if(m[x][y] == 0){  
			return 0;
		}else{
			m[x][y] = 0;
			if(x-1 >=0){
				l = dfs(x-1, y, m);
			}
			if(y-1>=0){
				u = dfs(x, y-1, m);
			}
			if(x+1 <= m.length-1){
				r = dfs(x+1,y, m);
			}
			if(y+1 <= m[0
			            ].length-1){
				d = dfs(x,y+1, m);
			}
			return 1+l+r+u+d;
		}
	}
	public static void main(String [] args){
		 int [][]test = new int [][]{
			 {0,0,1,0,0,0,0,1,0,0,0,0,0},
			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
			 {0,1,1,0,1,0,0,0,0,0,0,0,0},
			 {0,1,0,0,1,1,0,0,1,0,1,0,0},
			 {0,1,0,0,1,1,0,0,1,1,1,0,0},
			 {0,0,0,0,0,0,0,0,0,0,1,0,0},
			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
			 {0,0,0,0,0,0,0,1,1,0,0,0,0}	 
		 };
		 Solution obj = new Solution();
		 System.out.println(obj.maxAreaOfIsland(test));
	}
}
