package Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4};
        System.out.println("The index of unique numbers is at :=" + removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }

        int index = 0;
        for(int n : nums) {
            if(index == 0 || n > nums[index - 1]) {
                nums[index++] = n;
            }
        }
        return index;
    }
}
