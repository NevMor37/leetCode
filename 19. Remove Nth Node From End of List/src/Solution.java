//Given a linked list, remove the nth node from the end of list and return its head.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {            
               ListNode temp = new ListNode(0);
               ListNode slow = temp;
               ListNode fast = temp;
               slow.next = head;             
               //System.out.println(temp.next.val);
               for(int i =0;i<n;i++){
            	    fast=  fast.next;
               }
               while(fast.next != null){            	   
            	   slow = slow.next;
            	   fast = fast.next;           
               }        
               
               slow.next = slow.next.next;               
               return temp.next;
	}

	public static void main(String[] args) {
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
		ListNode head = obj.removeNthFromEnd(a, 2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
