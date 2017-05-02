package Arrays;

import java.util.ArrayList;
import java.util.List;

import Arrays.NestedListWeightSum.NestedInteger;

public class NestedInteger2 {

	public static void main(String[] args) {
		List<NestedInteger> nestedList = new ArrayList<>();
		List<NestedInteger> innerList = new ArrayList<>();
		nestedList.add(new NestedInteger(1));
		innerList.add(new NestedInteger(4));
		List<NestedInteger> innerinnerList = new ArrayList<>();
		innerinnerList.add(new NestedInteger(6));
		innerList.add(new NestedInteger(innerinnerList));
		nestedList.add(new NestedInteger(innerList));
		System.out.print("The NestedInteger List is := \n[");
		for(NestedInteger n: nestedList) {
			System.out.print(n);
		}
		System.out.println("]");
		System.out.println(depthSumInverse(nestedList));
	}

	//May not work for all cases.
	public static int depthSumInverse(List<NestedInteger> nestedList) {
		if(nestedList == null || nestedList.size() == 0) {
			return 0;
		}

		int size = nestedList.size();
		int[] depths = new int[size];

		for(int i = 0; i < size; ++i) {
			depths[i] = getDepth(nestedList.get(i));
		}

		int max = Integer.MIN_VALUE;
		for(int i: depths) {
			if(i > max) {
				max = i;
			}
		}

		for(int i = 0; i < depths.length; ++i) {
			depths[i] = 1 + max - depths[i];
		}

		int sum = 0;
		int i = 0;
		for(NestedInteger n: nestedList) {
			sum += depthSum(depths[i], n);
			i++;
		}
		return sum;
	}

	public static int depthSum(int depth, NestedInteger n) {
		if(n.isInteger()) {
			return depth * n.getInteger();
		}
		List<NestedInteger> nl = n.getList();
		int sum = 0;
		for(NestedInteger ni: nl) {
			sum +=depthSum(depth, ni);
		}
		return sum;
	}

	public static int getDepth(NestedInteger n) {
		int depth = 1;
		if(n.isInteger()) {
			return depth;
		}
		List<NestedInteger> nl = n.getList();
		depth++;
		while(!nl.get(0).isInteger()) {
			depth++;
			nl = nl.get(0).getList();
		}
		return depth;
	}
}
