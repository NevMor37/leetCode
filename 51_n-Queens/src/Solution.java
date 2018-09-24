import java.util.*; 
public class Solution {
	public List<List<String>> solveNQueens(int n) {
        List<List <String>> res = new ArrayList<>();
        if(n == 1) {
        	List<String> temp = new ArrayList<>();
        	temp.add("Q");
        	res.add(temp);
        	return res;
        }
        if(n<4) return res;
        int [] map = new int [n];
        helper (res, map, 0);
        return res;
    }
    private void helper(List<List <String>> res, int [] map, int index) {
        if(index == map.length) {
            res.add(generateString(map));
            return;
        }
        for(int i=0;i<map.length;i++) {
            map[index] = i;
            if(validateRow(index, map)) {
                helper (res, map, index+1);
            }
        }
    }
    private List<String> generateString(int [] map) {
        List <String> res = new ArrayList <>();
        for(int i=0;i<map.length;i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j=0;j<map.length;j++) {
        		if(j != map[i]) sb.append('.');
        		else sb.append('Q');
        	}
        	res.add(sb.toString());
        }
        return res;
    }
    private boolean validateRow(int row, int [] map) {
    	boolean ans = true;
    	for(int i=0;i<row;i++) {
    		if(map[row] == map[i] || Math.abs(row-i) == Math.abs(map[row]-map[i])) {
    			ans = false;
    		}
    	}
    	return ans;
    }
    public static void main (String [] args) {
    	Solution obj = new Solution ();
//    	int [] testG = {0,1,2,3};
//    	List<String> resG = obj.generateString(testG);
//    	for(String e : resG) {
//    		System.out.printf("%s ", e);
//    	}
    	
//    	int [] testV = {1,3,0,2};
//    	System.out.println(obj.validateRow(3, testV));
    	List<List<String>> testN = obj.solveNQueens(4);
    	for(List<String> e1 : testN) {
    		for(String e2 : e1) {
    			System.out.println(e2);
    		}
    		System.out.println();
    	}
    }
}
