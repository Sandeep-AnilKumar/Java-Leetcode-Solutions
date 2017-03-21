package Google;

public class NthDigit {

	public static void main(String[] args) {
		int n = 2147483647;
		System.out.println("The nth digit is := " + findNthDigitBetter(n));
	}

	public static int findNthDigit(int n) {
		if(n <= 9) {
			return n;
		}
		n -= 9;
		int len = 2;
		long count = 90;
		int start = 10;

		while(n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}

	public static int findNthDigitBetter(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
}
