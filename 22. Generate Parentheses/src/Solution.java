//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
import java.util.*;
public class Solution {
	public List<String> generateParenthesis(int n) {
           List <String> ans = new ArrayList<String>();
           if(n == 0) return ans;
           helper(ans, 0, 0, "",n);
           return ans;
	}
	public void helper(List<String> ans,int left,int right, String curr, int n ){
		      if(curr.length() == n * 2){
		    	     ans.add(curr);
		    	     return;
		      }
		      if(left < n){
		    	  helper(ans, left+1, right, curr+'(', n);
		      }
		      //注意这里不能改变curr的值， 因为要方便其他分支的正确性，所以只能在传递参数的时候手动加上左括号或者右括号
		      if(right < left){
		    	  helper(ans, left, right+1, curr + ')', n);
		      }
	}
    public static void main(String [] args){
    	  Solution obj = new Solution();
    	  List<String> test = obj.generateParenthesis(3);
    	  for(String i : test){
    		    System.out.println(i);
    	  }
    }
}
