package Arrays;

public class SmallestFactorization {

	public static void main(String[] args) {
		SmallestFactorization sf = new SmallestFactorization();
		System.out.println("The number which is the smallest factorization of 48 is := " + sf.findFactorizationBetter(120));
	}

	//Not a good solution.
	public int smallestFactorization(int a) {
		int n = a;
		int count = 0;
		while(n > 0) {
			count++;
			n /= 10;
		}
		if(count == 1) {
			return 10 + a;
		}

		int times = count - 2;
		int end = 9;
		while(times-- > 0) {
			end = end * 10 + 9;
		}

		int start = 2;
		int max = Integer.MAX_VALUE;
		int mult = 0;
		while(start <= end) {
			if(start % 10 == 0) {
				start++;
				continue;
			}

			if(end % 10 == 0) {
				end--;
				continue;
			}

			if(start >= (max / end)) {
				return 0;
			}

			mult = getMult(start, end);
			if(mult > a) {
				end--;
			} else if(mult < a) {
				start++;
			} else {
				return (int)((start * (Math.pow(10, count - 1))) + end);
			}
		}
		return 0;
	}

	public int getMult(int start, int end) {
		int mult = 1;

		while(start > 0) {
			mult = mult * (start % 10);
			start /= 10;
		}

		while(end > 0) {
			mult = mult * (end % 10);
			end /= 10;
		}

		return mult;
	}

	public int findFactorizationBetter(int a) {
		if (a < 2) {
			return a;
		}
		long res = 0, mul = 1;
		for (int i = 9; i >= 2; i--) {
			while (a % i == 0) {
				a /= i;
				res = mul * i + res;
				mul *= 10;
			}
		}
		return a < 2 && res <= Integer.MAX_VALUE ? (int)res : 0;
	}
}