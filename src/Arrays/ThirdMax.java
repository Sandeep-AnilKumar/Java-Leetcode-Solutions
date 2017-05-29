package Arrays;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class ThirdMax {

	public static void main(String[] args) {
		int[] nums = {1,1, Integer.MIN_VALUE, 2, 2, 3, 4};
		System.out.println("The third max number is := " + thirdMaxBetter(nums));
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

	//A better version.
	public static int thirdMaxBetter(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i: nums) {
			if(set.add(i)) {
				pq.offer(i);
				if(pq.size() > 3) {
					set.remove(pq.poll());
				}
			}
		}

		if(pq.size() < 3) {
			while(pq.size() > 1) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	//A much easier version.
	public static int thirdMaxBest(int[] nums){
		TreeSet<Integer> set = new TreeSet<>();
		for (int num : nums)
			if (set.add(num) && set.size() > 3)
				set.pollFirst();
		return set.size() > 2 ? set.pollFirst() : set.pollLast();
	}	
}