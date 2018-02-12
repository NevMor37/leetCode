import java.util.*;

public class Solution {
	//XOR
	/*
	public int missingNumber(int[] nums) {
          int ans = nums.length; // length can't reach to the index of this array 
          for(int i=0;i<nums.length;i++){
        	    ans ^= nums[i];
        	    ans ^= i;
          }
          System.out.println(ans);
          return ans;
	}*/
	//Sum
	/*
	public int missingNumber(int[] nums) {
        int ans = ((0+nums.length) * (nums.length+1))/2;
        for(int i=0;i<nums.length;i++){
      	    ans-=nums[i];
        }
        System.out.println(ans);
        return ans;
	}*/
	
	//Binary Search
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
        int left = 0, right = nums.length;
        int mid;
        while(left < right){
        	 mid = (left+right)/2;
        	 if(nums[mid] > mid){
        		  right = mid;
        	 }else{
        		 left = mid+1;
        	 }
        }
        System.out.println(left);
        return left;
	}
	
	
	public static void main(String [] args){
		int [] test = new int []{
				9,6,4,2,3,5,7,0,1
		};
		Solution obj = new Solution ();
		obj.missingNumber(test);
	}
}
