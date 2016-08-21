package Arrays;

/*
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * 
 * 
 */
public class AddBinary {
	public static void main(String[] args) {
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		String r = addBinary(a,b);
		System.out.println(r);
	}
	public static String addBinary(String a, String b) {
		int la = a.length();
		int lb = b.length();

		int max = Math.max(la, lb);

		StringBuilder sum = new StringBuilder("");
		int carry = 0;

		for(int i = 0; i < max; i++){
			int m = getBit(a, la - i - 1);
			int n = getBit(b, lb - i - 1);
			int add = m + n + carry;
			sum.append(add % 2);
			carry = add / 2;
		}

		if(carry == 1)
			sum.append("1");

		return sum.reverse().toString();

	}

	public static int getBit(String s, int index){
		if(index < 0 || index >= s.length())
			return 0;

		if(s.charAt(index) == '0')
			return 0;
		else
			return 1;
	}
}