package DynamicProgramming;

import java.util.TreeMap;

public class OddEvenJump {
	public static void main(String[] args) {
		OddEvenJump oddEvenJump = new OddEvenJump();
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println(oddEvenJump.oddEvenJumps(nums));
	}

	public int oddEvenJumps(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		TreeMap<Integer, Integer> last = new TreeMap<>();

		int length = nums.length, count = 0;
		last.put(nums[length - 1], length - 1);

		boolean[] odd = new boolean[length];
		boolean[] even = new boolean[length];
		odd[length - 1] = even[length - 1] = true;

		for (int i = length - 2; i >= 0; --i) {

			if (last.containsKey(nums[i])) {
				odd[i] = even[last.get(nums[i])];
				even[i] = odd[last.get(nums[i])];

			} else {
				Integer high = last.higherKey(nums[i]);
				odd[i] = high != null && even[last.get(high)];

				Integer low = last.lowerKey(nums[i]);
				even[i] = low != null && odd[last.get(low)];
			}

			last.put(nums[i], i);
		}

		for (int i = 0; i < length; ++i) {
			if (odd[i]) count++;
		}
		return count;
	}
}
