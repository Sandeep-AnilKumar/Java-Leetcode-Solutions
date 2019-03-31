package Arrays;

public class BaseMinus2 {
	public static void main(String[] args) {
		BaseMinus2 minus2 = new BaseMinus2();
		System.out.println(minus2.baseNeg2(6));
		System.out.println(minus2.baseNeg2(4));
		System.out.println(minus2.baseNeg2(3));
		System.out.println(minus2.baseNeg2(2));
		System.out.println(minus2.baseNeg2(1));
		System.out.println(minus2.baseNeg2(17));
		System.out.println(minus2.baseNeg2(21));
		System.out.println(minus2.baseNeg2(-5));
	}

	public String baseNeg2(int n) {
		if (n == 0) return "0";

		StringBuilder sb = new StringBuilder();
		int remainder = 0;
		while (n != 0) {
			remainder = n % -2;
			n /= -2;
			if (remainder < 0) {
				remainder += 2;
				n += 1;
			}
			sb.append(remainder);
		}

		return sb.reverse().toString();
	}
}
