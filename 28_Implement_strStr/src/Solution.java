
public class Solution {
	public int strStr(String haystack, String needle) {
		int res = 0;
		//System.out.println(haystack.length()-needle.length());
		if(haystack.length()<needle.length()) return -1;
		for(int i = 0; i<=haystack.length()-needle.length();i++){
			    String temp = haystack.substring(i, i+needle.length());
			    if(temp.equals(needle)){
			    	res = i;
			    	break;
			    }	
			    if(i == (haystack.length()-needle.length()) && !temp.equals(needle) ){
			    	return -1;
			    }
		}
		return res;
	}

	public static void main(String[] args) {
           Solution obj = new Solution();
           System.out.println(obj.strStr("hello", "ll"));
           //System.out.println("mississippi".substring(9, 11));
	}
}
