
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
//	public boolean isPalindrome(String s){
//		  s= s.replaceAll("[^A-Za-z0-9]","");
//		  s= s.replace(" ","");
//		  s = s.toLowerCase();
//		  String rev = new StringBuffer(s).reverse().toString();
//		  return rev.equals(s) ? true : false;
//		  
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean isPalindrome(String s) {
		s=s.replaceAll("[^0-9a-zA-Z]", "");
        s = s.toLowerCase();
        //System.out.println(s);
        return helper(s);
    }
	
	private boolean helper(String s) {
		if(s == null || s.length() ==1 || s.length()==0) return true;
		if(s.charAt(0) == s.charAt(s.length()-1)) {
			String res = s.substring(1, s.length()-1);
			return helper(res);
		}
		return false;
 	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public static void main(String [] args){
    	/*
    	 String test = "abcdefg";
    	 System.out.println(test.substring(1, 5));
    	*/
    	String test = "A man, a plan, a canal: Panama";
    	Solution obj = new Solution();
    	System.out.println(obj.isPalindrome(test));
    	//System.out.println(test.substring(1, test.length()-1));
    }
}
