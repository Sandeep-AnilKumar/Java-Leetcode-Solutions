package Arrays;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class SubsetsBitManipulation {

	public static void main(String[] args) {
		int[] set = new int[]{1,2,3};
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

	public static List<List<Integer>> subsets(int[] S) {
		Arrays.sort(S);

		int totalNumber = 1 << S.length;
		List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);

		for (int i=0; i<totalNumber; i++) {
			List<Integer> set = new LinkedList<Integer>();
			for (int j=0; j<S.length; j++) {
				if ((i & (1<<j)) != 0) {
					set.add(S[j]);
				}
			}

			collection.add(set);
		}

		return collection;
	}
}
