package Strings;

public class CompressedStrings {

	public static void main(String[] args) {
		String s = "aabcccccaaa";
		System.out.println("The compressed string is := " + compressString(s));
		s = "abcd";
		System.out.println("The compressed string is := " + compressString(s));
		s = "a";
		System.out.println("The compressed string is := " + compressString(s));
		s = "";
		System.out.println("The compressed string is := " + compressString(s));
	}

	public static String compressString(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}

		int length = s.length();
		StringBuffer sb = new StringBuffer();
		char prev = s.charAt(0);
		sb.append(prev);
		int count = 1;
		char cur;

		for(int i = 1; i < length; ++i) {
			cur = s.charAt(i);
			if(cur == prev) {
				count++;
			} else {
				sb.append(count);
				sb.append(cur);
				count = 1;
			}
			prev = cur;
		}

		sb.append(count);
		return sb.length() < length ? sb.toString() : s;
	}
}
