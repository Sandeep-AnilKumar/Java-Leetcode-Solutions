package Arrays;

public class MaximumProduct {

	public static void main(String[] args) {
		MaximumProduct mp = new MaximumProduct();
		int[] nums = {-1,-2,-3};
		System.out.println("The maximum product of the array is := " + mp.maximumProduct(nums));
	}

	public int maximumProduct(int[] nums) {
		int min1, min2, max1, max2, max3;
		max1 = max2 = max3 = Integer.MIN_VALUE;
		min1 = min2 = Integer.MAX_VALUE;

		for(int n: nums) {
			if(n <= min1) {
				min2 = min1;
				min1 = n;
			} else if(n <= min2) {
				min2 = n;
			}
			if(n >= max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if(n >= max2) {
				max3 = max2;
				max2 = n;
			} else if(n >= max3) {
				max3 = n;
			}
		}
		return Math.max(min1 * min2 * max1, max1 * max2 * max3);
	}
}
