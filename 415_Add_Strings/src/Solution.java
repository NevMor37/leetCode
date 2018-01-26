
public class Solution {
	public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int l1 = num1.length()-1;
        int l2 = num2.length()-1;
        int check = 0;
        while(l1>0 || l2>0){
        	int sum = ((l1 > 0) ? Character.getNumericValue(num1.charAt(l1)) : 0) + 
        			((l2 > 0) ? Character.getNumericValue(num2.charAt(l2)) : 0) + check;
        	check = 0;
        	if (sum >=10){
        		check =1;
        	}
        	res.append(sum);
        }
        return res.toString();
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		String a = "1234";
		String b = "5678";
		System.out.println(obj.);
	}
}
