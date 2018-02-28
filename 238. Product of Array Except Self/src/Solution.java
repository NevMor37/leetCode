
public class Solution {
	/*
	//Larger space complexity
	public int[] productExceptSelf(int[] nums) {
           int [] fwd = new int [nums.length];
           int [] bwd = new int [nums.length];
           fwd[0] =1;
           bwd[nums.length-1] =1;
           for(int i=1;i<nums.length;i++){
        	      fwd[i] = nums[i-1] * fwd[i-1];
           }
           for(int i=nums.length-2;i>=0;i--){
     	      bwd[i] = nums[i+1] * bwd[i+1];
           }
           for(int i=0;i<nums.length;i++){
        	   fwd[i] *= bwd[i];
           }
           return fwd;
           
	}*/
	//O(n) time, const space
	public int[] productExceptSelf(int[] nums) {
        int [] ans = new int[nums.length];
        ans[0] =1;
        for(int i=1;i<nums.length;i++){
        	ans[i] =  ans[i-1] * nums[i-1];
        }
        int temp = 1;
        for(int i = nums.length-2;i>=0;i--){
        	temp*=nums[i+1];
        	ans[i] = ans[i] * temp;
        }
        		
        return ans;       
	}
	public static void main(String [] args){
		  int [] test = new int []{
				 1,2,3,4
		  };
		  Solution obj = new Solution();
		  int [] res = obj.productExceptSelf(test);
		  for(int i : res){
			  System.out.println(i);
		  }
	}
}
