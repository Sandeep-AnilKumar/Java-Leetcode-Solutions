package Google;

public class ReverseString2 {

	public static void main(String[] args) {
		String s = "abcdefghi";
		System.out.println("The reversed string is := " + new ReverseString2().reverseStr(s, 3));
	}

	public String reverseStr(String s, int k) {
		char[] chars = s.toCharArray();
		int length = chars.length;

		for(int i = 0; i < length; ++i) {
			reverseChars(chars, i, i + k <= length ? i + k - 1 : length - 1);
			i += 2 * k - 1;
		}

		return new String(chars);
	}

	public void reverseChars(char[] chars, int start, int end) {
		while(start < end) {
			chars[start] = (char)(((int)(chars[start])) ^ ((int)(chars[end])));
			chars[end] = (char)(((int)(chars[start])) ^ ((int)(chars[end])));
			chars[start] = (char)(((int)(chars[start++])) ^ ((int)(chars[end--])));
		}
	}
}

