package Arrays;

public class SortColors {

	public static void main(String[] args)
	{
		int[] nums = new int[]{0,1,0,0,1,2,2,0,1};
		System.out.println("The sorted array is: ");
		int[] newNums = sortColors(nums);
		for(int i : newNums)
			System.out.print(i);
		
	}
	
    public static int[] sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i <= r; i++) {
            if (nums[i] == 0) {
                swap(nums, i, l++);
            } else if (nums[i] == 2) {
                swap(nums, i--, r--);
            }
        }
        return nums;       
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }   
}	
