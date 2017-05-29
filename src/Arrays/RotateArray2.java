package Arrays;

public class RotateArray2 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		System.out.print("The rotate array is := ");
		int k = 2;
		rotateBetter(nums, k);
		for(int n: nums) {
			System.out.print(n + " ");
		}
	}

	public static void rotate(int[] nums, int k) {
		if(nums == null || nums.length <= 1 || k <= 0) {
			return;
		}

		int length = nums.length;
		k %= length;
		int count = 0;
		int prev = 0;
		int next = 0;
		int nextNum = 0;
		int first = 0;

		for(int i = 0; count < length && i < length; ++i) {
			first = i;
			prev = nums[i];
			int j = i;
			while(next != first) {
				next = (j + k) % length;
				nextNum = nums[next];
				nums[next] = prev;
				prev = nextNum;
				j = next;
				count++;
			}
		}
		return;
	}

	public static void rotateBetter(int[] nums, int k) {
		if(nums == null || nums.length <= 1 || k <= 0) {
			return;
		}

		int length = nums.length;
		reverseArray(nums, 0, length -1);
		reverseArray(nums, 0, k % length - 1);
		reverseArray(nums, k % length, length - 1);

		return;
	}

	public static void reverseArray(int[] nums, int start, int end) {
		if(nums == null || nums.length == 0 || start >= end) {
			return;
		}

		while(start < end) {
			nums[start] = nums[start] ^ nums[end];
			nums[end] = nums[start] ^ nums[end];
			nums[start] = nums[start++] ^ nums[end--];
		}
		return;
	}
}
