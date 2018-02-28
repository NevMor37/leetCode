import java.util.*;
public class Solution {
	private String [] mapping  = new String[]{
	   "0", "1", "abc", "def","ghi", "jkl","mno", "pqrs", "tuv", "wxyz"
	};
	public List<String> letterCombinations(String digits) {
           List<String> ans = new ArrayList<>();
           if(digits.length() == 0 || digits == null) return ans;
           helper(ans, digits, "", 0);
           return ans;
	}
	public void helper(List<String> ans, String digits, String curr, int index) {
		  if(curr.length() == digits.length()){
			     ans.add(curr);
			     return;
		  }
		  String temp = mapping[digits.charAt(index) - '0'];
		  for(int i=0;i<temp.length();i++){
			    helper(ans, digits, curr+temp.charAt(i), index+1);
		  }
	}
	public static void main(String [] args){
		 Solution obj = new Solution();
		 List<String> test = obj.letterCombinations("234");
		 for(String i : test){
			 System.out.println(i);
		 }
		 
	}
}
