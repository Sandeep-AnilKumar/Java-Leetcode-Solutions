package Arrays;

public class RemoveElement {

	public static void main(String[] args) {
		int []nums = new int[]{4,2,0,2,2,1,4,4,1,4,3,2};		
		int val = 4;
		int length = removeElement(nums,val);
		System.out.println("The new length of the array is "+ length);
		System.out.println("The new array after removal of "+val+" is: ");
		for(int i = 0; i < length; i++)
		{
			System.out.println(nums[i]);
		}
	}

	public static int removeElement(int[] nums, int val) {
		int length = nums.length;
		if(length == 0)
			return 0;
		int count = 0;
		
		for(int i = 0; i < length; i++)
		{
			if(nums[i] != val)
			{	
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}
}
