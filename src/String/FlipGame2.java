package String;

import java.util.ArrayList;
import java.util.List;

public class FlipGame2 {

	public static void main(String[] args) {
		String s = "++++";
		System.out.println("Can I win? := " + canWin(s));
	}

	public static boolean canWin(String s) {
		if(s == null || s.length() == 0) {
			return false;
		}

		if(s.indexOf("++") == -1) {
			return false;
		}

		if(countOfPair(s) == 1) {
			return true;
		} else {
			List<String> result = generatePossibleNextMoves(s);
			for(String r: result) {
				if(!canWin(r)) {
					return true;
				}
			}
			return false;
		}
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

	public static int countOfPair(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		int count = 0;
		int length = s.length();
		for(int i = 0; i < length - 1; ++i) {
			if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
				count++;
			}
		}
		return count;
	}
}
