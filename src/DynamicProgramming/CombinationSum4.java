package DynamicProgramming;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        int target = 4;
        System.out.println("The number of combination sums that add up to " + target + " are := " +
                new CombinationSum4().combinationSum4(nums, target));
    }
}
