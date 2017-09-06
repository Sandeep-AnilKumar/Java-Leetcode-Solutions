package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

	public static void main(String[] args) {
		String[] list1 = {"k", "KFC"};
		String[] list2 = {"k", "KFC"};
		MinimumIndexSumOfTwoLists indexSum = new MinimumIndexSumOfTwoLists();
		System.out.println("The fav restaurant with minimum index sum is := ");
		String[] favs = indexSum.indexSum(list1, list2);
		for(String f: favs) {
			System.out.print(f + ", ");
		}
	}

	public String[] indexSum(String[] list1, String[] list2) {
		Map<String, Integer> intersect = new HashMap<>();
		for(int i = 0; i < list1.length; ++i) {
			intersect.put(list1[i], i);
		}

		List<String> favs = new ArrayList<>();
		int curMax = Integer.MAX_VALUE;
		for(int i = 0; i < list2.length; ++i) {
			if(intersect.containsKey(list2[i])) {
				intersect.put(list2[i], intersect.get(list2[i]) + i);
				if(curMax > intersect.get(list2[i])) {
					favs = new ArrayList<>();
					favs.add(list2[i]);
					curMax = intersect.get(list2[i]);
				} else if(curMax == intersect.get(list2[i])) {
					favs.add(list2[i]);
				}
			}
		}
		return favs.toArray(new String[0]);
	}
}
