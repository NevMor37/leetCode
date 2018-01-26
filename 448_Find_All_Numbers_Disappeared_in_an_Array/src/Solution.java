import java.util.*;

class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ans = new ArrayList<Integer>();
		int l = nums.length;
		for(int i=0;i<l;i++){
			int val = Math.abs(nums[i]);
			if(nums[val-1] > 0){//免得重复
				nums[val-1] = (-1)* nums[val-1];
			}
		}
		for(int i = 0;i<l;i++){
			if(nums[i] >0){
				ans.add(i+1);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		
		
		Solution obj = new Solution();
		int [] test = new int []{4, 3, 2, 7, 8, 2, 3, 1};
		List<Integer> k = obj.findDisappearedNumbers(test);
		for(int i=0;i<k.size();i++){
			System.out.println(k.get(i));
		}
		/*List<Integer> test = new ArrayList<Integer>();
		test.add(4);
		test.add(3);
		test.add(2);
		test.add(7);
		test.add(8);
		test.add(2);
		test.add(3);
		test.add(1);
		
		for (int i = 0; i < test.size(); i++) {
			System.out.printf("%d ",test.get(i));
		}
		*/
		
	}
}