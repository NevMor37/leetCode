
public class Solution {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
          int k = m+n-1;
          int i = m-1;
          int j = n-1;
          while(i >=0 && j >=0){
        	  if(nums1[i] > nums2[j]){
        		  nums1[k]  =nums1[i];
        		  k--;i--;
        	  }else{
        		  nums1[k] = nums2[j];
        		  k--;
        		  j--;
        	  }
          }
          while(j>=0){
        	  nums1[k--] = nums2[j--];
          }
          
          for(int q=0;q<m+n;q++){
        	  System.out.println(nums1[q]);
          }
	}
    public static void main(String [] args){
    	 int [] nums1 = new int [] {
    			5,8,9,0,0,0 
    	 };
    	 int [] nums2 = new int[]{
    		   4,7,8	 
    	 };
    	 Solution obj = new Solution();
    	 obj.merge(nums1, 3, nums2, 3);
    	 
    }
}
