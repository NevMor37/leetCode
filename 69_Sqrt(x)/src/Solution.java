
public class Solution {
	public int mySqrt(int x) {
		   if(x == 1 || x==2 || x == 3){
			   return 1;
		   }
		   if(x == 5){
			   return 2;
		   }
           int left = 1,
           right = x;
           if(x == 0){
        	   return 0;
           }
           while(true){
        	   int mid = left + (right-left)/2;
        	   if(mid > x/mid){
        		   right = mid-1;
        	   }else{
        		   if((mid+1) > x/(mid+1)){
        			   return mid;
        		   }
        		   left = mid+1;
        	   }
           }
      
	}
	public static void main(String [] args){
		   Solution obj = new Solution();
		   System.out.println(obj.mySqrt(8));
	}
}
