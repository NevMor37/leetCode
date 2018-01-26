import java.util.*;
public class Solution {
     public int depthSum(List<NestedInteger> nestedList){
    	   int level = 1;
    	   int sum = 0;
    	   while(nestedList.size() !=0){
    		   List<NestedInteger> next = new LinkedList<>();
    		   for(NestedInteger nInt : nestedList){
    			   if(nInt .isInteger()){
    				   sum+=nInt.getInteger()*level;
    			   }else
    				   next.addAll(nInt.getList());
    		   }
    		   level++;
    		   nestedList = next;
    	   }
    	   return sum;
     }
}
