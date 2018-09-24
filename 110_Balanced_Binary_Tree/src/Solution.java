class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public boolean isBalanced(TreeNode root) {
		return helper(root) > -1 ? true : false;
	}
	private int helper(TreeNode root) {
		if(root == null) return 0;
		int l = helper(root.left);
		int r = helper(root.right);
		if(Math.abs(l-r) > 1 || l == -1 || r == -1) {
			return -1;	
		}
		return Math.max(l,r) +1;
	}
	/*
	private int mostDeep(TreeNode root) {
		if (root == null) return 0;
		return 1 + Math.max(mostDeep(root.left), mostDeep(root.right));
	}

	private int leastDeep(TreeNode root) {
		if (root == null) return 0;
		else if (root.left != null && root.right != null) {
			return 1 + Math.min(leastDeep(root.left), leastDeep(root.right));
		} else if (root.left != null && root.right == null) return leastDeep(root.left);
		else if (root.right != null && root.left == null) return leastDeep(root.right);
		return 1;
	}
	*/
	public static void main(String[] args) {
		TreeNode a = new TreeNode (1);
		TreeNode b = new TreeNode (1);
		TreeNode c = new TreeNode (1);
		TreeNode d = new TreeNode (1);
		TreeNode e = new TreeNode (1);
		TreeNode f = new TreeNode (1);
		TreeNode g = new TreeNode (1);
		TreeNode h = new TreeNode (1);
		TreeNode i = new TreeNode (1);
		TreeNode j = new TreeNode (1);
		TreeNode k = new TreeNode (1);
		TreeNode l = new TreeNode (1);
		TreeNode m = new TreeNode (1);
		TreeNode n = new TreeNode (1);
		TreeNode o = new TreeNode (1);
		a.left =b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		d.left = h;
		d.right = i;
		e.left = j;
		e.right = k;
		f.left = l;
		f.right = m;
		h.left = n;
		h.right = o;
		
		
		
		Solution  obj = new Solution();
		System.out.println(obj.isBalanced(a));
	}
}
