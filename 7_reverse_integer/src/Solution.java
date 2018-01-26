import java.lang.*;
public class Solution {
	public int reverse(int x) {
		if (x>=2147483647 || x<=-2147483647){
			return 0;
		}
		int check =0;
		if(x>0){
			check = 1;
		}
		x= Math.abs(x);
		int [] temp = new int[11];
		int res = 0;
		int count =0;
		while(x>0){
			temp[count] = x%10;
			x/=10;
			count++;
		}
		for(int i=0; i<count;i++){
			res += temp[i] * Math.pow(10,count-i-1);
			if(res >= Integer.MAX_VALUE || res<= Integer.MIN_VALUE){
				return 0;
			}
			//System.out.println(temp[i]);
		}
		if(check == 0){
			return -res;
		}
		return res;
	}

	public static void main(String[] args) {
		  Solution obj = new Solution ();
		  System.out.println(obj.reverse(1534236469));
	}
}
