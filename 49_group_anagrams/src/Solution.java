
//Given an array of strings, group anagrams together.
//
//For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
//Return:
//
//[
//  ["ate", "eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//Note: All inputs will be in lower-case.
//对每个字符串排序进行解决
import java.util.*;

public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            if(strs.length == 0 || strs == null) return ans;
            HashMap<String, Integer> map = new HashMap<>();
            for(String str : strs){
            	//Sort the string and reform the string 
            	 char [] ch = str.toCharArray();
            	 Arrays.sort(ch);
            	 String s = new String (ch);
            	 if(map.containsKey(s)){
            		  List<String> list = ans.get(map.get(s));
            		  list.add(str);
            	 }else{
            		  List<String> list = new ArrayList<>();
            		  list.add(str);
            		  map.put(s, ans.size());
            		  ans.add(list);
            	 }
            }
            return ans;
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		String [] strs = new String []{
			"eat", "tea", "tan", "ate", "nat", "bat"	
		};
		List<List<String>> test = obj.groupAnagrams(strs);
		for(int i=0;i<test.size();i++){
			 for(int j= 0;j<test.get(i).size();j++){
				 System.out.printf("%s ", test.get(i).get(j));
			 }
			 System.out.println();
		}
	}
}
