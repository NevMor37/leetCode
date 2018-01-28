public class Solution {

	public int maxSubArray(int[] nums) {
         return devidedAndConquer(nums, 0,nums.length-1);
          
	}
    public int devidedAndConquer(int [] arr, int b, int e){
    	  if(b == e){
    		  return arr[b];
    	  }
    	  int m =(b+e+1)/2;
    	  int leftMS = devidedAndConquer(arr, b, m-1);
    	  int rightMS = devidedAndConquer(arr, m, e);
    	  int tempSum = 0, leftM = Integer.MIN_VALUE, rightM = Integer.MIN_VALUE;
    	  for(int i=m-1;i>=0;i--){
    		  tempSum+=arr[i];
    		  if(tempSum>leftM){
    			  leftM = tempSum;
    		  }
    	  }
    	  tempSum = 0;
    	  for(int i=m;i<=e;i++){
    		  tempSum+=arr[i];
    		  if(tempSum>rightM){
    			  rightM = tempSum;
    		  }
    	  }
    	  int res = Math.max(leftMS, rightMS);
    	      res  =Math.max(res, rightM+leftM);
    	      return res;
    }
	public static void main(String[] args) {
         Solution obj = new Solution();
         int [] test = new int [] {
             -2,1,-3,4,-1,2,1,-5,4	 
         };
         System.out.println(obj.maxSubArray(test));
	}

}
