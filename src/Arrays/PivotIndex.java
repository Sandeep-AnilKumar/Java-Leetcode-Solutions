package Arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int leftSum = 0, rightSum = 0;

        for (int num : nums) rightSum += num;

        for (int i = 0; i < nums.length; ++i) {
            rightSum -= nums[i];
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
    
    public static void main(String[] args) {
        PivotIndex index = new PivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println("The pivot index where leftSum is equal to rightSum is := " + index.pivotIndex(nums));

        nums = new int[]{-1,-1,-1,0,1,1};
        System.out.println("The pivot index where leftSum is equal to rightSum is := " + index.pivotIndex(nums));
    }
}
