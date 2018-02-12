
 
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class Solution {
	public void deleteNode(ListNode node) {
		  node.val = node.next.val;
		  node.next = node.next.next;
    }
	
      public static void main(String [] args){
    	  ListNode a = new ListNode(1);
		  ListNode b = new ListNode(2);
		  ListNode c = new ListNode(3);
		  ListNode d = new ListNode(4);
		  ListNode e = new ListNode(5);
		  a.next = b;
		  b.next = c;
		  c.next = d;
		  d.next = e;
		  Solution obj = new Solution(); 
		  obj.deleteNode(b);
		  while(a != null){
			  System.out.println(a.val);
			  a = a.next;
		  }
      }
}
