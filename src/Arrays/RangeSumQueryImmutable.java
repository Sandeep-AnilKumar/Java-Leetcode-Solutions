package Arrays;

public class RangeSumQueryImmutable {
    private int[] dp;

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3 , -5, 2, -1 };
        RangeSumQueryImmutable r = new RangeSumQueryImmutable(nums);
        System.out.println(r.sumRange(0, 2));
        System.out.println(r.sumRange(0, 5));
        System.out.println(r.sumRange(2, 5));
    }

    //O(n2) space and O(n2) time to build the array, and O(1) to retrieve the sumQuery. //Might lead to Memory Limit Exception because
    // of O(n2) space initially.

    /*public RangeSumQuery(int[] nums) {
        if(nums == null || nums.length == 0) {
            this.nums = null;
            isNull = true;
        }
        if(!isNull) {
            int length = nums.length;
            this.nums = Arrays.copyOf(nums, length);
            dp = new int[length][length];
            dp[length - 1][length - 1] = nums[length - 1];
            for(int i = length - 2; i >= 0; --i) {
                for(int j = length - 1; j >= i; --j) {
                    if(i == j) {
                        dp[i][i] = nums[i];
                    } else {
                        dp[i][j] = nums[i] + dp[i + 1][j];
                    }
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        if(!isNull) {
            return dp[i][j];
        }
        return 0;
    }*/

    //easier version with O(n) space and O(1) sumQuery time.

    public RangeSumQueryImmutable(int[] nums) {
        if(nums == null || nums.length == 0) {
            this.dp = null;
            return;
        }
        int length = nums.length;
        dp = new int[length];
        dp[0] = nums[0];
        for(int i = 1; i < length; ++i) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j] - dp[i - 1]; 
    }
}
