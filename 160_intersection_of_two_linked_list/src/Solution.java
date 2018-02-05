class ListNode {
 int val;
 ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
 public class Solution {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		     ListNode p1 = headA;
		     ListNode p2 = headB;
		     if(p1 == null || p2 == null){
		    	 return null;
		     }
		     while(p1 != p2){
		    	 p1 = (p1 == null) ? headB : p1.next;
		    	 p2 = (p2 == null) ? headA : p2.next;	    	 
		     }
		     return p1;
	 
	 }/*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
           boolean check  =true;
           boolean check1 = true;
           boolean check2 = true;
           ListNode p1 = headA;
           ListNode p2 = headB;
           if(p1 == null || p2 == null){
        	   return null;
           }
           while(true){
        	    if(p1.next == null && check1 == true){
        	    	check1 = false;
        	    	if(check == false){
            	         p1 = headB;
            	         break;
        	    	}
        	    	p1 = headB;
        	    	check = false;
        	    }
        	    if(p2.next == null && check2 == true){
        	    	check2 = false;
        	    	if(check == false){
        	    		p2 = headA;
        	    		break;    		
        	    	}
        	    	check = false;
        	    	p2 = headA;
        	    }
        	    p1 = p1.next;
        	    p2 = p2.next;
           }
           while(p1 != p2){
        	   p1 = p1.next;
        	   p2 = p2.next;
           }
           return p1;
    }*/
    public static void main(String [] args){
    	  ListNode a = new ListNode(1);
    	  ListNode b = new ListNode(3);
    	  ListNode c = new ListNode(2);
    	  ListNode d = new ListNode(2);
    	  ListNode e = new ListNode(4);
    	  ListNode f = new ListNode(6);
    	  ListNode g = new ListNode(7);
    	  ListNode h = new ListNode(8);
    	  //a.next = b;
    	  //b.next = c;
    	  //d.next = e;
    	  //e.next = f;
    	  //f.next = g;
    	  //g.next = h;
    	  System.out.println(c == d);
    	  Solution obj = new Solution();
    	  System.out.println(obj.getIntersectionNode(a, d));
    	  
    	  
    }
}