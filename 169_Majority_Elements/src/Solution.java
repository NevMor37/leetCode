import java.util.*;
public class Solution {
	public int majorityElement(int[] nums) {
           Arrays.sort(nums);
           return nums[nums.length/2];
	}
	public static void main(String [] args){
		
	}
}
