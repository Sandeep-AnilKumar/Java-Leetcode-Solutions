package Arrays;

/**
 * @author sandeepa
 */

public class KthLargestInArray {

	public static void main(String[] args) {
		int[] nums = {-1, 2, 0};
		int k = 2;
		System.out.println("The " + k + "th largest element in the array is := " + new KthLargestInArray().kLargestElement(nums, k));
	}

	public int kLargestElement(int[] nums, int k) {
		if(nums == null || nums.length == 0) return 0;
		int left = 0;
		int right = nums.length - 1;
		int pos = 0;

		while(true) {
			pos = partition(nums, left, right);
			if(pos == k - 1) break;

			if(pos > k - 1) right = pos - 1;
			else left = pos + 1;
		}
		return nums[pos];
	}

	public int partition(int[] nums, int left, int right) {
		int l = left + 1;
		int r = right;

		while(l <= r) {
			while(l <= r && nums[l] >= nums[left]) l++;
			while(r >= l && nums[r] <= nums[left]) r--;
			if(l > r) break;
			swap(nums, l++, r--);
		}

		swap(nums, left, r);
		return r;
	}

	public void swap(int[] nums, int i, int j) {
		if(i == j) return;
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}
}
