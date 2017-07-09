package Arrays;

public class SumOfSquareNumbers {

	public static void main(String[] args) {
		SumOfSquareNumbers sn = new SumOfSquareNumbers();
		System.out.println(sn.judgeSquareSum(5));
		System.out.println(sn.judgeSquareSum(3));
	}

	public boolean judgeSquareSum(int c) {
		if (c < 0) {
			return false;
		}
		int left = 0, right = (int)Math.sqrt(c);
		while (left <= right) {
			int cur = left * left + right * right;
			if (cur < c) {
				left++;
			} else if (cur > c) {
				right--;
			} else {
				System.out.println(c + " = " + left + " * " + left + " + " + right + " * " + right);
				return true;
			}
		}
		return false;
	}
}
