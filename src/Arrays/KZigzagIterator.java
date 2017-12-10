package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class KZigzagIterator {

	int row;
	int col;
	int size;
	List<List<Integer>> lists;

	public KZigzagIterator(List<List<Integer>> lists) {
		this.lists = lists;
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
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> v1 = Arrays.asList(1, 2, 3);
		List<Integer> v2 = Arrays.asList(4);
		List<Integer> v3 = Arrays.asList(5, 6, 7, 8);
		List<Integer> v4 = Arrays.asList();
		List<Integer> v5 = Arrays.asList(9, 10, 11, 12);
		lists.add(v1);
		lists.add(v2);
		lists.add(v3);
		lists.add(v4);
		lists.add(v5);

		KZigzagIterator iterator = new KZigzagIterator(lists);

		while(iterator.hasNext()) {
			System.out.print(iterator.next() + ", ");
		}
	}
}
