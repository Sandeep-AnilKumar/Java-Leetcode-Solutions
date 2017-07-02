package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindDerangement {

	public static void main(String[] args) {
		FindDerangement fd = new FindDerangement();
		System.out.println("The number of derangements are := " + fd.findDerangement(10));
	}

	//Will cause TLE.
	public int findDerangement(int n) {
		if(n <= 1) {
			return 0;
		}

		int count = 0;
		int i = 0;

		List<List<Integer>> perms = getPermutations(n);
		for(List<Integer> p: perms) {
			i = 0;
			for(; i < n; ++i) {
				if(p.get(i) == i + 1) {
					break;
				}
			}
			if(i == n) {
				count++;
			}
		}
		return (int) (count % (Math.pow(10, 9) + 7));
	}

	public List<List<Integer>> getPermutations(int n) {
		int[] nums = new int[n];
		for(int i = 0; i < n; ++i) {
			nums[i] = i + 1;
		}

		List<List<Integer>> perms = new ArrayList<>();
		getPerms(nums, perms, 0, nums.length - 1);
		return perms;
	}

	public void getPerms(int[] nums, List<List<Integer>> perms, int start, int end) {
		if(start == end) {
			perms.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return;
		}
		for(int i = start; i <= end; ++i) {
			swap(nums, start, i);
			getPerms(nums, perms, start + 1, end);
			swap(nums, start, i);
		}
		return;
	}

	public void swap(int[] nums, int start, int i) {
		if(start != i) {
			nums[start] = nums[start] ^ nums[i];
			nums[i] = nums[start] ^ nums[i];
			nums[start] = nums[start] ^ nums[i];
		}
	}

	//Best version and fast.
	public int findDerangementBetter(int n) {
		if(n <= 1) return 0;
		long lastPrev = 1;
		long prev = 0;
		long mod = 1000000007;
		long cur = 0;
		for(int i = 3; i <= n; ++i) {
			cur = prev;
			prev = lastPrev;
			lastPrev = ((i - 1) % mod * ((cur + prev) % mod));
		}
		return (int) (lastPrev % mod);
	}
}
