package Arrays;

import java.util.Arrays;

public class ValidTriangleNumber {

	public static void main(String[] args) {
		ValidTriangleNumber count = new ValidTriangleNumber();
		int[] nums = {48,66,61,46,94,75};
		System.out.println("The number of valid triangles are := " + count.triangleNumber(nums));
	}

	public int triangleNumber(int[] nums) {
		int result = 0;
		if (nums.length < 3) return result;

		Arrays.sort(nums);

		for (int i = 2; i < nums.length; i++) {
			int left = 0, right = i - 1;
			while (left < right) {
				if (nums[left] + nums[right] > nums[i]) {
					result += (right - left);
					right--;
				}
				else {
					left++;
				}
			}
		}
		return result;
	}

	//Easier to understand
	public int triangleNumberEasier(int[] nums) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
				while (k < nums.length && nums[i] + nums[j] > nums[k])
					k++;
				count += k - j - 1;
			}
		}
		return count;
	}
}
