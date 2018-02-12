
public class Solution {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
            int res = 0;
            int temp1 = n;
            int temp2 = 0;
            for(int i=0;i<32;i++){
            	 temp2 = temp1 & 1;
            	 temp1>>>=1;//无符号右移， 空位以0补齐
            	 res+=temp2;
            	 if(i<31){
            		 res<<=1;
            	 }
            }
            System.out.println(res);
            return res;
	}
	public static void main(String [] args){
		 Solution obj = new Solution();
		 obj.reverseBits(43261596);
	}
}
