
public class Solution {
	/*
    public boolean isPalindrome(String s){
    	 s = s.replace(" ","");
    	 s = s.replaceAll("[^A-Za-z0-9]","");
    	 s = s.toLowerCase();
    	 return checkPalindrome(s);
    }
    boolean checkPalindrome(String s){
    	if(s.length() <= 1) return true;
    	if(s.length() == 2 && s.charAt(0) == s.charAt(1)) return true; 
    	if(s.charAt(0) == s.charAt(s.length()-1)){
 		   return isPalindrome(s.substring(1,s.length()-1));
 	 }
 	 return false;  
    }*/
	public boolean isPalindrome(String s){
		  s= s.replaceAll("[^A-Za-z0-9]","");
		  s= s.replace(" ","");
		  s = s.toLowerCase();
		  String rev = new StringBuffer(s).reverse().toString();
		  return rev.equals(s) ? true : false;
		  
	}
    public static void main(String [] args){
    	/*
    	 String test = "abcdefg";
    	 System.out.println(test.substring(1, 5));
    	*/
    	String test = "abcdcba";
    	Solution obj = new Solution();
    	System.out.println(obj.isPalindrome(test));
    }
}
