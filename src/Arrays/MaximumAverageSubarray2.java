package Arrays;

public class MaximumAverageSubarray2 {

	public static void main(String[] args) {
		MaximumAverageSubarray2 max = new MaximumAverageSubarray2();
		int[] nums = {7367,8178,5787,5375,2758,5036,2884,8643,7238,354,4565,3131,1208,8569,5679,3428,7221,
				7761,3625,1747,3924,4047,1924,6039,429,4070,1727,9818,7614,8313,9609,1333,6492,5396,6709,
				9250,6784,9593,4245,4023,6299,8810,3506,3860,7379,9185,3640,4600,3298,7265,2700,3574,7664,4624,9613,
				8094,5046,7692,4264,9012,6006,3873,346,8850,5622,3407,4452,2406,3000,8697,6429,5652,7507,9935,9512,1238,
				5472,3152,5839,5122,6770,4891,8696,786,9515,4662,5232,913,2354,9497,9925,4712,3370,6623,3562,
				8992,30,4366,7751,9383,3063,4180,5035,570,468,899,1809,2292,403,4000,7415,3525,8891,6111,4312,
				4758,773,9544,2023,9480,9041,8300,544,2412,4924,459,7756,1306,4825,5507,689,7889,6040,2076,
				4811,2860,9327,2972,1504,6083,3324,8919,9608,8567,1383,3920,3325,8508,9817,1700,4340,8858,1,4885,
				7622,1277,5344,1731,8935,169,3590,5977,4410,9630,8053,9222,8842,3733,8546,347,9816,1871,5618,5776,
				438,7001,9697,116,1862,5866,1816,6202,1076,8169,7439,8699,5798,2783,6782,4734,9305,372,
				711,3715,6355,5116,9289,5197,8849,4188,1896,5017,6059,7515,794,2849,868,6843,2965,9082,
				2709,1134,5285,3785,9303,2724,8836,5102,1860,5618,6188,1165,2343,6899,1232,8698,2015,
				6874,247,7217,7414,8496,2234,3473,2363,9380,2674,3231,6223,5640,2314,5284,6774,3951,
				5422,2429,3027,4258,3883,4887,6229,71,2404,4924,6970,9989,9974,5338,3215,221,8907,
				629,5069,7493,454,7432,6874,3128,664,9449,5120,9330,4734,8246,9633,6508,676,2660,7118,
				4559,3900,9699,983,6304,4623,4305,2645,4597,9643,5860,1171,4902,2841,6240,2396,3295,
				3673,5622,2776,689,5071,7896,19,6157,2495,6004,2665,3171,8664,6136,4082,2564,5835,1417,5221,
				459,5723,7866,5056,1718,79,2579,6621,2920,8820,9017,2568,2493,4639,5344,3182,6062,9592,9553,8572,
				2087,5557,7589,1610,573,3725,2045,9490,9561,3462,4711,6372,9185,8929,7780,7256,9008,
				360,3877,1929,9180,9246,849,8025,237,2545,7559,6299,8489,7112,1223,6929,9021,8813};
		int k = 10;
		System.out.println("The maximum average subarray for length greater than or equal to " + k + " is := " + max.findMaxAverage(nums, k));
	}

	public double findMaxAverage(int[] nums, int k) {
		int length = nums.length;
		long[] sums = new long[length];
		double sum = 0;
		sums[length - 1] = nums[length - 1];

		for(int i = length - 2; i >= 0; --i) {
			sums[i] = sums[i + 1] + nums[i];
		}

		double maxAvg = 0;
		sum = 0;
		for(int i = 0; i < k; ++i) {
			sum += nums[i];
		}

		maxAvg = sum / k;

		for(int i = 0; i <= length - k; ++i) {
			sum = sums[i];
			for(int j = length - 1; j >= i + k - 1; --j) {
				maxAvg = Math.max(maxAvg, sum / (j - i + 1));
				sum -= nums[j];
			}
		}
		return maxAvg;
	}

	//Using Convex Hull Solution

	public double findMaxAverageConvexHull(int[] nums, int k) {
		int n = nums.length;
		int[] sums = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			sums[i] = sums[i - 1] + nums[i - 1];
		}

		double res = sums[n] / n;
		double tmp = res;
		int l = 0, r = -1;

		for (int i = k; i <= n; i++) {
			int t = i - k;

			while (l < r && avg(dp[r], t, sums) <= avg(dp[r - 1], t, sums)) r--;
			r++;

			dp[r] = t;

			while (l < r && avg(dp[l], i, sums) <= avg(dp[l + 1], i, sums)) l++;

			tmp = avg(dp[l], i, sums);
			if (tmp > res) res = tmp;
		}
		return res;
	}

	private double avg (int i, int j, int[] nums) {
		return (double) (nums[j] - nums[i]) / (j - i);
	}
}
