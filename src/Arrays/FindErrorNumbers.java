package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindErrorNumbers {

	public static void main(String[] args) {
		FindErrorNumbers numbers = new FindErrorNumbers();
		int[] nums = {2,2};

		System.out.println("The mssing int and duplicated one is := ");
		int[] errors = numbers.findErrorNumsBest(nums);
		for(int e: errors) {
			System.out.print(e + ", ");
		}
	}

	public int[] findErrorNums(int[] nums) {
		int length = nums.length;
		int[] count = new int[length];
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < length; ++i) {
			if(count[nums[i] - 1] != 0) {
				result.add(nums[i]);
			}
			count[nums[i] - 1]++;
		}

		for(int i = 0; i < length; ++i) {
			if(count[i] == 0) {
				result.add(i + 1);
			}
		}
		int[] dupAndMissing = new int[result.size()];
		int index = 0;
		for(int i: result) {
			dupAndMissing[index++] = i;
		}
		return dupAndMissing;
	}

	//Using XOR

	public int[] findErrorNumsXOR(int[] nums) {
		int xor = 0, xor0 = 0, xor1 = 0;
		for (int n: nums)
			xor ^= n;
		for (int i = 1; i <= nums.length; i++)
			xor ^= i;
		int rightmostbit = xor & ~(xor - 1);
		for (int n: nums) {
			if ((n & rightmostbit) != 0)
				xor1 ^= n;
			else
				xor0 ^= n;
		}
		for (int i = 1; i <= nums.length; i++) {
			if ((i & rightmostbit) != 0)
				xor1 ^= i;
			else
				xor0 ^= i;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == xor0)
				return new int[]{xor0, xor1};
		}
		return new int[]{xor1, xor0};
	}

	//Constant Space, easier one

	public int[] findErrorNumsBest(int[] nums) {
		int dup = 0;
		int length = nums.length;
		int missing = 0;

		for(int i = 0; i < length; ++i) {
			if(nums[Math.abs(nums[i]) - 1] < 0) {
				dup = Math.abs(nums[i]);
			} else {
				nums[Math.abs(nums[i]) - 1] *= -1;
			}
		}

		for(int i = 0; i < length; ++i) {
			if(nums[i] > 0) {
				missing = i + 1;
			}
		}
		return new int[]{dup, missing};
	}
}