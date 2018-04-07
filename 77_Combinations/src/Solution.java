import java.util.*;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		 List<List<Integer>> ans = new ArrayList<>();
		 if(k == 0) return ans;
		 helper(ans, new ArrayList<>(), n, k, 1);
		 return ans;
	}
	public void helper(List<List<Integer>> ans, List<Integer> cur, int n, int k, int start ){
		 if(k == 0){
			   ans.add(new ArrayList<>(cur));
			   return;
		 }
		 for(int i=start;i<=n;i++){
			   cur.add(i);
			   helper(ans, cur, n, k-1, i+1);
			   cur.remove(cur.size()-1);
		 }
	}
	public static void main(String [] args){
		Solution obj = new Solution();
		List<List<Integer>> test = obj.combine(5, 4);
		for(int i = 0;i<test.size();i++){
			for(int j= 0;j<test.get(i).size();j++){
				System.out.printf("%d ", test.get(i).get(j));
			}
			System.out.println();
		}
	}
}
