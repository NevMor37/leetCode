
public class Solution {
	public String countAndSay(int n) {
		if(n == 0){
			 return "";
		}
		else if(n == 1){
			return "1";
		}
        StringBuilder ans = new StringBuilder("1");
          
          for(int i = 1;i<n;i++){
        	  String prev = ans.toString();
        	  ans = new StringBuilder();
        	  char say = prev.charAt(0);
        	  int count =0;
        	  for(int j = 0;j<prev.length();j++){
        		  if(say == prev.charAt(j)){
        			  count++;
        		  }else{
        			  ans.append(count);
        			  ans.append(say);
        			  say = prev.charAt(j);
        			  count = 1;
        		  }
        	  }
        	  ans.append(count);
        	  ans.append(say);      	  
          }
          return ans.toString();
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		System.out.println(obj.countAndSay(6));
	}
}
