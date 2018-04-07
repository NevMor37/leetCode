
public class Solution {
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0 || nums == null) {
			return new int[] { -1, -1 };
		}
		int start = findFirst(nums, target);
		if (start == -1)
			return new int[] { -1, -1 };
		int end = findLast(nums, target);
		return new int[] { start, end };
	}

	private int findFirst(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] >= target) {
				//在找到位置后， 继续找，并将右指针左移， 这样才能保证最左边的值被找到， 此写法会让递归函数彻底执行完
				end = mid;
			} else {
				start = mid;
			}
		}
		if (nums[start] == target)
			return start;
		if (nums[end] == target)
			return end;
		return -1;
	}

	private int findLast(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[end] == target)
			return end;
		if (nums[start] == target)
			return start;
		return -1;
	}

	public static void main(String[] args) {
           Solution obj = new Solution();
           int [] test = new int [] {
        	 5, 7, 7, 8, 8, 10
           };
           int [] testRes = obj.searchRange(test, 8);
           System.out.println(testRes[0] + " " + testRes[1]);
	}
}
