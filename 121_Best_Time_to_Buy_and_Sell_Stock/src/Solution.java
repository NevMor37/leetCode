
public class Solution {
	public int maxProfit(int[] prices) {
		 if(prices.length <= 1) return 0;
         int res = Integer.MIN_VALUE;
         int minValue = Integer.MAX_VALUE;
         for(int i=0;i<prices.length;i++){
        	  if(prices[i]<minValue) minValue = prices[i];
        	  if(prices[i]-minValue > res){
        		  res = prices[i]-minValue;
        	  }
         }
         if(res <0) res =0;
         return res;
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		int [] test = new int[]{
			7,6,4,3,1
		};
		System.out.println(obj.maxProfit(test));
	}
}
