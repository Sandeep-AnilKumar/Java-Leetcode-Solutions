
public class MergeSortedArrays {

	public static void main(String[] args) {
		int nums1[] = new int[]{};
		int nums2[] = new int[]{1,2,3,4,5};
		int mergedArray[] = mergeSortedArrays(nums1, nums1.length, nums2, nums2.length);
	}

	public static int[] mergeSortedArrays(int[] nums1, int m, int[] nums2, int n)
	{
		if(nums1.length == 0 || m == 0)
		{
			nums1 = nums2;
			return nums1;
		}

		if(nums2.length == 0 || n == 0)
		{
			return nums1;
		}

		int i = 0;
		int j = 0;
		int lastElement = 0;

		while(i < m && j < n)
		{
			if(i > 0 && nums1[i] == 0 && nums1[i-1] != 0)
				lastElement = i;

			if(nums1[i] < nums2[j])
			{
				i++;
				continue;
			}

			else if(nums1[i] >= nums2[j])
			{
				int temp = nums1[i];
				nums1[i] = nums2[j];
				int k = i+1;
				while(k < m + n && (temp != 0))
				{
					int newTemp = nums1[k];
					nums1[k] = temp;
					k++;
					temp = newTemp;
				}
				j++;
			}
		}

		if(i == m && j != n)
			for(int n2 = j, n1 = lastElement ; n2 < n && n1 < m + n - 1; n2++, n1++)
			{
				nums1[n1] = nums2[n2];
			}
		return nums1;
	}
}
