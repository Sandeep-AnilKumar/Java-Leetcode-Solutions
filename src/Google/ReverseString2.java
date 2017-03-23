package Google;

public class ReverseString2 {

	public static void main(String[] args) {
		String s = "abcdefghi";
		System.out.println("The reversed string is := " + reverseStr(s, 4));
	}

	public static String reverseStr(String s, int k) {
		if(s == null || s.length() == 0 || k <= 0) {
			return s;
		}

		int length = s.length();
		int start = 0, end = 0;
		char[] cArray = s.toCharArray();
		char temp;

		for(int i = 0; i < length; i += 2 * k) {
			end = i + k - 1 <= length - 1 ? i + k - 1 : length - 1;
			start = i;

			while(start < end) {
				temp = cArray[start];
				cArray[start++] = cArray[end];
				cArray[end--] = temp;
			}
		}
		return new String(cArray);
	}
}

