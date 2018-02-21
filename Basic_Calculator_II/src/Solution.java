import java.util.*;
/*
  Algorithm:
  We first process the input expression like:
  +3*5/2-7
  Then we start from the first number, and process through the expression, one thing to mention is that when we 
  encounter an operator, we process the previous operator and then keep the current operator.
 */
public class Solution {
	public int calculate(String s) {
		int ans = 0;
		s = s.replaceAll(" ", "");
		Stack<Integer> stack = new Stack<>();
		if (s.length() == 0)
			return 0;
		int num = 0;
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				// num = num* 10 + s.charAt(i) - '0';
				num = num * 10 + Character.getNumericValue(s.charAt(i));
			}
			if(i == s.length()-1 || !Character.isDigit(s.charAt(i)) ){
				if (sign == '+') {
					stack.push(num);
				}
				if (sign == '-') {
                    stack.push(num * (-1));
				}
				if (sign == '*') {
                    stack.push((stack.pop() * num));
				}
				if (sign == '/') {
					stack.push((stack.pop() / num));
				}
				sign = s.charAt(i);
				num = 0;
			}
		}
		for(int i : stack){
			ans+=i;
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.calculate("3+2*5"));
	}
}
