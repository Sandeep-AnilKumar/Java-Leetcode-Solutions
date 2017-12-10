package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class ZigzagIterator {
	int row;
	int col;
	int size;
	List<List<Integer>> lists;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.lists = new ArrayList<>();
		lists.add(v1);
		lists.add(v2);
		row = 0;
		col = 0;
		size = lists.size();
	}

	public int next() {
		int val = lists.get(row++).get(col);
		if(row == size) {
			row = 0;
			col++;
		}

		return val;
	}

	public boolean hasNext() {
		boolean found = false;
		int count = size;
		while(count-- > 0) {
			if(lists != null && lists.get(row) != null && lists.get(row).size() > col) {
				found = true;
				break;
			}

			row++;
			if(row == size) {
				row = 0;
				col++;
			}
		}

		return found;
	}

	public static void main(String[] args) {
		List<Integer> v1 = Arrays.asList(1, 2, 3);
		List<Integer> v2 = Arrays.asList(4, 5, 6, 7, 8, 9, 10);

		ZigzagIterator iterator = new ZigzagIterator(v1, v2);
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + ", ");
		}
	}
}


//Naive approach
//public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//		this.v1 = v1;
//		this.v2 = v2;
//		cur = v1;
//		index = 0;
//	}
//
//	public int next() {
//		int val = cur.get(index);
//		if(cur == v1) {
//			cur = v2;
//		} else {
//			cur = v1;
//			index++;
//		}
//
//		return val;
//	}
//
//	public boolean hasNext() {
//		if(cur != null && cur.size() > index) {
//			return true;
//		} else {
//			if(cur == v1) {
//				cur = v2;
//			} else {
//				cur = v1;
//				index++;
//			}
//		}
//
//		return cur != null && cur.size() > index;
//	}