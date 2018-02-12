import java.util.*;
public class Solution {
	public int arrayPairSum(int[] nums) {
           int ans =0;
           /*
           for(int i= 0; i<nums.length-1;i++){
        	    for(int j = i+1; j<nums.length;j++){
        	    	if(nums[i] > nums[j]){
        	    		int temp = nums[i];
        	    		nums[i] = nums[j];
        	    		nums[j] = temp;
        	    	}
        	    } 
           }*/
           Arrays.sort(nums);
           for(int i=0; i<nums.length; i=i+2)
        	   ans+=nums[i];
           return ans;
	}
	public static void main(String [] args){
		int [] ar = new int[] {1,4,3,2};
		//System.out.println(ar.length);
		Solution obj = new Solution();
		System.out.println(obj.arrayPairSum(ar));
		
	}
}
