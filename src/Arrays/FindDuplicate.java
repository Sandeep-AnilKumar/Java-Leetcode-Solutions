package Arrays;

public class FindDuplicate {

	public static void main(String[] args) {
		int nums[] = new int[]{1,4,7,8,6,5,3,2,4};
		System.out.println(findDuplicate(nums));
	}

	public static int findDuplicate(int[] nums) {
		int low = 1, high = nums.length - 1;
		while (low <= high) {
			int mid = (int) (low + (high - low) * 0.5);
			int cnt = 0;
			for (int a : nums) {
				if (a <= mid) ++cnt;
			}
			if (cnt <= mid) low = mid + 1;
			else high = mid - 1;
		}
		return low;
	}
}

/*
 * Faster way.
 * public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int slow = 0;
        int fast = 0;
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        
        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
 * 
 * */
