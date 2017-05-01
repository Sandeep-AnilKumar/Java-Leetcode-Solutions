package Contest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] findNums = {4,1,2};
		int[] nums = {1,3,4,2};
		int[] result = nextGreaterElement(findNums, nums);
		for(int i: result) {
			System.out.println(i);
		}
	}

	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
		if(findNums == null || findNums.length == 0 || nums == null || nums.length == 0) {
			return new int[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		Deque<Integer> stack = new ArrayDeque<>();

		int length = nums.length;
		stack.offerFirst(nums[length - 1]);
		map.put(nums[length - 1], -1);

		for(int i = length - 2; i >= 0; --i) {
			if(nums[i] > stack.peekFirst()) {
				while(!stack.isEmpty() && stack.peekFirst() <= nums[i]) {
					stack.pollFirst();
				}
				if(stack.isEmpty()) {
					map.put(nums[i], -1);
				} else {
					map.put(nums[i], stack.peekFirst());
				}
			} else {
				map.put(nums[i], stack.peekFirst());
			}
			stack.offerFirst(nums[i]);
		}

		int findNumsLength = findNums.length;
		int[] result = new int[findNumsLength];
		for(int i = 0; i < findNumsLength; ++i) {
			result[i] = map.get(findNums[i]);
		}
		return result;
	}
}
