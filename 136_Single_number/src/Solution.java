import java.util.*;
public class Solution {
	/*
	public int singleNumber(int[] nums) {
		int res = 0;
		Hashtable<Integer,Integer> hash = new Hashtable<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(hash.containsValue(nums[i])){
				 res = nums[i];
			}
			hash.put(nums[i], nums[i]);
		}
		return res;
	}*/
	//known that A XOR A = 0 and the XOR operator is commutative(可交换的), the solution will be very straightforward.
	public int singleNumber(int[] nums) {
		  int res = 0;
		  for(int i=0;i<nums.length;i++){
			   res ^=nums[i];
		  }
		  return res;
	}
	public static void main(String [] args){
		 Solution obj = new Solution();
		 int [] test = new int []{
			1,14,28,34,56,108,99,5432,43,41,313,435,534,645,24,28
		 };
		 System.out.println(obj.singleNumber(test));
	}
	
        
}
