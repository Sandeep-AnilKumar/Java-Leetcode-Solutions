package Arrays;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
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
			for(Iterator k = j.iterator(); k.hasNext();)
				System.out.print(k.next() +",");
			System.out.println("]");
		}
		System.out.println("]");
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		List<Integer> list = new LinkedList<Integer>();
		if(nums.length == 0){
			return lists;
		}
		Arrays.sort(nums);
		lists.add(list);
		subsets(nums, lists, 0);
		return lists;
	}

	static void subsets(int[]nums, List<List<Integer>> lists, int start){
		if(start >= nums.length){
			return;
		}
		List<List<Integer>> nlists = new LinkedList<List<Integer>>(lists);
		for(int i = 0; i < nlists.size(); i++){
			List<Integer> l = new LinkedList<Integer>(nlists.get(i));
			l.add(nums[start]);
			if(!lists.contains(l)){
				lists.add(l);
			}
		}
		subsets(nums, lists, start + 1);
		return;
	}

}