
public class Solution {
	int res = 0;
    public int hammingDistance(int x, int y){
         int r = x ^ y; //Here we get the result of XOR, but we still need to check how many "1" when we transfer this decimal into binery num
         while(r != 0){
        	 if ((r%2) == 1){
        		  res++;
        	 }
        	 r = r/2;
         }
    	 return res;
    }
    public static void main(String [] args){
    	Solution obj = new Solution();
    	System.out.println(obj.hammingDistance(1,4));
    }
}
