package Arrays;

public class NondecreasingArray {

	public static void main(String[] args) {
		int[] nums = {-1, 4, 2, 3};
		System.out.println("Can the array be converted to a non-decreasing one, with at most one change? := " + new NondecreasingArray().checkPossibility(nums));
	}

	public boolean checkPossibility(int[] nums) {
		int length = nums.length;
		int count = 0;
		for(int index = 1; index < length && count <= 1; ++index) {
			if(nums[index] < nums[index - 1]) {
				count++;
				if(index > 1 && nums[index] < nums[index - 2]) {
					nums[index] = nums[index - 1];
				} else {
					nums[index - 1] = nums[index];
				}
			}
		}
		return count <= 1;
	}
}
