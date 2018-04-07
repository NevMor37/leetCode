import java.util.*;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0 || nums == null) return ans;
        for(int i=0;i<=nums.length;i++){
        	 helper(ans, new ArrayList<>(), i, 0, nums);
        }
        return ans;
    }
	private void helper(List<List<Integer>> ans, List<Integer> cur, int k, int start , int[] nums){
		 if(k == 0){
			 ans.add(new ArrayList<>(cur));
			 return;
		 }
		 for(int i=start; i<nums.length;i++){
			 cur.add(nums[i]);
			 helper(ans, cur, k-1, i+1, nums );
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
