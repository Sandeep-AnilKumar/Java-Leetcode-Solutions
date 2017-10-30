package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class GrayCode {

	public static void main(String[] args) {
		int n = 4;
		System.out.println("The numbers with " + n + " bits in gray code are := " + new GrayCode().grayCode(n));
	}

	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<>();
		if(n == 0) return new ArrayList<>(Arrays.asList(0));

		list.add(0);
		list.add(1);

		List<Integer> reverse = new ArrayList<>();
		int cur = 0;
		int size = 0;

		for(int i = 1; i < n; ++i) {
			cur = 1 << i;
			reverse = reverseList(list);
			size = reverse.size();

			for(int j = 0; j < size; ++j) {
				list.add(cur + reverse.get(j));
			}
		}
		return list;
	}

	public List<Integer> reverseList(List<Integer> list) {
		int start = 0;
		int end = list.size() - 1;
		int temp = 0;

		List<Integer> reverse = new ArrayList<>(list);

		while(start < end) {
			temp = reverse.get(start);
			reverse.set(start, reverse.get(end));
			reverse.set(end, temp);
			start++;
			end--;
		}
		return reverse;
	}
}
