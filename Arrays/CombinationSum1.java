package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombinationSum1 {

	public static void main(String[] args) {
		int n = 20;
		int k = 16;
		List<List<Integer>> result = combinations(n,k);

		System.out.println("The combination are: \n[");
		for(Iterator<List<Integer>> i = result.iterator(); i.hasNext();)
		{
			System.out.print("[");
			List<Integer> j = i.next();
			for(Iterator<Integer> r = j.iterator(); r.hasNext();)
				System.out.print(r.next() + " ");
			System.out.println("]");
		}
		System.out.println("]");
	}

	public static List<List<Integer>> combinations(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if(n < 1 || k < 1 || k > n) {
			return result;
		}

		List<Integer> sub = new ArrayList<>();
		List<List<Integer>> comboResult = new ArrayList<>();
		result.add(sub);
		int size = 0;

		for(int i = 1; i <= n; ++i) {
			size = result.size();

			for(int j = 0; j < size; ++j) {
				List<Integer> prev = new ArrayList<>(result.get(j));
				prev.add(i);
				result.add(prev);
				if(prev.size() == k) {
					comboResult.add(prev);
				}
			}
		}
		return comboResult;
	}//TLE version.
}
