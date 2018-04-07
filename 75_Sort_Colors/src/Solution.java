//Given an array with n objects colored red, white or blue, sort them so that objects of the same color 
//are adjacent, with the colors in the order red, white and blue.
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//Note:
//You are not suppose to use the library's sort function for this problem.
public class Solution {
	public void sortColors(int[] nums) {
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < nums.length; i++){
			if(nums[i] == 0) count0++;
			else if(nums[i] == 1) count1++;
			else if(nums[i] == 2) count2++;
		}
//		System.out.println(count0);
//		System.out.println(count1);
//		System.out.println(count2);
		
		while(count2 > 0){
			nums[count0+count1+count2-1] = 2;
			count2--;
		}
		while(count1>0){
			nums[count0+count1-1] = 1;
			count1--;
		}
		while(count0>0){
			nums[count0-1] = 0;
			count0--;
		}
		
	}
	public static void main(String [] args){
		int [] test = new int []{
			0,1,2,1,1,1,1,0,0,0,2,2,0,1,2	
		};
		Solution obj = new Solution();
		obj.sortColors(test);
		for(int ele : test){
			System.out.printf("%d ", ele);
		}
	}
}
