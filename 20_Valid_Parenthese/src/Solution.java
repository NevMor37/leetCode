import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
         Stack<Character> stack = new Stack<Character>();
         for(int i=0;i<s.length();i++){
        	 switch(s.charAt(i)){
        	  case'{': stack.push('}');
        	  break;
        	  case'[': stack.push(']');
        	  break;
        	  case '(': stack.push(')');
        	  break;
        	  default:
        		  char temp = s.charAt(i);
        		  if(stack.isEmpty() || (stack.pop() != temp)){
        			  return false;
        		  }
        		  break;
        	 }	  
         }
         if(stack.isEmpty() == false){
        	 return false;
         }
         return true;
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		System.out.println(obj.isValid("["));
	}
}
