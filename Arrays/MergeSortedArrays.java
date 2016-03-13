package Arrays;

public class MergeSortedArrays{
	public static void main(String args[])
	{
		int nums1[] = {1,2,3,4,5,0,0,0,0,0};
		int nums2[] = {2,4,6,6,7};
		mergeSortedArrays(nums1, nums2);
	}

	public static void mergeSortedArrays(int nums1[], int nums2[])
	{
		if(nums1.length == 0 || nums2.length == 0)
			return;

		int m = 5;
		int n = nums2.length;

		int i = m - 1, j = n - 1, k= m + n - 1;

		while(i > -1 && j > -1)
		{
			if(nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}

		while(j > -1)
			nums1[k--] = nums2[j--];

		return;

	}
}
