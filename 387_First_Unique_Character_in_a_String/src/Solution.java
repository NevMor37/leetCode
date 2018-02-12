//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
public class Solution {
	public int firstUniqChar(String s) {
		 int [] record = new int [26];
		 int ans = -1;
         for(int i= 0;i<s.length();i++){
        	  record[s.charAt(i) - 'a']++;
         }
         for(int i =0;i<s.length();i++){
        	 if(record[s.charAt(i) - 'a'] == 1){
        		  ans = i;
        		  break;
        	 }
         }
         System.out.println(ans);
         return ans;
	}
	public static void main(String [] args){
		 String test = "loveleetcode";
		 Solution obj = new Solution();
		 obj.firstUniqChar(test);
	}
}
