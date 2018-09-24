import java.util.*;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
	       LinkedList <List<Integer>> res = new LinkedList<List<Integer>>();
	        if(nums == null) return res;
	        helper(res, new LinkedList<Integer>(), nums, 0);
	        return res;
	    }
	    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
	        res.add(new LinkedList<Integer>(cur));
	        for(int i = index; i< nums.length;i++) {
	            cur.add(nums[i]);
	            helper(res, cur, nums, index +1);
	            cur.remove(cur.size()-1);
	        } 
	    }
	public static void main(String [] args){
		int [] nums ={
		   1,2,3,4		
		};
		Solution obj = new Solution();
		List<List<Integer>> test = obj.subsets(nums);
		for(int i = 0;i<test.size();i++){
			System.out.print("[");
			for(int j= 0;j<test.get(i).size();j++){
				System.out.printf("%d ", test.get(i).get(j));
			}
			System.out.println("]");
		}
	}
}
