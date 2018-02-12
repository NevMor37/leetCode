package linklistcycle2;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode detectCycle(ListNode head) {
               ListNode p1 = head;
               ListNode p2 = head;
               while(p2 != null && p2.next!=null){
            	   p1 = p1.next;
            	   p2 = p2.next.next;
            	   if(p1 == p2){
            		   ListNode p3 =head;
            		   while(p3 != p1){
                   	    p3= p3.next;
                   	    p1 = p1.next;
                      }
            		   return p1;
            	   }
               }
               return null;
	}
	public static void main(String [] args){
		ListNode a = new ListNode (1);
		ListNode b = new ListNode (2);
		ListNode c = new ListNode (3);
		ListNode d = new ListNode (4);
		ListNode e = new ListNode (5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = c;
		Solution obj = new Solution();
		System.out.println(obj.detectCycle(a).val);
	}
}
