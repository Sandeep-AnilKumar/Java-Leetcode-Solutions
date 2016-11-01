package Arrays;

public class EqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1,2,3,8};
        System.out.println("Are there 2 subsets that have the same sum ? " + canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if(sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        if(nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    //A better space efficient version.
    public static boolean canPartitionAdvanced(int[] nums) {
        if(nums == null || nums.length == 0) 
            return true;
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 != 0 ) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for(int i = 0; i < nums.length; ++ i) {
            for(int j = sum; j >= nums[i] ; --j)
                dp[j] = dp[j] || dp[j - nums[i]];
        }
        return dp[sum];
    }
}
