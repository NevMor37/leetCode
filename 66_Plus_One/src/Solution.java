class Solution {
    public int[] plusOne(int[] digits) {
    	 
    		 int [] res = new int [digits.length+1];
    		 for(int i=digits.length-1;i>=0;i--){
    			  if(digits[i] < 9){
    				  digits[i] =digits[i]+1;
    				  return digits;
    			  }
    			  digits[i] = 0;
    		 }
    		 int [] newDigits = new int [digits.length+1];
    		 newDigits[0] =1;
    	     return newDigits;
    }
    public static void main(String [] args){
    	Solution obj = new Solution();
    	int [] test = new int []{
    		1,2,3,4	
    	};
    	int [] tRes = obj.plusOne(test);
    	for(int i=0;i<tRes.length;i++){
    		System.out.printf("%d ", tRes[i]);
    	}
    }
}