import java.util.Scanner;
class Solution{
	public String reverseString(String s){
		StringBuilder ans = new StringBuilder();
		for(int i = s.length()-1;i>=0;i--){
			ans.append(s.charAt(i));
		}
		return ans.toString();
	}
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		String test = scan.nextLine();
		Solution obj = new Solution();
		System.out.println(obj.reverseString(test));
	}
}