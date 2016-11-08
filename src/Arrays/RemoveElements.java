package Arrays;

public class RemoveElements {

    public static void main(String[] args) {
        int[] nums = {2,3,3,2,4,5,6};
        int val = 3;
        System.out.println("The index before which there are no elements of value '" + val + "' are " + removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for(int n : nums) {
            if(n!= val) {
                nums[index++] = n;
            }
        }
        return index;
    }
}
