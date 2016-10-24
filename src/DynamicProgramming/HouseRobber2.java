package DynamicProgramming;

public class HouseRobber2 {

    public static void main(String[] args) {
        //Houses on the end are next to each other, or houses are in a circle.
        int[] nums = {7,5,2,1,3,4};
        System.out.println("Maximum Profit Robbing Alternate houses is : " + rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if(length == 1) {
            return nums[0];
        }
        if(length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[length - 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for(int i = 2; i < length - 1; ++i) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        int maxSoFar = dp[length - 2];
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);
        for(int i = 2; i < length - 1; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + 1]);
        }
        return Math.max(maxSoFar, dp[length - 2]);
    }
}
