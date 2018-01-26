import java.util.Scanner;
import java.lang.Math.*;
public class Solution {
public int findComplement(int num) {
        int res =0;
        int [] nArray = new int[100];
        int [] newNum = new int[100];
        int ind = 0;
        while(num!=0){
        	if(num % 2 == 1){
        		newNum[ind] = 1;
        	}else{
        		newNum[ind] = 0;
        	}
        	num = num/2;
        	ind++;
        }
        /*
        for(int i=0;i<ind;i++){
        	newNum[i] = nArray[ind-i-1];
        }  
        for(int i =0;i<ind; i++)
        {
        	System.out.println(newNum[i]);
        }
         */
        for(int i=0;i<ind;i++){
        	if(newNum[i]==1){
        		newNum[i] = 0;
        	}else
        		newNum[i] =1;
        }
        /*
        for(int i =0;i<ind; i++)
        {
        	System.out.println(newNum[i]);
        }
        */
        for(int i=0;i<ind;i++){
         res += newNum[i]*(java.lang.Math.pow(2,i));
        }
       // System.out.println(res);
        return res;
        
    }
  public static void main(String [] args){
	    Scanner sc = new Scanner(System.in);
	    int test = sc.nextInt();
	    Solution obj = new Solution();
	    obj.findComplement(test);
	    //System.out.println(java.lang.Math.pow(2, 1));
  }
}
