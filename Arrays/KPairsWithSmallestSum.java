package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KPairsWithSmallestSum {

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,7,11};
		int[] nums2 = new int[]{2,4,6};
		int k = 3;
		List<int[]> result = findKPairsWithSmallestSum(nums1, nums2, k);
		for(int[] nums : result) {
			System.out.print("[");
			for(int i = 0; nums != null && i < nums.length; ++i) {
				System.out.print(nums[i] + ",");
			}
			System.out.println("],");
		}
	}

	public static List<int[]> findKPairsWithSmallestSum(int[] nums1, int[] nums2, int k) {
		List<int[]> ret = new ArrayList<int[]>();
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
			return ret;
		}

		int[] index = new int[nums1.length];
		while (k-- > 0) {
			int min_val = Integer.MAX_VALUE;
			int in = -1;
			for (int i = 0; i < nums1.length; i++) {
				if (index[i] >= nums2.length) {
					continue;
				}
				if (nums1[i] + nums2[index[i]] < min_val) {
					min_val = nums1[i] + nums2[index[i]];
					in = i;
				}
			}
			if (in == -1) {
				break;
			}
			int[] temp = {nums1[in], nums2[index[in]]};
			ret.add(temp);
			index[in]++;
		}
		return ret;
	}// Complexity O(k * m), m is the length of nums1.

	public static List<int[]> findKPairsWithSmallestSum1(int[] nums1, int[] nums2, int k) {

		List<int[]> result = new ArrayList<int[]>();
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
			return result;
		}

		PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> a[0]+a[1]-b[0]-b[1]);
		for(int i=0; i<nums1.length && i<k; i++) {
			queue.offer(new int[]{nums1[i], nums2[0], 0});
		}
		while(k-- > 0 && !queue.isEmpty()){
			int[] cur = queue.poll();
			result.add(new int[]{cur[0], cur[1]});
			if(cur[2] == nums2.length-1) continue;
			queue.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
		}
		return result;
	}//Complexity: - O(klogk);

}
