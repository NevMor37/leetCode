
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
	/*
	public ListNode reverseList(ListNode head) {
		   if(head == null) return null;
		   if(head.next == null) return head;
		   
		   ListNode temp = new ListNode(head.val);
		   while(true){
			   head = head.next;
			   if(head != null){
				   ListNode temp2 = new ListNode(head.val);			   
				   temp2.next = temp;
				   temp = temp2;
			   }else{
				   break;
			   }
		   }
		   return temp;
	}
	*/
	//Recursively
	
	public ListNode reverseList(ListNode head) {
		    if(head == null || head.next == null) return head;
		    ListNode newHead = reverseList(head.next);
		    head.next.next = head; 
		    head.next = null;
		    return newHead; //Answer interesting!
		    
	}
	public static void main(String[] args) {
            ListNode a = new ListNode (1);
            ListNode b = new ListNode (2);
            a.next = b;
            
            
            Solution obj = new Solution();
            ListNode test = obj.reverseList(a);
            
            while(test != null){
            	System.out.println(test.val);
            	test = test.next;
            }
            
	}
}
