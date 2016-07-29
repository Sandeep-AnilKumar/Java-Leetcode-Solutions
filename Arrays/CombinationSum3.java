package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombinationSum3 {

	public static void main(String[] args) {
		int n = 9;
		int k = 3;
		List<List<Integer>> result = combinationSum3(n,k);

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

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		if(n < 1 || k < 1 || k > n) {
			return result;
		}

		List<Integer> sub = new ArrayList<>();
		List<List<Integer>> comboResult = new ArrayList<>();
		result.add(sub);
		int size = 0;
		int count = 0;

		for(int i = 1; i <= 9; ++i) {
			size = result.size();

			for(int j = 0; j < size; ++j) {
				List<Integer> prev = new ArrayList<>(result.get(j));
				prev.add(i);
				result.add(prev);
				if(prev.size() == k) {
					count = 0;
					for(int num : prev) {
						count += num;
						if(count > n) {
							break;
						}
					}
					if(count == n) {
						comboResult.add(prev);
					}
				}
			}
		}
		return comboResult;
	}
}
