package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeautifulArrangement2 {

	List<Integer> result = new ArrayList<>();
	boolean found = false;
	public static void main(String[] args) {
		BeautifulArrangement2 arrangement2 = new BeautifulArrangement2();
		int n = 3;
		int k = 2;
		System.out.print("The beautiful arrangement is := [");
		int[] result = arrangement2.constructArray(n, k);
		for(int i = 0; i < result.length; ++i) {
			System.out.print(result[i] + ", ");
		}
		System.out.println("]");
	}

	public int[] constructArray(int n, int k) {
		int[] digits = new int[n];
		for(int i = 1; i <= n; ++i) {
			digits[i - 1] = i;
		}
		permuteAndFind(digits, 0, k);
		if(result != null && result.size() > 0) {
			int[] arrangement = new int[result.size()];
			for(int i = 0; i < arrangement.length; ++i) {
				arrangement[i] = result.get(i);
			}
			return arrangement;
		}
		return new int[0];
	}

	public void permuteAndFind(int[] digits, int cur, int k) {
		if(cur == digits.length - 1) {
			Set<Integer> set = new HashSet<>();
			for(int i = 0; i < digits.length - 1 && set.size() < k; ++i) {
				if(set.add(Math.abs(digits[i] - digits[i + 1])) && set.size() == k) {
					for(int n: digits) {
						result.add(n);
					}
					found = true;
					return;
				}
			}
			return;
		}

		for(int i = cur; i < digits.length && !found; ++i) {
			swap(digits, cur, i);
			permuteAndFind(digits, cur + 1, k);
			swap(digits, cur, i);
		}
	}

	public void swap(int[] digits, int left, int right) {
		int temp = digits[left];
		digits[left] = digits[right];
		digits[right] = temp;
	}

	//A better solution.
	public int[] constructArrayBetter(int n, int k) {
		int[] arrangement = new int[n];
		if(k == 1) {
			for(int i = 1; i <= n; ++i) {
				arrangement[i - 1] = i;
			}
			return arrangement;
		}

		for(int i = 1; i <= n - k - 1; ++i) {
			arrangement[i -  1] = i;
		}

		int start = n - k;
		int end = n;
		boolean even = false;
		for(int i = n - k; i <= n; ++i) {
			if(!even) {
				arrangement[i - 1] = start++;
				even = true;
			} else {
				arrangement[i - 1] = end--;
				even = false;
			}
		}
		return arrangement;
	}
}