package DynamicProgramming;
import java.util.*;

public class TriangleMinimumPath {

	public static void main(String[] args) {
		List<Integer> inner = new ArrayList<>();
		List<List<Integer>> triangle = new ArrayList<>();
		inner.add(-1);
		List<Integer> clone = new ArrayList<>(inner);
		triangle.add(clone);
		inner.remove(0);
		inner.add(-2);
		inner.add(-3);
		List<Integer> clone2 = new ArrayList<>(inner);
		triangle.add(clone2);
		inner.remove(0);
		inner.remove(0);
		inner.add(-7);
		inner.add(-4);
		inner.add(-5);
		List<Integer> clone3 = new ArrayList<>(inner);
		triangle.add(clone3);
		int minimumPath = minimumTotal(triangle);
		System.out.println("The total minimum path from top to bottom is: " + minimumPath );
	}

	public static int minimumTotal(List<List<Integer>> triangle)
	{
		int sz = triangle.size();
		int[] results = new int[sz+1];

		for(int i=sz-1; i>=0; i--) {
			List<Integer> tmp = triangle.get(i);

			for(int j=0; j<tmp.size(); j++) {
				results[j] = Math.min(results[j], results[j+1]) + tmp.get(j);
			}
		}
		return results[0];
	}
}