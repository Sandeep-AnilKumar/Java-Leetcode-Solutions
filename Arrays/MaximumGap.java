package Arrays;

public class MaximumGap {

	public static void main(String[] args) {
		int[] nums = new int[]{4,1,7,5,2,4,21};
		System.out.println("The maximum gap is: " + maximumGap(nums));
	}

	public static int maximumGap(int[] nums) {
		if(nums == null || nums.length < 2) {
			return 0;
		}

		int length = nums.length;
		int[] aux = new int[nums.length];
		int exp = 1;
		int max = nums[0];
		for(int i = 1; i < length; ++i) {
			max = Math.max(max, nums[i]);
		}

		while(max / exp > 0) {
			int[] count = new int[10];
			for(int i = 0; i < length; ++i) {
				count[(nums[i]/exp) % 10]++;
			}

			for(int i = 1; i < 10; ++i) {
				count[i] += count[i-1];
			}

			for(int i = nums.length - 1; i >= 0; --i) {
				aux[--count[(nums[i]/exp) % 10]] = nums[i];
			}

			for(int i = 0; i < length; ++i) {
				nums[i] = aux[i];
			}

			exp *= 10;
		}

		int gap = Integer.MIN_VALUE;
		for(int i = 1; i < length; ++i) {
			gap = Math.max(nums[i] - nums[i-1], gap);
		}
		return gap;
	}//Radix sort, complexity O(10n) == O(n);
}
