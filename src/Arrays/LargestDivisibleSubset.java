package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LargestDivisibleSubset {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,4,8,9,72};
		List<Integer> result = divisibleSubSets(nums);

		for(int num : result) {
			System.out.print(num + ", ");
		}
	}

	public static List<Integer> divisibleSubSets(int[] nums) {
		List<List<Integer>> sets = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}

		Arrays.sort(nums);
		List<Integer> sub = new ArrayList<>();
		sets.add(sub);

		for(int num : nums) {
			int size = sets.size();
			for(int i = 0; i < size; ++i) {
				List<Integer> prev = new ArrayList<>(sets.get(i));
				prev.add(num);
				if(!sets.contains(prev)) {
					sets.add(prev);
				}
			}
		}

		List<Integer> result = new ArrayList<>();
		result.add(nums[0]);
		int size = 0;
		boolean flag = false;
		int n1 = 0;
		int n2 = 0;

		for(Iterator<List<Integer>> iter = sets.iterator(); iter.hasNext();) {
			List<Integer> cur = iter.next();
			if(cur != null && cur.size() >=2 && cur.size() > result.size()) {
				List<Integer> temp = new ArrayList<>();
				size = cur.size();
				for(int i = 0; i < size - 1; ++i) {
					flag = false;
					n1 = cur.get(i);
					for(int j = i+1; j < size; ++j) {
						n2 = cur.get(j);
						if(n1 % n2 == 0 || n2 % n1 == 0) {
							flag = true;
							for(int n : temp) {
								if(n != n2 && n != n1){
									if((n % n1 != 0 && n1 % n != 0) || (n % n2 != 0 && n2 %n != 0)) {
										flag = false;
									}
								}
							}
							if(flag) {
								if(!temp.contains(n1)) {
									temp.add(n1);
								}
								if(!temp.contains(n2)) {
									temp.add(n2);
								}
							}
						}
						else if(temp.contains(n1) && temp.contains(n2)) {
							temp.remove(n1);
						}
					}
				}
				if(temp.size() > result.size()) {
					result = new ArrayList<>(temp);
				}
			}
		}
		return result;
	}// TLE version.
}
