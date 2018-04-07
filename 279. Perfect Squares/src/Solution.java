import java.util.Arrays;

public class Solution {
	public int numSquares(int n) {
         int [] ans = new int[n+1];
         Arrays.fill(ans, Integer.MAX_VALUE);
         ans[0] = 0;
         for(int i=1;i<=n;i++){
        	   for(int j=1;j<=Math.sqrt(i);j++){
        		   ans[i] = Math.min(ans[i], ans[i-j*j]+1);
        	   }
         }
         return ans[n];
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		System.out.println(obj.numSquares(9));
	}
}
