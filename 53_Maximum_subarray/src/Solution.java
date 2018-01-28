
public class Solution {
	public int maxSubArray(int[] nums) {
		/*
		 * This problem the pint is that how do we build our DP subquestion
		 * In our solution We shounldn't make maxSubArray(nums[], i , j)
		 * We should build the sub-problem as maxSubArray(nums[], i)
		 * Which means that we must end the sub-array each time containing index i in our sub-array
		 * In this way will make our solution much easier 
		 * dp[i] = (dp[i-1] > 0) ? ((dp[i-1]) : 0) + nums[i]
		 * Then we try to find the maximum value in the dp array which would be the global optimization
		*/
		if(nums.length == 1){
			return nums[0];
		}
		int []dp = new int[nums.length];
		dp[0] = nums[0];
		int ans = nums[0];
		for(int i=1;i<nums.length;i++){
			  dp[i] = (dp[i-1] > 0) ? dp[i-1] : 0;
			  dp[i]+=nums[i];
			  ans = Math.max(ans,dp[i]);
		}
		return ans;
		 
          
	}
          
	public static void main(String [] args){
		   Solution obj = new Solution();
		  /* int [] test = new int []{
				   -2,1,-3,4,-1,2,1,-5,4	   
		   };*/
		   int [] test = new int []{-1, -2};
		   System.out.println(obj.maxSubArray(test));
		   
	}
}
