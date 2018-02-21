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
    List <Integer> treeNodes = new ArrayList<>();
	public int kthSmallest(TreeNode root, int k) {
           int ans = 0;
           treeToArray(root);
           ans = getAns(k);
           return ans;          
	}
	public void treeToArray(TreeNode root){
		 if(root != null){
			 treeToArray(root.left);
			 treeNodes.add(root.val);
			 treeToArray(root.right);
		 }
		 return;
	}
	public int getAns(int k){
		  return treeNodes.get(k-1);
	}
	
	public static void main(String [] args){
		  TreeNode test = new TreeNode(1);
		  Solution obj = new Solution();
		  System.out.println(obj.kthSmallest(test, 1));
		  
	}
}
