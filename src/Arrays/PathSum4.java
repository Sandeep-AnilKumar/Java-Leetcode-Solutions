package Arrays;

import java.util.HashMap;
import java.util.Map;

public class PathSum4 {

	public static void main(String[] args) {
		PathSum4 sum = new PathSum4();
		int[] nums=  {113, 215, 221, 312, 324, 346};
		System.out.println("The root to leaf path sums is := " + sum.pathSumBetter(nums));
	}

	//Will not work if tree is not balanced.
	public int pathSum(int[] nums) {
		if(nums == null || nums.length == 0 || nums[0] == 0) return 0;
		Map<Integer, Integer> path = new HashMap<>();

		int max = 1;
		int curSum = 0;
		int nextLevel = 0;
		int nextChild = 0;
		int curValue = 0;
		path.put(11, 0);

		for(int i = 0; i < nums.length; ++i) {
			curSum = nums[i];
			curValue = curSum % 10;

			curValue += path.get(curSum / 10);
			path.put(curSum / 10, curValue);
			max = Math.max(max, curSum / 100);

			nextLevel = curSum / 100 + 1;
			nextChild = nextLevel * 10 + ((curSum / 10) % 10) * 2;
			path.put(nextChild, curValue);
			nextChild -= 1;
			path.put(nextChild, curValue);
		}

		int numChild = (int) (Math.pow(2, (max - 1)));

		int index = nums.length - 1;
		curSum = 0;
		while(numChild-- > 0 && nums[index] / 100 == max) {
			curValue = nums[index--] / 10;
			curSum += path.get(curValue);
		}
		return curSum;
	}

	//A better solution
	public int pathSumBetter(int[] nums) {
		if(nums == null || nums.length == 0 || nums[0] == 0) return 0;
		Map<Integer, Integer> path = new HashMap<>();

		for(int n: nums) {
			path.put(n / 10, n % 10);
		}

		int curValue = 0;
		int nextLeft = 0;
		int nextRight = 0;
		int sum = 0;

		for(int i = nums.length - 1; i >= 0; --i) {
			curValue = nums[i];
			nextRight = (curValue / 100 + 1) * 10 + ((curValue / 10) % 10) * 2;
			nextLeft = nextRight - 1;

			if(!path.containsKey(nextRight) && !path.containsKey(nextLeft)) {
				curValue /= 10;
				while(curValue >= 11) {
					sum += path.get(curValue);
					curValue = (curValue / 10 - 1) * 10 + ((curValue % 10) - 1) / 2 + 1;
				}
			}
		}
		return sum;
	}
}
