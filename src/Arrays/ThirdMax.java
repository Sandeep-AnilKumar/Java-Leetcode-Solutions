package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ThirdMax {

	public static void main(String[] args) {
		int[] nums = {1,1, Integer.MIN_VALUE};
		System.out.println("The third max number is := " + thirdMax(nums));
	}

	public static int thirdMax(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		PriorityQueue<Integer> max = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if (a < b) return 1;
				if (a > b) return -1;
				return 0;
			} 
		});

		for(int i: nums) {
			max.offer(i);
		}

		int k = 3;
		int curMax = max.poll();
		k--;
		int kMax = 0;
		int prev = 0;
		prev = curMax;

		while(!max.isEmpty() && k > 0) {
			kMax = max.poll();
			if(prev != kMax) {
				k--;
				prev = kMax;
			}
		}

		return k > 0 ? curMax : kMax;
	}
}
