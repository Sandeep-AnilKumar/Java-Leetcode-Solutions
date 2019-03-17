package BitManipulation;

public class Complement {
	public static void main(String[] args) {
		Complement complement = new Complement();
		int n = 5;
		System.out.println(complement.bitwiseComplement(n));
		n = 10;
		System.out.println(complement.bitwiseComplement(n));
		n = 0;
		System.out.println(complement.bitwiseComplement(n));
		n = 1;
		System.out.println(complement.bitwiseComplement(n));
		n = 6;
		System.out.println(complement.bitwiseComplement(n));
		n = 20;
		System.out.println(complement.bitwiseComplement(n));
	}

	public int bitwiseComplement(int n) {
		if (n == 0) return 1;
		if (n == 1) return 0;
		int r = 0, i = 0;

		while (n > 1) {
			if (n % 2 == 0) {
				r += (1 << i);
			}
			n /= 2;
			i++;
		}

		return r;
	}
}
