import java.util.HashMap;

public class Solution {
//	public int romanToInt(String s) {
//         int res = 0;
//         int []ar = new int [s.length()];
//         for(int i=0;i<s.length();i++){
//        	 int temp;
//        	 switch (s.charAt(i)){
//        	 case 'I': temp = 1;
//        	 break;
//        	 case 'V': temp = 5;
//        	 break;
//        	 case 'X': temp = 10;
//        	 break;
//        	 case 'L': temp = 50;
//        	 break;
//        	 case 'C': temp = 100;
//        	 break;
//        	 case 'D': temp = 500;
//        	 break;
//        	 case 'M': temp = 1000;
//        	 break;
//        	 default: temp = -99;
//        	 break;
//        	 }
//        	 if(temp != -99){
//        		 ar[i] = temp;
//        	 }else{
//        		 return 0;
//        	 }
//         }
//         for(int i=0;i<s.length()-1;i++){
//        	 if(ar[i] < ar[i+1]){
//        		 res-=ar[i];
//        	 }else{
//        		 res+=ar[i];
//        	 }
//         }
//         return res+ar[s.length()-1];
//	}
	public int romanToInt(String s) {
		if(s.length() == 0 || s == null) return 0;
	    HashMap <Character, Integer> m = new HashMap();
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);
		int res = 0;
		for(int i=0;i<s.length()-1;i++){
			if(m.containsKey(s.charAt(i)) && m.containsKey(s.charAt(i+1))){
				int a = m.get(s.charAt(i));
				int b = m.get(s.charAt(i+1));
				if(a>=b) {
					res+=a;
		        }else{
			        res-=a;
		        }
			}
			else return 0;
	    }
		if(m.containsKey(s.charAt(s.length()-1))) {
			res += m.get(s.charAt(s.length()-1));
		}else return 0;
	    return res;
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		String a= "III";
		System.out.println(obj.romanToInt(a));
	}
}
