
public class Solution {
	private int lo;
	private int maxLen = Integer.MIN_VALUE;
	public String longestPalindrome(String s) {
		if(s.length() < 2) {
			return s;
		}
            for(int i=0;i<s.length()-1;i++) {
            	  helper(i, i, s);
            	  helper(i, i+1, s);
            }
            System.out.println(s.substring(lo, lo+maxLen));
            return s.substring(lo, lo + maxLen);
	}
	private void helper(int left, int right, String s){
		   while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
				   left --;
				   right ++;   	  
		   }
		   int temp = right - left - 1;
		   if(temp > maxLen) {
			      maxLen = temp;
			      lo = ++left;			      
		   }
	}

	public static void main(String[] args) {	
		Solution obj = new Solution();
		obj.longestPalindrome("babad");
	}
}
