
public class Solution {
	public int romanToInt(String s) {
         int res = 0;
         int []ar = new int [s.length()];
         for(int i=0;i<s.length();i++){
        	 int temp;
        	 switch (s.charAt(i)){
        	 case 'I': temp = 1;
        	 break;
        	 case 'V': temp = 5;
        	 break;
        	 case 'X': temp = 10;
        	 break;
        	 case 'L': temp = 50;
        	 break;
        	 case 'C': temp = 100;
        	 break;
        	 case 'D': temp = 500;
        	 break;
        	 case 'M': temp = 1000;
        	 break;
        	 default: temp = -99;
        	 break;
        	 }
        	 if(temp != -99){
        		 ar[i] = temp;
        	 }else{
        		 return 0;
        	 }
         }
         for(int i=0;i<s.length()-1;i++){
        	 if(ar[i] < ar[i+1]){
        		 res-=ar[i];
        	 }else{
        		 res+=ar[i];
        	 }
         }
         return res+ar[s.length()-1];
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		String a= "IV";
		System.out.println(obj.romanToInt(a));
	}
}
