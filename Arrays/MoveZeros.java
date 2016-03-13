package Arrays;

public class MoveZeros{
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

		int length1 = nums1.length;
		int length2 = nums2.length;

		int i = 0;
		int j = 0;

		for(i = 0, j = 0; i + j < length1 - 1  && j < length2; )
		{
			if(nums1[i] < nums2[j])
			{
				i++;
			}
			else
			{
				int temp = nums1[i+1];
				nums1[i+1] = nums2[j];
				int index = i+1;
				int k = index+1;
				while(nums1[k] != 0)
				{
					int temp2 = nums1[k];
					nums1[k] = temp;
					temp = temp2;
					k++;
				}
				nums1[k] = temp;
				i = index+1;
				j++;
			}
		}

		if(i + j == length1 - 1)
		{
			for(;i < length1 && j < length2; i++, j++)
			{
				nums1[i] = nums2[j];
			}
		}
	}
}
