package Arrays;

public class NonDecreasingArray2 {
    public boolean checkPossibility(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i + 1];
                nums[i + 1] = nums[i];
                if (checkNonDescending(nums)) return true;
                nums[i] = temp; nums[i + 1] = temp;
                return checkNonDescending(nums);
            }
        }
        return true;
    }

    private boolean checkNonDescending(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3};
        System.out.println("Is the array non-decreasing with at most one change? := " 
                + new NonDecreasingArray2().checkPossibility(nums));
    }
}
