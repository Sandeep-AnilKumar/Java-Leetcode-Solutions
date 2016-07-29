package Arrays;

public class MaximumGap {

	public static void main(String[] args) {
		int[] nums = new int[]{4,1,7,5,2,4,21};
		System.out.println("The maximum gap is: " + maximumGap1(nums));
	}

	public static int maximumGap(int[] nums) {
		if(nums == null || nums.length < 2) {
			return 0;
		}

		int length = nums.length;
		int[] aux = new int[nums.length];
		int exp = 1;
		int max = nums[0];
		for(int i = 1; i < length; ++i) {
			max = Math.max(max, nums[i]);
		}

		while(max / exp > 0) {
			int[] count = new int[10];
			for(int i = 0; i < length; ++i) {
				count[(nums[i]/exp) % 10]++;
			}

			for(int i = 1; i < 10; ++i) {
				count[i] += count[i-1];
			}

			for(int i = nums.length - 1; i >= 0; --i) {
				aux[--count[(nums[i]/exp) % 10]] = nums[i];
			}

			for(int i = 0; i < length; ++i) {
				nums[i] = aux[i];
			}

			exp *= 10;
		}

		int gap = Integer.MIN_VALUE;
		for(int i = 1; i < length; ++i) {
			gap = Math.max(nums[i] - nums[i-1], gap);
		}
		return gap;
	}//Radix sort, complexity O(10n) == O(n);

	public static int maximumGap1(int[] nums) {
		int n = nums.length;
		if(n < 2) return 0;

		int min = nums[0];
		int max = nums[0];

		for(int i = 1;i < n;i++){
			if(min > nums[i]) min = nums[i];
			if(max < nums[i]) max = nums[i];
		}

		int gap = (max-min)/(n-1);
		if(gap == 0) gap++;
		int len = (max-min)/gap+1;

		int [] tmax = new int [len];
		int [] tmin = new int [len];

		for(int i = 0;i < n;i++){
			int index = (nums[i]-min)/gap;

			if(nums[i] > tmax[index]) tmax[index] = nums[i];
			if(tmin[index] == 0 || nums[i] < tmin[index]) tmin[index] = nums[i];
		}

		int myMax = 0;

		for(int i = 0;i < len;i++){
			if(myMax < tmin[i]-min) myMax = tmin[i]-min; //Gap between current max and previous min.
			if(tmax[i] != 0) min = tmax[i];//new max;
		}
		return myMax;
	}//bucket sort, better than radix sort.
}
