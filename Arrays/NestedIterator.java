package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

	Deque<NestedInteger> dq;

	NestedIterator(List<NestedInteger> nestedList) {
		dq = new ArrayDeque<NestedInteger>();
		flattenList(nestedList);
	}

	public Integer next() {
		return hasNext() ? dq.removeFirst().getInteger() : null;
	}

	public boolean hasNext() {
		while(!dq.isEmpty()) {
			NestedInteger cur = dq.peekFirst();

			if(cur.isInteger()) {
				return true;
			}
			else {
				flattenList(dq.removeFirst().getList());
			}
		}
		return false;
	}

	public void flattenList(List<NestedInteger> curList) {
		int size = curList.size();
		for(int i = size - 1; i >= 0; --i) {
			dq.addFirst(curList.get(i));
		}
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */