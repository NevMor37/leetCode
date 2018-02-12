import java.util.*;
public class Solution {
	public boolean isHappy(int n) {
         HashMap<Integer, Integer> map = new HashMap<>();
         if(n == 1){
        	 return true;
         }
         map.put(n, n);
         int temp = n;
         while(true){
        	  temp = helper(temp);
        	  if(map.containsKey(temp)){
        		  return false;
        	  }
        	  if(temp == 1){
        		  return true;
        	  }
        	  map.put(temp, temp);
         }
	}

	public int helper(int n) {
		 int res = 0;
         while(n!=0){
        	 res += Math.pow((n%10), 2);
        	 n/=10;
         }
        // System.out.println(res);
         return res;
	}

	public static void main(String[] args) {
            Solution obj = new Solution();
            System.out.println(obj.isHappy(1));
           
	}
}
