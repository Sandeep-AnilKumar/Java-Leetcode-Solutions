package Arrays;

public class ReverseBits {

	public static void main(String[] args) {
		int n = 5;
		String s = Integer.toBinaryString(n);
		StringBuffer sb = new StringBuffer();
		int length = s.length();
		for(int i = 0; i < 32-length; ++i) {
			sb.append("0");
		}
		s = sb.toString() + s;

		System.out.println("\nBefore reverse: \n" + s);
		System.out.println("\nAfter reverse:\n" + Integer.toBinaryString(reverseBits(n)));
	}

	public static int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; ++i) {
			result = result<<1  | (n & 1);
			n >>>= 1;
		}
		return result;  
	}
}
