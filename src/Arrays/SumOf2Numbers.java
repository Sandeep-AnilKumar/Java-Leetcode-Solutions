package Arrays;

public class SumOf2Numbers {

	public static void main(String[] args) {
		int a = 5;
		int b = 9;

		System.out.println("Addittion:-> " + getSum(a,b));
		System.out.println("Subtraction:-> " + getSubtract(a,b));
		System.out.println("Product:-> " + getProduct(a,b));
	}

	public static int getSum(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;

		int carry = 0;
		while(b != 0) {
			carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}

	public static int getSubtract(int a, int b) {
		if(a == 0) return (~b + 1);
		if(b == 0) return a;

		int borrow = 0;
		while(b != 0) {
			borrow = (~a) & b;
			a = a ^ b;
			b = borrow << 1;
		}
		return a;
	}
	public static int getProduct(int a, int b) {
		if (a==0 || b==0) return 0;
		int result = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				result = getSum(a,result);
			}
			a <<= 1;
			b >>>= 1;
		}
		return result;
	}
}
