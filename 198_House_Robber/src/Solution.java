
public class Solution {
	public int rob(int[] nums) {
          int [] dp = new int[nums.length];
          if(nums.length == 0) return 0;
          if(nums.length == 1) return nums[0];
          if(nums.length == 2) return Math.max(nums[0], nums[1]);
          if(nums.length == 3) return Math.max(nums[0]+nums[2], nums[1]);
          dp[0] = nums[0];
          dp[1] = Math.max(nums[0], nums[1]);
          dp[2] = Math.max(nums[0]+nums[2], nums[1]);
          int res = Math.max(Math.max(dp[0], dp[1]), dp[2]);
          for(int i=3;i<nums.length;i++){
        	  dp[i] = Math.max(dp[i-2] + nums[i], dp[i-3] + nums[i]);
        	  if(res < dp[i])
        		  res = dp[i];
          }
          System.out.println(res);
          return res;
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		int [] test = new int [] {
			4,1,2
		};
		obj.rob(test);
	}
	
}
