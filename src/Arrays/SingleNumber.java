package Arrays;

public class SingleNumber {

	public static void main(String[] args) {
		int nums[] = new int[]{1,1,1,1,2};
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		int ans = 0;
		for(int i = 0; i < 32; i++) {
			int sum = 0;
			for(int j = 0; j < nums.length; j++) {
				if(((nums[j] >> i) & 1) == 1) {
					sum++;
				}
			}
			sum %= 4;
			ans |= sum << i;
		}
		return ans;
	}
}
