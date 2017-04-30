package Strings;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

	public static void main(String[] args) {
		String s = "++-+++-+-+";
		System.out.println(generatePossibleNextMoves(s));
	}

	public static List<String> generatePossibleNextMoves(String s) {
		if(s == null || s.length() == 0) {
			return new ArrayList<String>();
		}

		List<String> result = new ArrayList<>();
		int length = s.length();
		String curMove = "";

		for(int i = 0; i < length - 1; ++i) {
			if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
				result.add(curMove = s.substring(0, i) + "" + "--" + s.substring(i+2));
			}
		}
		return result;
	}
}
