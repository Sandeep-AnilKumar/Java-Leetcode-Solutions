package Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IntersectionArray {

	public static void main(String[] args) {
		int nums1[] = new int[]{2,1};
		int nums2[] = new int[]{1,2};
		int result[] = intersection(nums1, nums2);
		System.out.println("The result is:");
		for(int item : result) {
			System.out.println(item);
		}
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		if((nums1 == null || nums1.length == 0) || (nums2 == null || nums2.length == 0)) {
			return null;
		}

		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();

		int length1 = nums1.length;
		int length2 = nums2.length;

		List<Integer> result = new ArrayList<Integer>();

		for(int index = 0; index < length1; ++index) {
			set1.add(nums1[index]);
		}

		for(int index = 0; index < length2; ++index) {
			set2.add(nums2[index]);
		}

		for(int item : set1) {
			if(set2.contains(item)) {
				result.add(item);
			}
		}

		int returnResult[] = new int[result.size()];
		int temp = 0;
		for(int resultItem : result) {
			returnResult[temp] = resultItem;
			temp++;
		}
		return returnResult;
	}
}
