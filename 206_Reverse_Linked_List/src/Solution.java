
//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next =null;
	}
}

public class Solution {
	//Iteratively
	
	public ListNode reverseList(ListNode head) {
		   ListNode pre = null;
		   ListNode cur = null;
		   ListNode next = head;
		   while(next != null){
			   cur = next;
			   next = next.next;
			   cur.next = pre;
			   pre = cur;			   
		   }
		   return cur;
	}
	
	//Recursively
	
//	public ListNode reverseList(ListNode head) {
//		    if(head == null || head.next == null) return head;
//		    ListNode newHead = reverseList(head.next);
//		    head.next.next = head; 
//		    head.next = null;
//		    return newHead; //Answer interesting!
//		    
//	}
	public static void main(String[] args) {
            ListNode a = new ListNode (1);
            ListNode b = new ListNode (2);
            ListNode c = new ListNode (3);
            ListNode d = new ListNode (4);
            a.next = b;
            b.next = c;
            c.next = d;
            
            
            Solution obj = new Solution();
            ListNode test = obj.reverseList(a);
            
            while(test != null){
            	System.out.println(test.val);
            	test = test.next;
            }
            
	}
}
