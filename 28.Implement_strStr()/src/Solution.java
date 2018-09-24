import java.util.*;
public class Solution {
	public int strStr(String haystack, String needle) {
		int ans = 0;
		if(needle.equals("")) return ans;
		int l = needle.length();
		for(int i=0;i<=haystack.length()-l;i++){
			for(int j = 0;j<l;j++){
				if(haystack.charAt(i+j) != needle.charAt(j)) break;
				if((j == l-1) && haystack.charAt(i+j) == needle.charAt(j)){
					return i;
				}
			}
		}
		return -1;
	}
	public static void main(String [] args) {
		Solution obj = new Solution();
		System.out.println(obj.strStr("aa","aa"));
	}
}
