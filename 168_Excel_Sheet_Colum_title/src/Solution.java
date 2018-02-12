//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
public class Solution {
	public String convertToTitle(int n) {
              StringBuilder res = new StringBuilder();
              while(n>0){
            	  n--;
            	  res.insert(0, (char)('A' + n % 26));
            	  n/=26;
              }
              return res.toString();
              
	}

	public static void main(String[] args) {

	}
}
