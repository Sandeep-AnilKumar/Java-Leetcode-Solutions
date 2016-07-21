package Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Subsets {

	public static void main(String[] args) {
		int[] set = new int[]{1,4,3,2};
		List<List<Integer>> subset = subsets(set);
		System.out.println("The subsets are: \n [");
		for(Iterator<List<Integer>> i = subset.iterator(); i.hasNext();)
		{
			System.out.print("[");
			List<Integer> j = i.next();
			for(Iterator<Integer> k = j.iterator(); k.hasNext();)
				System.out.print(k.next() + " ");
			System.out.println("]");
		}
		System.out.println("]");
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		if(nums == null || nums.length == 0) {
			return result;
		}

		List<Integer> set = new ArrayList<>();
		result.add(set);

		int length = nums.length;

		for(int i = 0; i < length; ++i) {
			int size = result.size();
			for(int j = 0; j < size; j++) {
				List<Integer> tempSet = new ArrayList<Integer>(result.get(j));
				tempSet.add(nums[i]);
				result.add(tempSet);
			}
		}
		return result;
	}
}

//Other Solutions: -
/*
 * public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for(int i : S) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
 * 
 * 
 *Bit Manipulation Solution: -
 *
 *
    public List<List<Integer>> subsets(int[] nums) {
    	int n = nums.length;
    	int total = 1 << n;
    	List<List<Integer>> subsets = new ArrayList<>();
    	for (int i = 0; i < total; i++) {
        	List<Integer> subset = new ArrayList<>();
        	for (int j = 0; j < n; j++) {
            	if (((1 << j) & i) != 0) {
                	subset.add(nums[j]);
                }
        	}
        	subsets.add(subset);
    	}
    	return subsets;
	}

 * 
 * */
//Subsets with Duplicates.
/* Given the following set of nums [1,4,4,4,4];
 * the result will be : - [[],[1],[4],[1,4],[4,4],[1,4,4],[4,4,4],[1,4,4,4],[4,4,4,4],[1,4,4,4,4]]
 * if prev number == cur number then the number should be added to only those lists which were added in the last round.
 * Solution: -
 * public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return result;
		}

		List<Integer> set = new ArrayList<>();
		result.add(set);
        Arrays.sort(nums);
		int length = nums.length;
        int prev = 0;
        List<List<Integer>> prevList = new ArrayList<List<Integer>>();

		for(int i = 0; i < length; ++i) {
		    if(i == 0 || nums[i] != prev) {
		        prevList.clear();
			    int size = result.size();
			    for(int j = 0; j < size; j++) {
				    List<Integer> tempSet = new ArrayList<Integer>(result.get(j));
				    tempSet.add(nums[i]);
				    prevList.add(tempSet);
				    result.add(tempSet);
			    }
			    prev = nums[i];
		    }
		    else {
		        int size = prevList.size();
		        List<List<Integer>> tempPrev = new ArrayList<List<Integer>>(prevList);
		        prevList.clear();
		        for(int j = 0; j < size; j++) {
		            List<Integer> tempSet = new ArrayList<Integer>(tempPrev.get(j));
		            tempSet.add(nums[i]);
		            prevList.add(tempSet);
		            result.add(tempSet);
		        }
		    }
		}
		return result;
	}
 */
//Same solution with easier understanding. Just change the start pointer for the next round.
/*
 * 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		int begin = 0;
		for(int i = 0; i < nums.length; i++) {
			if(i == 0 || nums[i] != nums[i - 1]) {
				begin = 0;
			}
			int size = result.size();
			for(int j = begin; j < size; j++) {
				List<Integer> cur = new ArrayList<Integer>(result.get(j));
				cur.add(nums[i]);
				result.add(cur);
			}
			begin = size;
		}
	return result;
}

 * A better bit manipulation solution : -
 * 
 * public List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
    	int n = nums.length;
    	int total = 1 << n;
    	List<List<Integer>> subsets = new ArrayList<>();
    	for (int i = 0; i < total; i++) {
    	    boolean flag = false;
        	List<Integer> subset = new ArrayList<>();
        	for (int j = 0; j < n; j++) {
            	if (((1 << j) & i) != 0) {
                    if(j > 0 && nums[j] == nums[j-1] && ((1 << (j-1)) & i) == 0) {
                	    flag = true;
                        break;
                    }
                    else {
                    subset.add(nums[j]);
                    }
            	}
        	}
            if(!flag) {
                subsets.add(subset);
            }
    	}
    	return subsets;
	}
 * 
 * 
 * */