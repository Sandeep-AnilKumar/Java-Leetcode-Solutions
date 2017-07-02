package Arrays;

public class JudgeSquareSum {

	public static void main(String[] args) {
		JudgeSquareSum js = new JudgeSquareSum();
		System.out.println(js.judgeSquareSum(999999999));
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
                return true;
            }
        }
        return false;
	}
}
