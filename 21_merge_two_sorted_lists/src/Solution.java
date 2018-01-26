
//Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode ans1 = ans;
        while(l1 != null && l2 != null){
        	ans.next = (l1.val <l2.val) ? l1 : l2;
        	ans = ans.next;
        	if(l1.val <l2.val){
        		l1 = l1.next;
        	}else{
        		l2 = l2.next;
        	}
        	if(l1 == null){
        		ans.next = l2;
        		break;
        	}else if(l2 == null){
        		ans.next  =l1;
        		break;
        	}
        }
        return ans1.next;
    }
    public static void main(String [] args){
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(4);
    	ListNode d = new ListNode(1);
    	ListNode e = new ListNode(3);
    	ListNode f = new ListNode(4);
    	a.next = b;
    	b.next = c;
    	d.next = e;
    	e.next = f;
    	Solution obj = new Solution();
    	ListNode test = obj.mergeTwoLists(a, d);
    	while(test != null){
    		System.out.println(test.val);
    		test = test.next;
    	}
    }
}