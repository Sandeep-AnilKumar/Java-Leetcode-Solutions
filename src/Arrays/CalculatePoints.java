package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sandeepa
 */

public class CalculatePoints {

	public static void main(String[] args) {
		String[] ops = {"5", "2", "C", "D", "+"};
		System.out.println("The total number of points is := " + new CalculatePoints().calPoints(ops));
	}

	public int calPoints(String[] ops) {
		Deque<Integer> points = new ArrayDeque<>();

		int cur = 0, pre = 0, sum = 0;

		for(String op: ops) {
			if(op.equals("D")) {
				pre = points.peekLast();
				cur = 2 * pre;
				points.offerLast(cur);
				sum += cur;
			} else if(op.equals("C")) {
				pre = points.pollLast();
				sum -= pre;
			} else if(op.equals("+")) {
				cur = points.pollLast();
				pre = points.peekLast();
				points.offerLast(cur);
				points.offerLast(cur + pre);
				sum += cur + pre;
			} else {
				cur = Integer.parseInt(op);
				points.offerLast(cur);
				sum += cur;
			}
		}

		return sum;
	}
}
