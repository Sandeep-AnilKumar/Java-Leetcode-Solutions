package Arrays;

public class MergeSortedArraysSpace {

	public static void main(String[] args) {
		int nums1[] = new int[]{1,2,3,4,5,6,6,6,6,6,6,6,6};
		int nums2[] = new int[]{2,3,4,8,9,10,11,12};

		int result[] = mergeSortedArray(nums1,nums2);
	}

	public static int[] mergeSortedArray(int a[], int b[])
	{
		int[] answer = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;

		while (i < a.length && j < b.length)
		{
			if (a[i] < b[j])       
				answer[k++] = a[i++];

			else        
				answer[k++] = b[j++];               
		}

		while (i < a.length)  
			answer[k++] = a[i++];

		while (j < b.length)    
			answer[k++] = b[j++];

		return answer;
	}
}
