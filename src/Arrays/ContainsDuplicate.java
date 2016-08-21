package Arrays;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = new int[]{2147483647,-2147483648, -2147483648, -2147483648};
		System.out.println("Array contains duplicate? " + containsDuplicate1(nums));
	}

	public static boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length == 0) {
			return false;
		}

		int length = nums.length;
		int low = 0;
		int high = length - 1;
		int[] temp = new int[length];
		mergeSort(nums, low, high, temp);

		for(int i = 1; i < length; ++i) {
			if(nums[i] == nums[i-1]) {
				return true;
			}
		}		
		return false;
	}

	public static void mergeSort(int[] nums, int low, int high, int[] temp) {
		int mid = 0;
		if(low < high) {
			mid = low + (high - low) / 2;
			mergeSort(nums, low, mid, temp);
			mergeSort(nums, mid + 1, high, temp);
			merge(nums, low, mid, high, temp);
		}
	}

	public static void merge(int[] nums, int low, int mid, int high, int[] temp) {
		for(int i = low; i <= high; ++i) {
			temp[i] = nums[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low;

		while(i <= mid && j <= high) {
			if(temp[i] <= temp[j]) {
				nums[k] = temp[i];
				i++;
			}
			else {
				nums[k] = temp[j];
				j++;
			}
			k++;
		}

		while(i <= mid) {
			nums[k] = temp[i];
			i++;
		}
	}

	public static boolean containsDuplicate1(int[] nums) {
		int size = Integer.MAX_VALUE;
		byte[] markPOS = new byte[size/8 + 1];
		byte[] markNEG = new byte[size/8 + 1];
		boolean flag = false;
		int j = 0, k = 0, check = 0;
		for (int i : nums) {
			if(i > 0) {
				j = i/8;
				k = i%8;
				check = 1<<k;
				if ((markPOS[j] & check) != 0) {
					return true;
				}
				markPOS[j]|=check;
			}
			else {
				if(i == Integer.MIN_VALUE && !flag) {
					flag = true;
				}
				else if(i == Integer.MIN_VALUE) {
					return true;
				}
				else {
					i = Math.abs(i);
					j = i/8;
					k = i%8;
					check = 1<<k;
					if ((markNEG[j] & check) != 0) {
						return true;
					}
					markNEG[j]|=check;
				}
			}
		}
		return false;
	}
}
