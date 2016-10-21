package Arrays;

public class MaximumXOR {

    public static void main(String[] args) {
        int[] nums = {10,23,20,18,28}; //30
        System.out.println("Maximum XOR is : " + findMaximumXOR(nums));
    }

    public static int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            max = Math.max(max, nums[i]);
        }

        int result = Integer.MIN_VALUE;
        for(int i : nums) {
            if(i != max) {
                result = Math.max(result, (i ^ max));
            }
        }
        return result;
    }
}
