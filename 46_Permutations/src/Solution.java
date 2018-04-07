import java.util.*;

public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		  List<List<Integer>> ans = new ArrayList<>();
		  if(nums.length == 0 || nums == null) return ans;
		  helper(ans, new ArrayList<>(), nums);
		  return ans;
	}
    private void helper(List<List<Integer>> ans, ArrayList<Integer> List, int [] nums ) {
    	  if(List.size() == nums.length) {
    		     ans.add(new ArrayList<>(List));
    		     return;
    	  }
    	  for(int i = 0;i<nums.length;i++) {
    		   if(!List.contains(nums[i])) {
    			     List.add(nums[i]);
    			     helper(ans, List, nums);
    			     List.remove(List.size() -1);
    		   }
    	  }
    }
	public static void main(String[] args) {

	}
}
