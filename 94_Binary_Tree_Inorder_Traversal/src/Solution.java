import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	List<Integer> res = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
           dfs(root);
           return res;
	}
	public void dfs(TreeNode root){
		if(root!= null){
     	   dfs(root.left);
     	   res.add(root.val);
     	   dfs(root.right);
        }
	}
	public static void main(String [] args){
		 
	}
}
