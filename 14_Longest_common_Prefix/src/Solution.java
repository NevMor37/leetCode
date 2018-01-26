
public class Solution {
	public String longestCommonPrefix(String[] strs) {
		String ans ="";
		int maxA = 99999;
		if(strs.length == 1){
			return strs[0];
		}
		if(strs.length == 0){
			return ans;
		}
        for(int i=0;i<strs.length-1;i++){
        	for(int j = i+1;j<strs.length;j++){
        		String tempS = comp(strs[i], strs[j]);
        		if(tempS.length()<maxA){
        			maxA = tempS.length();
        			ans = tempS;
        		}
        	}
        }
        return ans;
	}
	public String comp(String a1, String a2){
        StringBuilder res = new StringBuilder();
        String ss;
        String ls;
        ss = (a1.length()>a2.length()) ? a2 : a1;
        ls = (a1.length()>a2.length()) ? a1 : a2;
        //System.out.println(ss);
        //System.out.println(ls);
        for(int i=0;i<ss.length(); i++){
        	
        		if(ss.charAt(i) == ls.charAt(i)){
        			res.append(ss.charAt(i));
        		}else{
        			break;
        		}
        	
        }
        return res.toString();
	}
	public static void main(String [] args){
		String [] test = new String[] {
			"abcdefgh",
			"aefghijk",
			"abcefgh"
				//""
		};
		Solution obj = new Solution();
		System.out.println(obj.longestCommonPrefix(test));
	}
}
