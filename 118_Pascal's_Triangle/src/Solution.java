import java.util.*;
public class Solution {
	public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> ans = new ArrayList<List<Integer>>();
         if(numRows <=0) return ans;
         List<Integer> row1= new ArrayList<Integer>();
         row1.add(1);
         ans.add(row1);
         if(numRows == 1) return ans;
         for(int i=1;i<numRows;i++){
        	  List<Integer> tempRow= new ArrayList<Integer>();
        	  for(int j=0;j<i+1;j++){
        		  if(j==0 || j==i){
        			   tempRow.add(1);
        		  }else{
        			  tempRow.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
        		  }
        	  }
        	  ans.add(tempRow);
         }
         return ans;
	}

	public static void main(String[] args) {
           Solution obj = new Solution();
           List<List<Integer>> test = obj.generate(19);
           for(int i=0;i<test.size();i++){
        	   for(int j=0;j<test.get(i).size();j++){
        		    System.out.printf("%d ",test.get(i).get(j));
        	   }
        	   System.out.println();
           }
           
	}
}
