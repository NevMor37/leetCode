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
	public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if(root == null) {
 			   return ans;
 		   }
            queue.offer(root);
            while(queue.size() != 0) {
            	 int iterativeNum = queue.size();
            	 List <Integer> tempList = new ArrayList<>();
            	 for(int i= 0;i<iterativeNum;i++) {
            		   if(queue.peek().left != null) {queue.offer(queue.peek().left);}
            		   if(queue.peek().right != null) {queue.offer(queue.peek().right);}
            		   tempList.add(queue.poll().val);
            	 }
            	 ans.add(tempList);
            }
            return ans;
	}
	public static void main(String [] args) {
		 TreeNode a = new TreeNode(3);
		 TreeNode b = new TreeNode(9);
		 TreeNode c = new TreeNode(20);
		 TreeNode d = new TreeNode(15);
		 TreeNode e = new TreeNode(7);
		 a.left = b;
		 a.right = c;
		 c.left = d;
		 c.right = e;
		 Solution obj = new Solution ();
		 List<List<Integer>> test= obj.levelOrder(a);
		 for(int i=0;i<test.size();i++) {
			    for(int j=0;j<test.get(i).size();j++) {
			    	System.out.printf("%d ", test.get(i).get(j));
			    }
			    System.out.println();
		 }
	}
}
