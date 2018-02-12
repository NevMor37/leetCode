/*
 Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
 */
  class Solution {

	public boolean isAnagram(String s, String t) {
                  int []a = new int[26];
                  //System.out.println('z'-'a');
                  if(s.length() != t.length()) return false;
                  for(int i= 0;i<s.length(); i++){
                	   a[s.charAt(i) - 'a']++;
                	   a[t.charAt(i) - 'a']--;               	   
                  }
                  for(int i : a){
                	  if(i != 0){
                		  return false;
                	  }
                  }
                  return true;
	}

	public static void main(String[] args) {
		    String test1 = "anagram";
		    String test2 = "nagarak";
            Solution obj = new Solution();
            System.out.println(obj.isAnagram(test1, test2));
	}
}
