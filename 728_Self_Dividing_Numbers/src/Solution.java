import java.util.*;
public class Solution {
	public static List<Integer> selfDividingNumbers(int left, int right) {
           List<Integer> ans = new ArrayList<Integer>();
           for(int i=left; i<= right; i++){
        	   boolean check = true;
        	   int temp = i;
        	   
        	   while(temp > 0){
        		   int j = temp % 10;
        		   if(j == 0){
        			   check = false;
        			   break;
        		   }
        		   if((i % j) != 0){
        			   check = false;
        			   break;
        		   }
        		   temp = temp / 10;
        	   }
        	   
        	   if(check == true){
        		   ans.add(i);
        	   }
           }
           return ans;
	}
	public static void main(String [] args){
	    int left = 1;
	    int right = 22;
	    for(int i = 0; i< selfDividingNumbers(left, right).size(); i++){
	    	System.out.println(selfDividingNumbers(left, right).get(i));
	    }
	}
}
