package Arrays;

import Strings.IsomorphicStrings;

public class StrobogrammaticNumber {

	public static void main(String[] args) {
		String num = "816906918";
		System.out.println("Is the number strobogrammatic := " + isStrobogrammatic(num));
	}

	public static boolean isStrobogrammatic(String num) {
		if(num == null || num.length() == 0) {
			return true;
		}

		int start = 0;
		int end = num.length() - 1;
		char[] chars = num.toCharArray();
		while(start <= end) {
			if((chars[start] == '2' || chars[start] == '3' || chars[start] =='4' || chars[start] == '5' || chars[start] == '7') || (chars[start] == '6' && chars[end] != '9') || (chars[start] == '9' && chars[end] != '6') || (chars[start] == '1' && chars[end] != chars[start]) || (chars[start] == '8' && chars[end] != chars[start]) || (chars[start] == '0' && chars[end] != chars[start])) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
