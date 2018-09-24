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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<> ();
        if(root == null) return ans;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()) {
        	List<Integer> curr = new ArrayList <>();
        	int size = queue.size();
        	if(leftToRight == true) {
        		for(int i=0;i<size;i++) {
        			TreeNode temp = queue.remove(0);
        			curr.add(temp.val);
        			if(temp.left != null) queue.add(temp.left);
        			if(temp.right != null) queue.add(temp.right);
        		}
        		leftToRight =false;
        	} else {
        		for(int i=0;i<size;i++) {
        			TreeNode temp = queue.remove(queue.size()-1);
        			curr.add(temp.val);
        			if(temp.right != null) queue.add(0,temp.right);
        			if(temp.left != null) queue.add(temp.left);
        		}
        		leftToRight =true;
        	}
        		ans.add(curr);
        }
        return ans;
	}
}
