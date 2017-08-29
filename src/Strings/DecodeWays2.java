package Strings;

public class DecodeWays2 {

	public static void main(String[] args) {
		DecodeWays2 decode = new DecodeWays2();
		String s = "10*2";
		System.out.println("The number of ways to decode is := " + decode.numDecodings(s));
	}

	public int numDecodings(String s) {
		if(s== null || s.length() == 0) return 0;

		int length = s.length();
		long first = 1;
		long second = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;

		if(length <= 1) return (int) second;

		char curChar, prevChar;
		long mod = 1000000007;
		long cur = 0;

		for(int i = 2; i <= length; ++i) {
			curChar = s.charAt(i - 1);
			prevChar = s.charAt(i - 2);
			cur = 0;

			if(curChar != '*') {
				if(curChar != '0') {
					cur = (cur + second) % mod;
				}
				if(prevChar == '1' || (prevChar == '2' && curChar <= '6')) {
					cur = (cur + first) % mod;
				} else if(prevChar == '*') {
					if(curChar <= '6') {
						cur = (cur + 2 * first) % mod;
					} else if(curChar > '6') {
						cur = (cur + 1 * first) % mod;
					}
				}
			} else if(curChar == '*') {
				cur = (cur + 9 * second) % mod;

				if(prevChar == '1') {
					cur = (cur + 9 * first) % mod;
				} else if(prevChar == '2') {
					cur = (cur + 6 * first) % mod;
				} else if(prevChar == '*') {
					cur = (cur + 15 * first) % mod;
				}
			}

			first = second;
			second = cur;
		}
		return (int) cur; 
	}
}
