//This question is like a advanced swap problem
public class Solution {

	public void moveZeroes(int[] nums) {
		int j = 0;
		int temp;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			}
		}
		for (int i : nums) {
			System.out.println(i);
		}
	}

	public void moveLessThan5(int[] nums) {
		int j = 0;
		int temp;
		for (int i = 0; i < nums.length; i++) {
                   if(nums[i] >= 5){
                	temp = nums[j];
       				nums[j] = nums[i];
       				nums[i] = temp;
       				j++;
                   }
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] test = new int[] { 0, 1, 0, 3, 12 };
		obj.moveZeroes(test);
	}
}
