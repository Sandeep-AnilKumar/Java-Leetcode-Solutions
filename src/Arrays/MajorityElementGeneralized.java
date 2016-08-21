package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementGeneralized {

	public static void main(String[] args) {
		int[] nums = new int[]{4,2,1,1};
		System.out.println(majorityElementGeneral(nums, 3));
	}

	public static List<Integer> majorityElementGeneral(int[] nums, int k) {
		return getMajorityElement(nums, k);
	}

	public static List<Integer> getMajorityElement(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return null;
		}

		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for(int num :  nums) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}
			else if(map.keySet().size() < k - 1) {
				map.put(num, 1);
			}
			else {
				boolean flag = false;
				for(int ele : map.keySet()) {
					if(map.get(ele) == 0) {
						flag = true;
						map.remove(ele);
						map.put(num, 1);
						break;
					}
				}

				if(flag == false) {
					for(int ele : map.keySet()) {
						map.put(ele, map.get(ele) - 1);
					}
				}
			}
		}

		for(int ele : map.keySet()) {
			map.put(ele, 0);
		}

		for(int num : nums) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}
		}

		for(int ele : map.keySet()) {
			if(map.get(ele) > nums.length / k) {
				result.add(ele);
			}
		}
		return result;
	}
	//}

	//Solution for k = 3;
	// A easier solution for k = 3;
	public static List<Integer> majority(int nums[]) {
		if(nums == null || nums.length == 0) {
			return null;
		}

		int k = 3;
		List<Integer> result = new ArrayList<>();
		int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;
		for(int num : nums) {
			if(num == candidate1) {
				count1++;
			}
			else if(num == candidate2) {
				count2++;
			}
			else if(count1 == 0 && num != candidate1) {
				candidate1 = num;
				count1++;
			}
			else if(count2 == 0 && num != candidate2) {
				candidate2 = num;
				count2++;
			}
			else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;
		for(int num : nums) {
			if(num == candidate1) {
				count1++;
			}
			else if(num == candidate2) {
				count2++;
			}
		}

		if(count1 > nums.length / k) {
			result.add(candidate1);
		}

		if(count2 > nums.length / k) {
			result.add(candidate2);
		}

		return result;
	}
}
