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
		if(root == null) return true;
		Queue <TreeNode> q = new LinkedList();
		q.add(root.left);
		q.add(root.right);
		while(!q.isEmpty()){
			TreeNode p1 = q.remove();
			TreeNode p2 = q.remove();
			if(p1 == null && p2 == null) {
				continue;
			}
			else if(p1 == null || p2 == null) {
				return false;
			}
			else if(p1.val == p2.val) {
				q.add(p1.left);
				q.add(p2.right);
				q.add(p1.right);
				q.add(p2.left);
			}
			else return false;
		}
		
		return true;
	}
	
}
