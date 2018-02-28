import java.util.Arrays;

/*
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
  Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
	public int threeSumClosest(int[] nums, int target) {
           int minD = Integer.MAX_VALUE;
           int ans = 0;
           if(nums == null || nums.length < 3){return ans;}
           Arrays.sort(nums);
           for(int i = 0;i<nums.length-2;i++){
        	     int l = i+1;
        	     int r = nums.length-1;
        	     while(l<r){
        	    	 int temp = Math.abs(nums[l] + nums[r] + nums[i] - target);       	    	
        	    	  if(minD > temp){       	    		
        	    		  minD = temp;
        	    		  ans = nums[l] + nums[r] + nums[i];
      	    	      }
        	    	  if(nums[l] + nums[r] + nums[i] > target){
        	    		   r--;       	    		   
        	    	  }else{
        	    		  l++;
        	    	  }      	    	  
        	     }
           }
           return ans;
	}
	public static void main(String [] args){
		 int [] test = new int[]{
				 -1, 2, 1, 4
		 };
		 Solution obj = new Solution();
		 System.out.println(obj.threeSumClosest(test, 1));
	}
}
