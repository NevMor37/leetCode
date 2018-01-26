
public class Solution {
	public boolean isPalindrome(int x) {
            String temp = Integer.toString(x);
            if(isP(temp) == true) return true;
            return false;
            
	}
	public boolean isP(String x){
		 if(x.length() <= 1){
			 return true;
		 }else if(x.length()>1){
			 if(x.charAt(0) == x.charAt(x.length()-1)){
				 return isP(x.substring(1, x.length()-1));//start index include, end index exclude
			 } 
		 }
		 return false;
	}

	public static void main(String[] args) {
         Solution obj = new Solution();
         System.out.println(obj.isPalindrome(123421));
	}
}
