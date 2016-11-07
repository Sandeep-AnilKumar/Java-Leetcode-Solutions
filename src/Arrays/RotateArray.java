package Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 1;
        nums = rotate(nums, k);
        for(int i : nums) {
            System.out.print(i + ", ");
        }
    }

    /*public static int[] rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) {
            return nums;
        }

        int length = nums.length;
        int count = length;
        k %= length;
        int next = k;
        int temp1 = 0;
        int temp2 = nums[0];
        while(--count > 0) {
            if(next == 0 && next + 1 < length) {
                temp1 = nums[next + 1];
            } else {
                temp1 = nums[next];
            }
            nums[next] = temp2;
            temp2 = temp1;

            if(next == 0) {
                next += 1;
            }
            next = (next + k) % length;
        }
        nums[next] = temp2;
        return nums;
    }*/

    public static int[] rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) {
            return nums;
        }

        int length = nums.length;
        k %= length;
        reverseNums(nums, 0, length - 1);
        reverseNums(nums, 0, k - 1);
        reverseNums(nums, k, length - 1);
        return nums;
    }

    public static void reverseNums(int[] nums, int start, int end) {
        int temp = 0;
        while(start < end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
        return;
    }
}
