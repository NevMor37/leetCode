
//Definition for singly-linked list.
//Given a singly linked list, determine if it is a palindrome.
//Could you do it in O(n) time and O(1) space?
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public boolean isPalindrome(ListNode head) {
		
              if(head == null || head.next == null) return true;
              ListNode slow, fast, head3;
              slow = head;
              fast = head;
              head3 = head;
              //Find the meddle of the linked list
              while(fast != null && fast.next != null){
            	  slow = slow.next;
            	  fast = fast.next.next;
              }
              
              if(fast != null){
            	  slow = slow.next; 
              }
              //reverse the right hand side of the linked list from the slow point
              ListNode head2 = reverseLinkedList(slow);
              
              while(head2 != null && head3 != null){
            	     if(head2.val != head3.val){
            	    	 return false;
            	     }
            	     head2 = head2.next;
            	     head3 = head3.next;
              }
              
              return true;
              
	}
	public ListNode reverseLinkedList(ListNode head){
		  if(head == null || head.next == null) return head;
		  ListNode temp = new ListNode(head.val);
		  temp.next = null;//new tail
          while(head != null){
        	  head = head.next;
        	  if(head != null){
        		  ListNode temp2 = new ListNode(head.val);
            	  temp2.next = temp;
            	  temp = temp2;
        	  }
          }	
          return temp;		  
	}
	public static void main(String [] args){
		  ListNode a = new ListNode(1);
		  ListNode b = new ListNode(2);
		  ListNode c = new ListNode(3);
		  ListNode d = new ListNode(2);
		  ListNode e = new ListNode(1);
		  a.next = b;
		  b.next = c;
		  c.next = d;
		  d.next = e;
		  Solution obj = new Solution();
		  System.out.println(obj.isPalindrome(a));
	}
}
