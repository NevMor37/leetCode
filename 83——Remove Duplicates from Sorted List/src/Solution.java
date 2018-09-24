class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode ans = head;
        while(head.next != null) {
        	if(head.val == head.next.val) {
        		head.next = head.next.next;
        	}else {
        		head = head.next;
        	}
        }
        return ans;
    }
    public static void main(String [] args) {
    	ListNode a = new ListNode(1); 
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(2);
    	ListNode d = new ListNode(3);
    	ListNode e = new ListNode(3);
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	Solution obj = new Solution();
    	obj.deleteDuplicates(a);
    }
}