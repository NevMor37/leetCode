class TreeNode{
	 TreeNode left;
	 TreeNode right;
	 int val;
	 TreeNode(int val){
		 this.val = val;
		 this.left = null;
		 this.right =null;
	 }
}
public class Solution {
	public int maxDepth(TreeNode root){
		 if(root == null){
			 return 0;
		 }
		 return 1+Math.max(maxDepth(root.left), maxDepth(root.right));	 
	}
	public static void main(String [] args){
		 
	}

}
