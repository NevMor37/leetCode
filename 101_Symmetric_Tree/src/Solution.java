
//Definition for a binary tree node.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	//to check if a tree is symmetrical or not is to check for each node, their left.left
	//and right.right child nodes must be equal
	//Same their left.right and right.left children must be equal
	//above is the ideal of the algorithm
	public boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}
		return recursiveS(root.left, root.right); 
	}
	public boolean recursiveS(TreeNode l, TreeNode r){
		  if(l == null && r == null){
			  return true;
		  }
		  else if(((l == null) && (r!=null)) || ((l != null) && (r==null))){
			  return false;
		  }
		  else if(l.val == r.val){
			  return (recursiveS(l.left, r.right) && recursiveS(l.right, r.left));
		  }	  
		  return false;
		  
	}
	public static void main(String [] args){
		  TreeNode a = new TreeNode(1);
		  TreeNode b = new TreeNode(2);
		  TreeNode c = new TreeNode(2);
		  TreeNode d = new TreeNode(3);
		  TreeNode e = new TreeNode(3);
		  TreeNode f = new TreeNode(4);
		  TreeNode g = new TreeNode(7);
		  a.left = b;
		  a.right = c;
		  b.left = null;
		  b.right = d;
		  c.left = null;
		  c.right = e;
		  Solution obj = new Solution();
		  
		  System.out.println(obj.isSymmetric(a));
		  
	}
}