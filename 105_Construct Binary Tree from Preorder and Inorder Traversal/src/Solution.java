
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length)
			return null;
		TreeNode ans = helper(preorder, inorder, 0, 0, preorder.length - 1);
		return ans;
	}

	private TreeNode helper(int[] preorder, int[] inorder, int prest, int inst, int inend) {
		if (prest > preorder.length || inst > inend)
			return null;
		TreeNode curr = new TreeNode(preorder[prest]);
		int i = inst;
		while (i < inend) {
			if (inorder[i] == preorder[prest]) {
				break;
			}
			i++;
		}
		curr.left = helper(preorder, inorder, prest + 1, inst, i - 1);
		curr.right = helper(preorder, inorder, prest + i - inst + 1, i + 1, inend);
		return curr;
	}
}