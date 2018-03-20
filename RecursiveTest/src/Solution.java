class Btree{
	  int val;
	  float weight;
	  Btree left;
	  Btree right;
	  Btree lp;
	  Btree rp;
	  public Btree(int a){
		    this.val = a;
		    this.weight = 1;
		    this.left = null;
		    this.right = null;
		    this.lp = null;
		    this.rp = null;
	  }
}

public class Solution {
	  
	  public float recursiveTest(Btree node, int j){
		     if(node.left != null || node.right != null){
		    	    node.weight = node.weight/j;
		    	    j++;
		    	    node.weight = node.weight + 
		    	    ((node.left != null) ? recursiveTest(node.left,j) : 0)/((node.left != null) ? ((node.left.rp != null) ? 1 : 0) + ((node.left.lp != null) ? 1 : 0) : 1) +
		    	    ((node.right != null) ? recursiveTest(node.right,j) : 0)/((node.right != null)? ((node.right.rp != null) ? 1 : 0) + ((node.right.lp != null) ? 1 : 0) : 1);
		    	    return node.weight;
		     }
		     else return(node.weight/j);
	  }
      public static void main(String [] arg){
    	      Btree a = new Btree(1);
    	      Btree b = new Btree(2);
    	      Btree c = new Btree(3);
    	      Btree d = new Btree(4);
    	      Btree e = new Btree(5);
    	      a.left = b;
    	      b.rp = a;
    	      a.right = c;
    	      c.lp = a;
    	      //c.left = e;
    	      c.left = d;
    	      d.rp = c;
    	      b.left = d;
    	      d.lp = b;
    	      d.left = e;
    	      e.rp = d;
    	      Solution obj = new Solution();
    	      obj.recursiveTest(c, 1);
    	      System.out.println(c.weight);
      }
}
