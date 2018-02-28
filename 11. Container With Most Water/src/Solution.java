
public class Solution {

	// Brute Force
	/*
	public int maxArea(int[] height) {
		int n = height.length;
		int temp = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int area = (j - i) * Integer.min(height[i], height[j]);
				if (area > temp) {
					temp = area;
				}
			}
		}
		return temp;
	}
	
	https://leetcode.com/problems/container-with-most-water/discuss/6091/Easy-Concise-Java-O(N)-Solution-with-Proof-and-Explanation
    */
	public int maxArea(int[] height) {
           int l =0, r = height.length-1;
           int ans = 0;
           while(l<r){
        	   int area = (r-l) * Math.min(height[r], height[l]);
        	   ans = Math.max(ans, area);
        	   if(height[l] > height[r]){
        		     r--;
        	   }else{
        		   l++;
        	   }
           }
           return ans;
	}

	public static void main(String[] args) {

	}
}
