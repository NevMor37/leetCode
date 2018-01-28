//slower pointer will always maintain the current array
public class Solution {
	public int removeElement(int[] nums, int val) {
		int point = 0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i] != val){
        		nums[point] = nums[i];
        		point++;
        	}
        }
        /*
        for(int i=0;i<point;i++){
        	System.out.println(nums[i]);
        }
        System.out.println();*/
		return point;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] test = new int[] { 3, 2, 2, 3 };
		System.out.println(obj.removeElement(test, 3));
	}
}
