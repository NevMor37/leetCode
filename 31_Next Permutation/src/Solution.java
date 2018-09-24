
public class Solution {
	public void nextPermutation(int[] nums) {
        int l = 0, r = 0;
        for(int i = nums.length -2; i>=0;i--) {
            if(nums[i] < nums[i+1]) {
                l = i;
                break;
            }
            else if(i == 0 && nums[i] >= nums[i+1]) {
                l =0;
                r = nums.length-1;
                while(l < r) {
                    swap(nums, l , r);
                    l++;
                    r--;
                }
                return;
            }
        }
        for(int i = nums.length -1; i>l;i--) {
            if(nums[i] > nums[l]) {
                r = i;
                break;
            }
        }
        //System.out.println(r);
        //System.out.println(l);
        swap (nums, l , r);
        l++;
        r = nums.length-1;
        while(l < r) {
            swap(nums, l , r);
            l++;
            r--;
        }
    }
    private void swap (int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String [] args) {
    	Solution obj = new Solution();
    	int [] nums = {
    			//4,2,0,2,3,2,0
    			2,3,1
    	};
    	obj.nextPermutation(nums);
    	for(int e : nums) {
    		System.out.printf("%d ", e);
    	}
    }
}
