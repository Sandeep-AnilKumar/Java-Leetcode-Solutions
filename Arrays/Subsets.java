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