import java.util.*;
public class Solution {
	public int[] twoSum(int[] nums, int target) {
        int []res = new int[2];
        //笨办法
//        for(int i=0;i<nums.length-1;i++){
//        	for(int j=i+1;j<nums.length;j++){
//        		if(nums[i]+nums[j] == target){
//        			res[0] = i;
//        			res[1] = j;
//        			break;
//        		}
//        	}
//        }
        HashMap <Integer, Integer> m = new HashMap();
        for(int i=0;i<nums.length;i++){
        	if(m.containsKey(target-nums[i])){
        		res[1] = i;
        		res[0] = m.get(target-nums[i]);
        	}
        	m.put(nums[i], i);
        }
        return res;
    }
	public static void main(String[] args){
		Solution obj = new Solution();
		int [] test= {
			2,7,11,15	
		};
		int target = 9;
		int [] res = obj.twoSum(test, target);
		for(int element : res){
			System.out.printf("%d ", element);
		}
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}
}
