package Arrays;

public class AtMostNGivenDigitSet {
	public static void main(String[] args) {
		AtMostNGivenDigitSet digitSet = new AtMostNGivenDigitSet();
		String[] d = {"1", "3", "7"};
		int[] m = {1, 3, 5};
		int n = 121;
		System.out.println("The total numbers that can be formed are := " + digitSet.atMostNGivenDigitSet(d, n));
	}

	public int atMostNGivenDigitSet(String[] d, int n) {
		String s = String.valueOf(n);
		int[] nums = new int[d.length];

		for (int i = 0; i < d.length; ++i) {
			nums[i] = Integer.parseInt(d[i]);
		}

		int length = s.length();
		int total = getDigits(d.length, length - 1);
		return total + helper(d, Integer.toString(n));
	}

	private int helper(String[] D, String n) {
		if (n.length() == 0 || n.charAt(0) == '0') return 0;
		int N = Integer.parseInt(n);
		int ct = 0, res = 0;
		boolean flag = false;
		for (int i = 0; i < D.length; i++) {
			if (D[i].charAt(0) <= n.charAt(0)) ct++;
			if (D[i].charAt(0) == n.charAt(0)) flag = true;
		}
		if (N > 10 && flag) ct--;
		res += ct * Math.pow(D.length, n.length() - 1);
		if (flag && N > 10) res += helper(D, n.substring(1));
		return res;
	}

	private int getDigits(int choices, int power) {
		int total = 0;
		while (power > 0) {
			total += Math.pow(choices, power);
			power--;
		}
		return total;
	}
}
