package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombinationSum1 {

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		List<List<Integer>> result = combinations1(n,k);

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

	//Better recursive solution.

	public static List<List<Integer>> combinations1(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if(n < 1 || k < 1 || k > n) {
			return result;
		}
		List<Integer> curPath = new ArrayList<>();
		dfs(n, k, curPath, 1, result);
		return result;
	}

	public static void dfs(int n, int k, List<Integer> curPath, int start, List<List<Integer>> result) {
		if(k == curPath.size()) {
			result.add(new ArrayList<Integer>(curPath));
			return;
		}
		if(n < 0) {
			return;
		}

		for(int i = start; i <= n; ++i) {
			curPath.add(i);
			dfs(n, k, curPath, i+1, result);
			curPath.remove(curPath.size() - 1);
		}
	}
}
