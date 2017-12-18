package Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int nums[] = new int[]{4,6,2,7,9,2,1};
		int temp[] = new int[nums.length];
		doMerge(nums,temp,0,nums.length-1);
		for(int i : nums) {
			System.out.print(i + " ");
		}
	}

	public static void doMerge(int nums[], int temp[], int low, int high) {
		if(low < high) {
			int mid = low + ((high - low) >>> 1);

			doMerge(nums,temp,low,mid);
			doMerge(nums,temp,mid+1,high);
			mergeParts(nums,temp,low,mid,high);
		}
	}
	public static void mergeParts(int nums[], int temp[], int low, int mid, int high) {
		for (int i = low; i <= high; ++i) {
			temp[i] = nums[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high) {
			if (temp[i] <= temp[j]) {
				nums[k] = temp[i++];
			} else {
				nums[k] = temp[j++];
			}
			k++;
		}
		while (i <= mid) {
			nums[k++] = temp[i++];
		}
		return;
	}
}