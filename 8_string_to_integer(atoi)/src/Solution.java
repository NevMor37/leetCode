public class Solution {
     public int myAtoi(String str){
    	 if(str.length() == 0) {return 0;}
    	 int firstIndex = 0;
    	 while(str.charAt(firstIndex) == ' '){
    		 firstIndex++;
    	 }
    	 //System.out.println(str);
    	 int sign = (str.charAt(firstIndex) == '-') ? -1 : 1;
    	 int ans = 0;
    	 firstIndex += (str.charAt(firstIndex) == '-' || str.charAt(firstIndex)=='+') ? 1 : 0;
    	 //System.out.println(firstIndex);
    	 //System.out.println(sign);
    	 for(int i = firstIndex; i<str.length();i++){
    		  if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
    			  if((Integer.MAX_VALUE)/10 <= ans && (str.charAt(i)-'0')>(Integer.MAX_VALUE%10)){
    				  return Integer.MAX_VALUE * sign;
    			  }
    			  ans = (ans*10) + (str.charAt(i) - '0');
    		  }else{
    			  break;
    		  }
    	 }
    	 return sign * ans;
     }
     public static void main(String [] args){
    	 //substraction between ASCI code would be the numeric number of the integer
    	 /*
    	   char c = '9'; 
    	   int a= c -'0'; 
    	   System.out.println(a);
    	 String test = "Hello Shubin Wu.";
    	 test = test.replaceAll("\\s","");
    	 System.out.println(test);*/
    	 Solution obj = new Solution();
    	 System.out.println(Integer.MAX_VALUE);
    	 System.out.println(obj.myAtoi("2147483648"));
    	 
     }
}
