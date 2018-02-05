//Multiple transactions
//Every time we try to find the local minimum and local maximum point of the stock buy and sell
//We don't have to sell a stock as long as it goes up, this will increase the computation complexity
public class Solution {
	public int maxProfit(int[] prices) {
           if(prices.length <= 1){
        	   return 0;
           }
           int buy = 0,
        	   sell = 0,
        	   i =0,
        	   res = 0;
               
           while(i<prices.length-1){
        	   //find local minimum as the buy point
        	   while(i<prices.length-1 &&prices[i]>=prices[i+1]){
        		    i++;
        	   }
        	   buy = i;
        	   //System.out.printf("%d ", buy);
        	   while(i<prices.length-1 && prices[i]<=prices[i+1]){
        		   i++;
        	   }
        	   sell =i;
        	   //System.out.printf("%d ", sell);
        	   
        	   res += prices[sell] - prices[buy];
        	   //System.out.printf("%d ", res);
        	   //System.out.println();
           }
           return res;
	}
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] test = new int[] { 7, 1, 5, 3, 6, 4};
		System.out.println(obj.maxProfit(test));
	}
}
