package Arrays;

import java.util.Arrays;

public class ThreeSumClosestNew {

	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,6,7,8};
		threeSumClosest(nums,13);
	}

	public static int threeSumClosest(int[] nums, int target){
		if(nums.length <= 2)
			return -1;

		Arrays.sort(nums);
		int length = nums.length;
		int difference = Integer.MAX_VALUE;
		int result = 0;

		for(int i = 0; i < length; i++)
		{
			if(i > 0 && nums[i] == nums[i-1])continue;

			int j = i + 1;
			int k = length - 1;

			while(j < k)
			{
				int sum = nums[i] + nums[j] + nums[k];
				if(sum == target) return sum;

				if(difference > Math.abs(target - sum))
				{
					result = sum;
					difference = Math.abs(target-sum);
				}

				else if(sum < target)
				{
					j++;
				}
				else
				{
					k--;
				}
			}
		}
		return result;
	}
}
