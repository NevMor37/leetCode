
public class Solution {
	public void rotate(int[] nums, int k) {
		   int offset = k % nums.length;
		   //System.out.println(offset);
           reverse(nums, 0,nums.length-1-offset);
           reverse(nums, nums.length-offset, nums.length-1);
           reverse(nums, 0, nums.length-1);
           
           for(int i=0;i<nums.length;i++){
        	   System.out.printf("%d ", nums[i]);
           }
	}
	public void reverse(int [] nums, int head, int tail){
		   int temp = 0;
		   while(head < tail){
			   temp = nums[head];
			   nums[head] = nums[tail];
			   nums[tail] = temp;
			   head++;
			   tail--;
		   }
	}	
	public static void main(String [] args){
		 Solution obj = new Solution();
		 int [] test = new int []{
			1,2,3,4,5,6,7	 
		 };
		 obj.rotate(test, 3);
	}
}
