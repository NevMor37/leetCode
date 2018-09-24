import java.util.*;
public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '{' || s.charAt(i) == '[' ||s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}
			else if(stack.isEmpty()) {return false;}
			else if(s.charAt(i) == ')') {
				if(stack.peek() != '(') return false;
				stack.pop();
			}
			else if(s.charAt(i) == ']') {
				if(stack.peek() != '[') return false;
				stack.pop();
			}
			else if(s.charAt(i) == '}') {
				if(stack.peek() != '{') return false;
				stack.pop();
			}
		}
		if(stack.isEmpty()) return true;
		return false;
	}
	public static void main(String [] args) {
		Solution obj = new Solution();
		obj.isValid("()[]{}");
	}
}
