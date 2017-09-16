package String;

public class MaximumSwap {

	public static void main(String[] args) {
		MaximumSwap swap = new MaximumSwap();
		int num = 9193;
		System.out.println("The maximum number after at most one swap is := " + swap.maximumSwapBetter(num));
	}

	public int maximumSwap(int num) {
		if(num == 0) return 0;
		char[] digits = String.valueOf(num).toCharArray(); 
		int length = digits.length;
		String max = new String(digits);
		char curMax;

		for(int i = 0; i < length - 1; ++i) {
			curMax = digits[i];
			for(int j = i + 1; j < length; ++j) {
				if(digits[j] > digits[i] && digits[j] >= curMax) {
					curMax = digits[j];
					max = swapAndCompare(digits, i, j, max);
				}
			}
		}
		return Integer.parseInt(max);
	}

	public String swapAndCompare(char[] digits, int i, int j, String max) {
		char temp = digits[i];
		digits[i] = digits[j];
		digits[j] = temp;
		String cur = new String(digits);
		temp = digits[j];
		digits[j] = digits[i];
		digits[i] = temp;

		if(cur.compareTo(max) > 0) return cur;
		return max;
	}

	public int maximumSwapBetter(int num) {
		char[] A = Integer.toString(num).toCharArray();
		int[] last = new int[10];
		for (int i = 0; i < A.length; i++) {
			last[A[i] - '0'] = i;
		}

		for (int i = 0; i < A.length; i++) {
			for (int d = 9; d > A[i] - '0'; d--) {
				if (last[d] > i) {
					char tmp = A[i];
					A[i] = A[last[d]];
					A[last[d]] = tmp;
					return Integer.valueOf(new String(A));
				}
			}
		}
		return num;
	}
}
