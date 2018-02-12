import java.util.Scanner;

public class Solution {
	public String reverseWords(String s) {
		StringBuilder ans = new StringBuilder();
		int mark = 0;
		int check = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ' && check == 0) {
				for (int j = i - 1; j >= mark; j--) {
					ans.append(s.charAt(j));
				}
				mark = i + 1;
				check = 1;
			} else if (s.charAt(i) == ' ' && check == 1) {
				for (int j = i; j >= mark; j--) {
					ans.append(s.charAt(j));
				}
				mark = i + 1;
				check = 1;
			}
			if (i == s.length() - 1) {
				if(check != 0){
				ans.append(" ");}
				for (int j = i; j >= mark; j--) {
					ans.append(s.charAt(j));
				}
			}

		}
		return ans.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();
		Solution obj = new Solution();
		System.out.println(obj.reverseWords(test));
	}
}
