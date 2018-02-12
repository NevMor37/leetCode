
public class Solution {
	public int hammingWeight(int n) {
          int ans = 0;
          int temp = 0;
          for(int i=0;i<32;i++){
        	   temp = n & 1;
        	   if(temp == 1){
        		   ans++;
        	   }
        	   n>>>=1;
          }
          System.out.println(ans);
          return ans;
	}

	public static void main(String [] args) {
          Solution obj = new Solution();
          obj.hammingWeight(11);
	}
}
