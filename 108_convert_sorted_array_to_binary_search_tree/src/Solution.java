
 // Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
           if(nums.length == 0){
        	   return null;
           }
           return helper(0,nums.length-1, nums);
    }
    public TreeNode helper( int low, int high, int [] nums){
    	  if(low > high) return null;
    	  int mid = low + (high-low)/2;
    	  TreeNode node = new TreeNode(nums[mid]);
    	  node.left = helper(low,mid-1,nums);
    	  node.right = helper(mid+1, high,nums);
    	  return node;
    }
    public void traverse(TreeNode root){
    	 if(root != null){
    		 System.out.println(root.val);
    		 traverse(root.left);
    		 traverse(root.right);
    	 }
    }
    public static void main(String [] args){
    	int [] test = new int[]{
    		-10,-3,0,5,9	
    	};
    	Solution obj = new Solution();
    	TreeNode res = obj.sortedArrayToBST(test);
    	obj.traverse(res);
    }
}