import java.util.*;
class MinStack {
	Stack<Integer> stack;
	int minValue = Integer.MAX_VALUE;
    public MinStack() {
      stack = new Stack<Integer>(); 
    }
    
    public void push(int x) {
    	//Only under the condition that the new pushed value will 
    	//affect the minValue, that we will push the minValue under and then the new element.
    	//when we pop when found that the poped item is equal to the min value , we pop twice and maintain
    	//the new min value, so on and so forth. And the next second min value will be under the new minvalue. 
    	if(minValue > x){
    		stack.push(minValue);
    		minValue = x;
    	}
        stack.push(x);
    }
    
    public void pop() {
        int temp = stack.pop();
        if(temp == minValue){
        	minValue = stack.pop();
        }
    }
    
    public int top() {
    	int res = 0;
    	if(!stack.isEmpty()){
        	res = stack.peek();
        }
    	return res;
    }
    
    public int getMin() {
        return minValue;
    }
    public static void main(String []orgs){
    	 MinStack obj = new MinStack();
    	 obj.push(99);
    	 obj.push(55);
    	 obj.push(33);
    	 obj.pop();
    	 System.out.println(obj.top());
    	 System.out.println(obj.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */