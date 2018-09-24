import java.util.*;
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class Solution {
	
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if(root == null || L > R){
			return null;
		}
		if(root.val < L) return trimBST(root.right, L, R);
		if(root.val > R) return trimBST(root.left, L, R);
		
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
    }
	public void traversal(TreeNode root){
		 if(root != null){
			   traversal(root.left);
			   System.out.println(root.val);
			   traversal(root.right);
		 }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(2);
		TreeNode test = s.trimBST(root, 1, 2);
		s.traversal(test);
	}
}