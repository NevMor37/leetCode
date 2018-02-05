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
	public boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}
		if((root.left == null && root.right !=null)||(root.left != null && root.right ==null)) return false;
		if(root.left ==null && root.right==null ){
			return true;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root.left);
		stack.push(root.right);
		TreeNode l,r;
		while(!stack.isEmpty()){
			 if(stack.size() %2 != 0) return false;
			 l = stack.pop();
			 r = stack.pop();
			 if((l.left == null && r.right !=null)||(l.left != null && r.right ==null)) return false;
			 if((r.left == null && l.right !=null)||(r.left != null && l.right ==null)) return false;
			 
			 if(l!=null && r!=null){
				 if(l.val != r.val) return false;
			 }
			 if(l.left !=null && r.right!=null){
				 stack.push(l.left);
				 stack.push(r.right); 
			 }
			 if(l.right !=null && r.left!=null){
				 stack.push(l.right);
				 stack.push(r.left); 
			 } 
		}
		return true;
	}
	public static void main(String [] args){
		
	}
	
}
