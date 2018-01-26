
public class Solution2 {
      public boolean isPalindrome(int x){
    	  int [] temp = new int [100];
    	  int count =0;
    	  while(x>0){
    		  temp[count] = x%10;
    		  x= x/10;
    		  count++;
    	  }
    	  for(int i=0;i<count;i++){
    		  if(temp[i] != temp[count-1-i]){
    			  return false;
    		  }
    	  }
    	  return true;
      }
      public static void main(String [] args){
    	  Solution2 obj = new Solution2();
    	  System.out.println(obj.isPalindrome(123454321));
      }
}
