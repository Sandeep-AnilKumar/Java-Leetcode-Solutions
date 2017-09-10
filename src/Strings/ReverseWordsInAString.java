package Strings;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		String s = "Let's take a leetcode contest;";
		System.out.println("The reversed string is := " + new ReverseWordsInAString().reverseWords(s));
	}

	public String reverseWords(String s) {
		if(s == null || s.length() == 0) return s;

		char[] reverse = s.toCharArray();
		int length = reverse.length;
		char space = ' ';
		int start = 0;
		int end = 0;
		int nextIndex = 0;

		for(int index = 0; index < length; ++index) {
			start = index;
			end = index;
			while(end < length - 1 && reverse[end + 1] != space) {
				end++;
			}
			nextIndex = end + 1;
			while(start < end) {
				reverse[start] = (char)((int)(reverse[start]) ^ (int)(reverse[end]));
				reverse[end] = (char)((int)(reverse[start]) ^ (int)(reverse[end]));
				reverse[start] = (char)((int)(reverse[start++]) ^ (int)(reverse[end--]));
			}
			index = nextIndex;
		}
		return new String(reverse);
	}
}
