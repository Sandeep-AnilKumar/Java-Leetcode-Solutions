package Arrays;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum {

	static class NestedInteger extends AbstractList{
		int value;
		List<NestedInteger> l;

		NestedInteger(int value) {
			this.value = value;
		}

		NestedInteger(List<NestedInteger> l) {
			this.l = new ArrayList<>(l.size());
			for(NestedInteger i: l) {
				this.l.add(i);
			}
		}

		public boolean isInteger() {
			if(l == null) {
				return true;
			}
			return false;
		}

		public Integer getInteger() {
			if(l == null) {
				return value;
			}
			throw new NullPointerException();
		}

		public List<NestedInteger> getList() {
			return l;
		}

		public Object get(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String toString() {
			if(this.isInteger()) {
				return String.valueOf(this.getInteger());
			}
			return this.getList().toString();
		}
	}

	public static void main(String[] args) {
		List<NestedInteger> nestedList = new ArrayList<>();
		List<NestedInteger> innerList = new ArrayList<>();
		innerList.add(new NestedInteger(1));
		innerList.add(new NestedInteger(1));
		nestedList.add(new NestedInteger(innerList));
		nestedList.add(new NestedInteger(2));
		nestedList.add(new NestedInteger(innerList));

		System.out.println(depthSum(nestedList));
	}

	public static int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1);
	}

	public static int depthSum(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		if(nestedList == null) {
			return sum;
		}

		for(NestedInteger n: nestedList) {
			if(n.isInteger()) {
				sum += depth * n.getInteger();
			} else {
				sum += depthSum(n.getList(), depth + 1);
			}
		}
		return sum;
	}
}
