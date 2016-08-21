package Arrays;

public class MissingNumber {

	public static void main(String[] args) {
		int[] nums = new int[]{0,1,3};
		System.out.println(missingNumber(nums));
	}

	public static int missingNumber(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 1;
		}

		int combined = 0;
		int length = nums.length;
		for(int i =0; i < length; ++i) {
			combined ^= nums[i] ^ (i+1);
		}
		return combined;
	}

}
