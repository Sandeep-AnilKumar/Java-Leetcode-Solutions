package Arrays;

public class MedianOfSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = new int[]{6,9,11,13,18};
		int[] nums2 = new int[]{6,9,13,18};
		System.out.println(medianOfSortedArrays(nums1, nums2));
	}

	public static double medianOfSortedArrays(int[] nums1, int[] nums2)
	{
		if(nums1.length == 0 && nums2.length == 0)
			return -1;

		if(nums1.length == 0)
		{
			if(nums2.length % 2 == 0)
			{
				return ((nums2[nums2.length/2] + nums2[nums2.length/2 - 1])/2.0);
			}

			else
				return (nums2[nums2.length/2]);
		}

		if(nums2.length == 0)
			if(nums1.length % 2 == 0)
			{
				int l1 = 3;
				int length1 = (int)(Math.ceil(l1/2.0) + 1);
				return length1;
			}

			else
				return (nums1[nums1.length/2]);

		return 0;
	}

}
