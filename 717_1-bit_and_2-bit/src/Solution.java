
public class Solution {
	public boolean isOneBitCharacter(int[] bits) {
           boolean ans = true;
           int i=0;
           while(i<bits.length){
        	   if(i == bits.length-2 && bits[i] == 1){
        		   ans = false;
        	   }if(bits[i] == 0){
        		   i++;
        	   }else if(bits[i] == 1){
        		   i = i+2;
        	   }
           } 
           return ans;
	}

	public static void main(String[] args) {
          int [] test = new int[] {1,0,0};
          Solution obj = new Solution();
          System.out.println(obj.isOneBitCharacter(test));
	}
}
