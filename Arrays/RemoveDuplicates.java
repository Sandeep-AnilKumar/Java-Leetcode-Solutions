package Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = new int[10];
		nums = new int[]{1,1,3,3};
		int length = removeDuplicates(nums);
		System.out.println("The length of the array after removing duplicates is: "+length);
		System.out.println("The new array is");
		for(int i = 0; i < length; i++)
		{
			System.out.println(nums[i]);
		}
	}

	public static int removeDuplicates(int[] nums) {
		int length = nums.length;
		if(length < 2)
			return length ;
		int previous = nums[0];
		int newLength = 1;
		for(int i = 1 ; i < length ; i++)
		{
			if(nums[i] != previous)
			{
				nums[newLength] = nums[i];
				newLength++;
				previous = nums[i];
			}
		}
		return newLength;
	}
}
