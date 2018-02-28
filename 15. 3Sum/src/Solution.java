/*
        First sort the array
        Retrive the first element of the three sum, then for the other two, apply the two sum "Two Pointer" algorithm.
        Since we may hve multiple answer we need to remove duplicated answer
        for the sorted array, if the first element is positive or the last element is negative, no answer we terminate our
        searching.
*/
import java.util.*;
public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if(nums == null || nums.length == 0) return ans;
            Arrays.sort(nums);
            if(nums[0] > 0 || nums[nums.length-1] < 0) return ans;            
            //Start our algorithm
            int tempSum;
            for(int i=0;i<nums.length-2;i++){
            	  if(i > 0 && nums[i] == nums[i-1]) continue;
            	  tempSum = 0 - nums[i];
            	  int p1 = i+1;
            	  int p2 = nums.length-1;
            	  while(p1 < p2){
            		    if(nums[p1] + nums[p2] == tempSum){
            		    	ans.add(Arrays.asList(nums[i], nums[p1],nums[p2]));
            		    	while(p1<p2 && nums[p1] == nums[p1+1]) p1++;
            		    	while(p1<p2 && nums[p2] == nums[p2-1]) p2--;
            		    	p1++;
            		    	p2--;
            		    }else if(nums[p1] + nums[p2] < tempSum){
            		    	p1++;
            		    }else{
            		    	p2--;
            		    }
            	  }
            }
            return ans;
	}
	public static void main(String [] args){
		 int [] test = new int[]{
				 -1, 0, 1, 2, -1, -4	 
		 };
		 Solution obj = new Solution();
		 List<List<Integer>> testRes = obj.threeSum(test);
		 for(int i=0;i<testRes.size();i++){
			   for(int j = 0; j < testRes.get(i).size();j++){
				      System.out.printf("%d ", testRes.get(i).get(j));
			   }
			   System.out.println();
		 }
	}
}
