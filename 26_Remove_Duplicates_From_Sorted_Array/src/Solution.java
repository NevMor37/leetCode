
public class Solution {
	public int removeDuplicates(int[] nums) {
           int point = 0;
           for(int i=0;i<nums.length;i++){
        	   if(nums[i] != nums[point]){
        		    point++;
        		    nums[point] = nums[i];
        	   }
           }
           return ++point;
	}
	public static void main(String [] args){
		 Solution obj = new Solution();
		 int [] test = new int []{1, 1, 2};
		 System.out.println(obj.removeDuplicates(test));
		 
	}
}
