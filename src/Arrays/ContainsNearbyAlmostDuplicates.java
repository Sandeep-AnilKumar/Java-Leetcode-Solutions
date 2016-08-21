package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContainsNearbyAlmostDuplicates {

	public static void main(String[] args) {
		int[] nums = new int[]{1,3,1};
		int k = 2;
		int t = 1;
		System.out.println("Array contains nearby almost duplicates? " + containsNearbyAlmostDuplicate(nums, k, t));
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums == null || nums.length == 0 || k <= 0) {
			return false;
		}

		Map<Integer,List<Integer>> numTMap = new HashMap<>();
		Set<Integer> numSet = new HashSet<>();

		int length = nums.length;

		for(int i = 0; i < length; ++i) {
			if(i > k) {
				int temp = nums[i - k - 1];
				List<Integer> numTList = numTMap.get(temp);
				for(Iterator iter = numTList.iterator(); iter.hasNext();) {
					numSet.remove(iter.next());
				}
			}
			int j = nums[i];
			int r = j;
			List<Integer> tempList = new ArrayList<>();
			for(; j <= r + t; ++j) {
				tempList.add(j);
				if(!numSet.add(j)) {
					return true;
				}
			}
			numTMap.put(r, tempList);
		}
		return false;
	}//Time Limit Exceeded Version.

	//Simpler TLE version

	/*
	 * public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums == null || nums.length == 0 || k <= 0 || t < 0) {
			return false;
		}

		Set<Integer> numSet = new HashSet<>();
		int length = nums.length;

		for(int i = 0; i < length; ++i) {
			if(i > k) {
				numSet.remove(nums[i - k - 1]);
			}
			for(int num : numSet) {
			    if(nums[i] >= num - t && nums[i] <= num + t) {
			        return true;
			    }
			}
			numSet.add(nums[i]);
		}
		return false;
	}
	 * 
	 * */

	/*
	 * Simpler O(n) solution using buckets.
	 * 
	 * public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        Map<Long ,Long> numTMap = new HashMap<>();
        int length = nums.length;

        for(int i = 0; i < length; ++i) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum /((long) t + 1);
            if(numTMap.containsKey(bucket) || (numTMap.containsKey(bucket - 1) && remappedNum - numTMap.get(bucket - 1) <= t) || (numTMap.containsKey(bucket + 1) && numTMap.get(bucket + 1) - remappedNum <= t)) {
                return true;
            }

            if(numTMap.entrySet().size() >= k) {
                long lastBucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                numTMap.remove(lastBucket);
            }
            numTMap.put(bucket, remappedNum);
        }
        return false;
    }
	 * 
	 * 
	 * */

}
