package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithKDifferentIntegers {
	public int subarraysWithKDistinct(int[] A, int K) {
		Window window1 = new Window();
		Window window2 = new Window();
		int ans = 0, left1 = 0, left2 = 0;

		for (int right = 0; right < A.length; ++right) {
			int x = A[right];
			window1.add(x);
			window2.add(x);

			while (window1.different() > K)
				window1.remove(A[left1++]);
			while (window2.different() >= K)
				window2.remove(A[left2++]);

			ans += left2 - left1;
		}

		return ans;
	}

	public int subarraysWithKDistinctBetter(int[] nums, int k) {
		return atMost(nums, k) - atMost(nums, k - 1);
	}

	private int atMost(int[] nums, int k) {
		int length = nums.length, left = 0, cur = 0, total = 0;
		int[] counts = new int[length + 1];

		for (int right = 0; right < length; ++right) {
			if (counts[nums[right]] == 0) {
				cur++;
			}
			counts[nums[right]]++;

			while (cur > k) {
				counts[nums[left]]--;
				if (counts[nums[left]] == 0) {
					cur--;
				}
				left++;
			}

			total += right - left + 1;
		}
		return total;
	}

	public void main(String[] args) {
		SubarrayWithKDifferentIntegers subarray = new SubarrayWithKDifferentIntegers();
		int[] A = {1, 2, 3, 3, 2, 1, 2};
		int K = 3;

		System.out.println("Subarrays with K different integers are := " + subarray.subarraysWithKDistinct(A, K));
	}

	class Window {
		private final Map<Integer, Integer> count;
		private int nonzero;

		Window() {
			count = new HashMap<>();
			nonzero = 0;
		}

		void add(int x) {
			count.put(x, count.getOrDefault(x, 0) + 1);
			if (count.get(x) == 1)
				nonzero++;
		}

		void remove(int x) {
			count.put(x, count.get(x) - 1);
			if (count.get(x) == 0)
				nonzero--;
		}

		int different() {
			return nonzero;
		}
	}
}
