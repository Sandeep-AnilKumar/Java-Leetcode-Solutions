package DataStructureImplementation;

import java.util.StringJoiner;

public class BinaryIndexedTree {

	private final int[] bit;
	private final int[] nums;
	private final int n;

	public BinaryIndexedTree(int[] nums) {
		n = nums.length;
		bit = new int[n + 1];
		this.nums = nums;
		System.arraycopy(nums, 0, bit, 1, nums.length);
		build();
	}

	/**
	 * Helper method to print the array contents.
	 *
	 * @param nums - the array to print.
	 * @return - the contents of the array as string.
	 */
	static String arrayToString(int[] nums) {
		StringJoiner stringJoiner = new StringJoiner(",", "[", "]");

		for (int n : nums) {
			stringJoiner.add(String.valueOf(n));
		}

		return stringJoiner.toString();
	}

	public static void main(String[] args) throws Exception {
		int[] nums = {1, 3, 5};

		BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(nums);
		System.out.println("Original Array : " + arrayToString(nums));
		System.out.println("BIT Array : " + arrayToString(binaryIndexedTree.bit));
		System.out.println("Sum of first 5 nos : " + binaryIndexedTree.query(3));
		binaryIndexedTree.update(1, 2);
		System.out.println("Original Array after update : " + arrayToString(nums));
		System.out.println("BIT Array after update : " + arrayToString(binaryIndexedTree.bit));
		System.out.println("Sum of first 5 nos after update : " + binaryIndexedTree.query(3));
		System.out.println("Sum of numbers in range 2-5 : " + binaryIndexedTree.queryRange(0, 2));
	}

	/**
	 * Builds a binary indexed tree in O(n) time.
	 */
	private void build() {
		int j;
		for (int i = 1; i <= n; ++i) {
			j = i + (i & -i);
			if (j <= n) bit[j] += bit[i];
		}
	}

	/**
	 * Updates an indexed item in the original array to the given value.
	 * Also updates the values in the 'BIT' in O(logn) time.
	 *
	 * @param index - index of the item to update
	 * @param value - value to update to
	 */
	public void update(int index, int value) {
		int diff = value - nums[index];
		nums[index] = value;
		index++;

		while (index <= n) {
			bit[index] += diff;
			index += (index & -index);
		}
	}

	/**
	 * Queries the sum of the first 'K' indices in the original array in O(logn) time.
	 *
	 * @param k - the number of items to aggregate.
	 * @return - the sum of first 'K' numbers in the original array.
	 * @throws Exception - if 'K' is out of bounds.
	 */
	public int query(int k) throws Exception {
		if (k < 0 || k > n) throw new Exception("Invalid query range : " + k);
		int sum = 0;

		while (k > 0) {
			sum += bit[k];
			k -= (k & -k);
		}

		return sum;
	}

	/**
	 * Queries the sum of numbers from the original array between index1 and index2 (inclusive) in O(logn) time.
	 *
	 * @param index1 - left index.
	 * @param index2 - right index.
	 * @return - the sum of numbers between the given ranges.
	 * @throws Exception - if range is out of bounds.
	 */
	public int queryRange(int index1, int index2) throws Exception {
		return query(index2 + 1) - query(index1);
	}
}
