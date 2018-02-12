import java.util.*;

class Solution {
	public boolean containsDuplicate(int[] nums) {
		   if(nums.length <= 1) return false;
		   boolean ans = false;
           HashMap<Integer, Integer> map = new HashMap<>();
           for(int i=0;i<nums.length;i++){
        	   if(map.containsKey(nums[i])){
        		    ans = true; return ans;
        	   }
        	   map.put(nums[i], nums[i]);
           }
           return false;
           
	}
	public static void main(String [] args){
		
	}
}
