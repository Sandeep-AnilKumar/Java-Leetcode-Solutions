package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class NextGreaterElement2 {

	public static void main(String[] args) {
		int[] nums = {100,1,11,1,120,111,123,1,-1,-100};
		System.out.println("The next greater elements for the array elements in circular fashion are :=");
		int[] result = nextGreaterElements(nums);
		for(int i = 0; i < nums.length; ++i) {
			System.out.print("\"" + nums[i] + "\" := \"" + result[i] + "\"\n");
		}
	}

	//Not the right way, so same occurrences of a number have different greater element, because of their positions in the array. 
	//So change it to the index of the number
	//and not the number itself.
	public static int[] nextGreaterElements(int[] nums) {
		if(nums == null || nums.length == 0) {
			return new int[0];
		}

		int length = nums.length;
		int cirLength = length * 2;
		int[] circularNums = new int[cirLength];

		for(int i = 0; i < cirLength; ++i) {
			if(i > length - 1) {
				circularNums[i] = nums[i - length];
			} else {
				circularNums[i] = nums[i];
			}
		}

		Map<Integer, Integer> map = new HashMap<>();
		map.put(cirLength - 1, -1);

		Deque<Integer> stack = new ArrayDeque<>();
		stack.offerFirst(circularNums[cirLength - 1]);

		for(int i = cirLength - 2; i >=0; --i) {
			if(!stack.isEmpty() && circularNums[i] >= stack.peekFirst()) {
				while(!stack.isEmpty() && circularNums[i] >= stack.peekFirst()) {
					stack.pollFirst();
				}
				if(stack.isEmpty()) {
					map.put(i, -1);
				} else {
					map.put(i, stack.peekFirst());
				}
			} else {
				map.put(i, stack.peekFirst());
			}
			stack.offerFirst(circularNums[i]);
		}

		int[] result = new int[length];
		for(int i = 0; i < length; ++i) {
			result[i] = map.get(i);
		}
		return result;
	}

	//Much more concise solution. Populate stack with indexes rather than the values and use modulus for array manipulations instead of double array.
	public int[] nextGreaterElementsBetter(int[] nums) {
		int[] res = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 2 * nums.length - 1; i >= 0; --i) {
			while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
				stack.pop();
			}
			res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
			stack.push(i % nums.length);
		}
		return res;
	}
}
