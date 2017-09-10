package Google;

public class ReverseString2 {

	public static void main(String[] args) {
		String s = "abcdefghi";
		System.out.println("The reversed string is := " + reverseStr(s, 4));
	}

	public static String reverseStr(String s, int k) {
		if(s == null || s.length() == 0) return s;

		char[] chars = s.toCharArray();
		int start = 0;
		int end = chars.length - 1;

		while(start < end) {
			chars[start] = (char)(((int)(chars[start])) ^ ((int)(chars[end])));
			chars[end] = (char)(((int)(chars[start])) ^ ((int)(chars[end])));
			chars[start] = (char)(((int)(chars[start++])) ^ ((int)(chars[end--])));
		}
		return new String(chars);
	}
}

