package Arrays;

public class CircularArrayLoop {

	public static void main(String[] args) {
		int[] nums = {2, -1, 1, -2, -2};
		System.out.println("Is there a loop in this circular array := " + circularArrayLoopBetter(nums));
	}

	//Might not work for all, will fail for forward and backward. Question asks only one direction.
	public static boolean circularArrayLoop(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return false;
		}

		int length = nums.length;
		int total = length;
		int start = 0;
		int next = Integer.MAX_VALUE;
		int prev = Integer.MIN_VALUE;
		int prePrev = Integer.MIN_VALUE;
		while(total-- > 0) {
			if(nums[start] == 0) {
				return true;
			}
			next = nums[start];
			if(next < 0) {
				next += length;
			}
			nums[start] = 0;
			prePrev = prev;
			prev = start;
			start += next;
			start %= length;
			if(prev == start || prePrev == start) {
				break;
			}
		}
		return false;
	}

	//will work for all cases.
	public static boolean circularArrayLoopBetter(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				continue;
			}
			// slow/fast pointer
			int j = i, k = getIndex(i, nums);
			while (nums[k] * nums[i] > 0 && nums[getIndex(k, nums)] * nums[i] > 0) {
				if (j == k) {
					// check for loop with only one element
					if (j == getIndex(j, nums)) {
						break;
					}
					return true;
				}
				j = getIndex(j, nums);
				k = getIndex(getIndex(k, nums), nums);
			}
			// loop not found, set all element along the way to 0
			j = i;
			int val = nums[i];
			while (nums[j] * val > 0) {
				int next = getIndex(j, nums);
				nums[j] = 0;
				j = next;
			}
		}
		return false;
	}

	public static int getIndex(int i, int[] nums) {
		int n = nums.length;
		return i + nums[i] >= 0? (i + nums[i]) % n: n + ((i + nums[i]) % n);
	}
}
