package Arrays;

public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null ||  nums.length == 0) return 0;
        Integer[][] memo = new Integer[2001][nums.length + 1];
        return findTargetSumWays(nums, memo, 1000, 0, S);
    }

    private int findTargetSumWays(int[] nums, Integer[][] memo, int curSum, int index, int target) {
        if (memo[curSum][index] != null) return memo[curSum][index];
        if (curSum - 1000 == target && index == nums.length) {
            memo[curSum][index] = 1;
            return memo[curSum][index];
        }
        if (index >= nums.length) return 0;
        memo[curSum][index] = findTargetSumWays(nums, memo, curSum + nums[index], index + 1, target);
        memo[curSum][index] += findTargetSumWays(nums, memo, curSum - nums[index], index + 1, target);
        return memo[curSum][index];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println("The number of ways using '+' and '-' to sum nums to be equal to " + S + " are := " +
                new FindTargetSumWays().findTargetSumWays(nums, S));
    }
}
