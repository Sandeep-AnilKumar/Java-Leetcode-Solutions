package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,4,4,3,2,3,1,1,3};
		int k = 3;
		List<Integer> result = topKFrequent(nums, k);

		for(int num : result) {
			System.out.print(num + " ,");
		}
	}


	public static List<Integer> topKFrequent(int[] nums, int k) {
		int length = nums.length;
		Map<Integer, Integer> frequency = new HashMap<>();

		for(int i = 0; i < length; ++i) {
			if(!frequency.containsKey(nums[i])) {
				frequency.put(nums[i],1);
			}
			else {
				frequency.put(nums[i], frequency.get(nums[i]) + 1);
			}
		}

		Map<Integer, List<Integer>> result = new HashMap<>();
		List<Integer> temp = new ArrayList<Integer>();
		int curFrequency = 0;
		for(int key : frequency.keySet()) {
			curFrequency = frequency.get(key);
			if(!result.containsKey(curFrequency)) {
				temp = new ArrayList<>();
			}
			else {
				temp = result.get(curFrequency);
			}
			temp.add(key);
			result.put(curFrequency, temp);
		}

		List<Integer> elements = new ArrayList<>();
		int max = 0;
		while(k > 0) {
			max = 0;
			for(int key : result.keySet()) {
				max = Math.max(max, key);
			}

			temp = result.get(max);
			for(int num : temp) {
				elements.add(num);
			}
			k -= temp.size();
			result.remove(max);
		}
		return elements;
	}
}