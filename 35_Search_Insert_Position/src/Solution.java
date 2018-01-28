
public class Solution {
	public int searchInsert(int[] nums, int target) {
		int ans = 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i] >= target){
				ans = i;
				break;
			}else if(i == nums.length-1){
				 return nums.length;
			}
		}
		return ans;

	}

	public static void main(String[] args) {
            Solution obj = new Solution();
            int [] test = new int [] {1, 3, 5, 6};
            System.out.println(obj.searchInsert(test, 5));
            System.out.println(obj.searchInsert(test, 2));
            System.out.println(obj.searchInsert(test, 7));
            System.out.println(obj.searchInsert(test, 0));
            
            
	}
}
