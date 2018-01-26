import java.util.Scanner;
public class Solution {
	public String reverseString(String s) {
         StringBuilder m = new StringBuilder();
         for(int i= s.length()-1;i>=0;i--){
        	 m.append(s.charAt(i));
         }
         return m.toString();
	}
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();
		Solution obj = new Solution();
		System.out.println(obj.reverseString(test));
	}
}
