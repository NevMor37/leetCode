import java.util.*;
public class Solution {
	public String minWindow(String s, String t) {
		String ans = "";
        if(s == null || s.length() == 0 || t == null || t.length() == 0) {
        	return ans;
        }
        int count = 0;
        int [] cArr = new int [256];
        int [] tArr = new int [256];
        int l = 0, r = 0, minLength = Integer.MAX_VALUE;
        //initialize targetArray
        for(int i=0;i<t.length();i++) {
        	tArr[t.charAt(i)] ++;
        }
        //find the first l;
        l = findNext(0,tArr, s);
        if(l == s.length()) return ans;
        //start working on find the window
        r = l;
        System.out.println(r);
        while (r < s.length()) {
        	if(cArr[s.charAt(r)] < tArr[s.charAt(r)]) {
        		count++;
        	}
        	cArr[s.charAt(r)] ++;
        	while(count == t.length()) {
        		if(minLength > r - l + 1) {
        			minLength = r - l + 1;
        			ans = s.substring(l, r+1);
        		}
        		if(cArr[s.charAt(l)] <= tArr[s.charAt(l)]) {
        			count --;
        		}
        		cArr[s.charAt(l)] --;
        		l = findNext(l + 1, tArr, s);
        	}
        	r = findNext (r + 1, tArr, s); 
        }
        return ans;
    }
	private int findNext (int start, int [] tArr, String s) {
		while(start < s.length()) {
			if(tArr[s.charAt(start)]>0) {
				return start;
			}
			start ++;
		}
		return start;	
	}
	public static void main(String [] args) {
		Solution obj = new Solution();
		System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
	}
}
