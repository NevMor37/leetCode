
public class Solution {
	/*
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
      
	}*/
	public int mySqrt(int x) {
        if(x <= 0) return 0;
        int left = 1;
        int right = x;
        while (left <= right) {
        	int mid = left + (right-left)/2;
        	if(mid * mid == x) {
        		return mid;
        	}
        	else if(mid * mid < x) {
        		left = mid + 1;
        	}
        	else {
        		right = mid -1;
        	}
        }
        System.out.printf("%d    %d",left, right);
        System.out.println();
        
        if(right * right <x) {
        	return right;
        }
        return left;
    }
	public static void main(String [] args){
		   Solution obj = new Solution();
		   obj.mySqrt(8);
		   obj.mySqrt(26);
		   obj.mySqrt(35);
		   obj.mySqrt(37);
		   //System.out.println(obj.mySqrt(8));
	}
}
