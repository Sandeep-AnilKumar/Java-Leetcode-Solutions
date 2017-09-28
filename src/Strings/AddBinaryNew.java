package Strings;

/**
 * @author sandeepa
 */

public class AddBinaryNew {

	public static void main(String[] args) {
		String a = "11";
		String b = "1";

		System.out.println("The resultant string is := " + new AddBinaryNew().addBinary(a, b));
	}

	public String addBinary(String a, String b) {
		if(a == null || a.length() == 0) return b;
		if(b == null || b.length() == 0) return a;

		char[] charsA = a.toCharArray();
		char[] charsB = b.toCharArray();

		int i = charsA.length - 1;
		int j = charsB.length - 1;
		int carry = 0;
		int sum = 0;
		StringBuffer sb = new StringBuffer();

		while(i >= 0 || j >= 0) {
			sum = carry + (i >= 0 ? charsA[i] -'0' : 0) + (j >= 0 ? charsB[j] -'0' : 0);

			carry = sum / 2;
			sum %= 2;

			sb.append(String.valueOf(sum));
			i--;
			j--;
		}

		if(carry > 0) {
			sb.append(String.valueOf(carry));
		}

		return sb.reverse().toString();
	}
}
