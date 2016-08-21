package Arrays;

public class InsertionSortDescending {

	public static void main(String[] args) {
		int[] nums = new int[]{1,4,8,2,4,9,11,26,78};
		int[] result = insertionSortDescending(nums);

		for(int num : result) {
			System.out.println(num);
		}
	}

	public static int[] insertionSortDescending(int[] nums) {
		if(nums == null || nums.length <= 0) {
			return null;
		}

		int j, key, i;
		int length = nums.length;

		for(j = 1; j < length; ++j) {
			key = nums[j];
			for(i = j - 1; (i >=0 && nums[i] < key); --i) {
				nums[i+1] = nums[i];
			}
			nums[i+1] = key;
		}
		return nums;
	}

}