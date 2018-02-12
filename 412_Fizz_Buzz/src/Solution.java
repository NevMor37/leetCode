import java.util.*;
public class Solution {
	public List<String> fizzBuzz(int n) {
        List <String> ans = new ArrayList<>(n);
        if(n<=0) return null;
        for(int i= 1;i<=n;i++){
        	if(i%3 ==0 && i%5 == 0){
        		ans.add("FizzBuzz");
        	}else if(i % 3 == 0){
        		ans.add("Fizz");
        	}else if(i % 5 == 0){
        		ans.add("Buzz");
        	}else{
        		ans.add(Integer.toString(i));
        	}
        }
        return ans;
	}
	public static void main(String [] args){
		 Solution obj = new Solution();
		 List<String> test = obj.fizzBuzz(15);
		 for(String s : test){
			 System.out.println(s);
		 }
		 
	}
}
