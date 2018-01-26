
public class Solution {
	public String addBinary(String a, String b) {
          //int longerLength = Math.max(a.length(), b.length());
		  int lengtha = a.length()-1;
		  int lengthb = b.length()-1;
          StringBuilder ans = new StringBuilder();
          int carry = 0;
          int sum = 0;
          while(lengtha >= 0 || lengthb >=0){
        	  sum+= carry;
        	  carry = 0;
        	  sum = sum+ ((lengtha >= 0) ? Character.getNumericValue(a.charAt(lengtha)): 0);
        	  sum = sum+ ((lengthb >= 0) ? Character.getNumericValue(b.charAt(lengthb)): 0);
        	  if(lengtha >=0){lengtha--;}
        	  if(lengthb >=0){lengthb--;}
        	  
        	  carry = (sum>=2) ? 1 : 0;
        	  sum = sum % 2;
        	  ans.append(sum);
        	  sum = 0;
          }
          if (carry ==1){
        	  ans.append("1");
          }
          return ans.reverse().toString();
	}
	public static void main(String[] args) {
             String a = "11";
             String b = "1";
             Solution obj = new Solution ();
             System.out.println(obj.addBinary (a,b));       
	}
}
