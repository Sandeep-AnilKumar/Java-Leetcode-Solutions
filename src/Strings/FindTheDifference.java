package Strings;

public class FindTheDifference {

	public static void main(String[] args) {
		String s = "abcd";
		String t = "abcde";
		System.out.println(findTheDifferenceBetter(s, t));
	}

	public static char findTheDifference(String s, String t) {
		if(s == null || s.length() == 0) {
			if(t == null || t.length() == 0) {
				return ' ';
			}
			return t.charAt(0);
		} else if(t == null || t.length() == 0) {
			return s.charAt(0);
		}
		char c = s.charAt(0);
		for(int i = 1; i < s.length(); ++i) {
			c ^= s.charAt(i);
		}

		for(int i = 0; i < t.length(); ++i) {
			c ^= t.charAt(i);
		}
		return c;
	}

	public static char findTheDifferenceBetter(String s, String t) {
		int sSum = 0;
		int tSum = 0;
		int length = s.length();

		for(int i = 0; i < length; ++i) {
			sSum += (int) s.charAt(i);
			tSum += (int) t.charAt(i);
		}

		tSum += (int) t.charAt(length);
		return (char) (tSum - sSum);
	}
}
