package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {

	public static void main(String[] args) {
		SmallestRange range = new SmallestRange();
		List<List<Integer>> nums = new ArrayList<>();
		List<Integer> num1 = Arrays.asList(4,10,15,24,26);
		List<Integer> num2 = Arrays.asList(0,9,12,20);
		List<Integer> num3 = Arrays.asList(5,18,22,30);

		nums.add(num1);
		nums.add(num2);
		nums.add(num3);

		System.out.print("The smallest range that includes at least one element from all the lists is := [");
		int[] res = range.smallestRangeBetter(nums);
		for(int n: res) {
			System.out.print(n + ", ");
		}
		System.out.println("]");
	}

	//Works well, but has issues with few test cases.
	class Num implements Comparable<Num>{
		int listNum;
		int value;

		public Num(int listNum, int value) {
			this.listNum = listNum;
			this.value = value;
		}

		@Override
		public int compareTo(Num b) {
			return this.value - b.value;
		}

		public String toString() {
			return this.value + " from list " + this.listNum;
		}
	}

	public int[] smallestRange(List<List<Integer>> nums) {
		if(nums.size() == 1) {
			return new int[]{nums.get(0).get(0), nums.get(0).get(0)};
		}

		int k = nums.size();
		List<Num> q = new LinkedList<>();
		Num[] first = new Num[k];
		for(int i = 0; i < k; ++i) {
			first[i] = new Num(i, nums.get(i).get(0));
		}

		Arrays.sort(first);

		for(int i = 0; i < k; ++i) {
			q.add(first[i]);
		}

		int curMin = Integer.MAX_VALUE;
		int[] res = new int[2];

		int[] indices = new int[k];
		int curIndex = q.get(0).listNum;
		int l, r;
		l = r = 0;
		int temp = 0;

		while(indices[curIndex] < nums.get(curIndex).size() && !q.isEmpty() && q.size() == k) {
			l = q.get(0).value;
			r = q.get(k - 1).value;
			if(r - l < curMin) {
				curMin = r - l;
				res[0] = l;
				res[1] = r;
			}

			temp = indices[curIndex] + 1;
			while(temp < nums.get(curIndex).size() && nums.get(curIndex).get(temp) < r) {
				temp++;
			}
			q.remove(0);
			if(temp < nums.get(curIndex).size()) {
				q.add(new Num(curIndex, nums.get(curIndex).get(temp)));
			}
			indices[curIndex] = temp;
			curIndex = q.get(0).listNum;
		}
		return res;  
	}

	class RangeNum {
		int value;
		int listIndex;

		public RangeNum(int value, int listIndex) {
			this.value = value;
			this.listIndex = listIndex;
		}
	}

	//A better solution
	public int[] smallestRangeBetter(List<List<Integer>> nums) {
		int k = nums.size();
		int[] next = new int[k];
		int curMin = Integer.MAX_VALUE;
		int[] range = new int[2];
		RangeNum tempMin = null;
		int curMax = Integer.MIN_VALUE;

		PriorityQueue<RangeNum> min = new PriorityQueue<>(new Comparator<RangeNum>() {
			@Override
			public int compare(RangeNum r1, RangeNum r2) {
				return r1.value - r2.value;
			}
		});

		for(int i = 0; i < k; ++i) {
			min.offer(new RangeNum(nums.get(i).get(0), i));
			curMax = Math.max(curMax, nums.get(i).get(0));
		}

		int curMinIndex = min.peek().listIndex;

		while(!min.isEmpty() && next[curMinIndex] < nums.get(curMinIndex).size()) {
			tempMin = min.poll();

			if(curMax - tempMin.value < curMin) {
				curMin = curMax - tempMin.value;
				range[0] = tempMin.value;
				range[1] = curMax;
			}

			next[curMinIndex]++;
			curMinIndex = tempMin.listIndex;
			if(next[curMinIndex] < nums.get(curMinIndex).size()) {
				min.offer(new RangeNum(nums.get(curMinIndex).get(next[curMinIndex]), curMinIndex));
				curMax = Math.max(curMax, nums.get(curMinIndex).get(next[curMinIndex]));
			}
		}
		return range;
	}
}