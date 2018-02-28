//167. Two Sum II - Input array is sorted 
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int l = 0, r = numbers.length - 1;
		int ans[] = new int[2];
		while (l < r) {
			if (numbers[l] + numbers[r] == target) {
				ans[0] = l + 1;
				ans[1] = r + 1;
				return ans;
			} else if (numbers[l] + numbers[r] < target) {
				l++;
			} else if (numbers[l] + numbers[r] > target) {
				r--;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] test = new int[] { 2, 7, 11, 15 };
		Solution obj = new Solution();
		int[] arr = obj.twoSum(test, 9);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
