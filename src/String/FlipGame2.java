package String;

import java.util.ArrayList;
import java.util.List;

public class FlipGame2 {

	public static void main(String[] args) {
		String s = "+++++++++";
		System.out.println("Can I win? := " + canWinBetter(s));
	}

	//A bit lengthy and complicated.
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

	//A much easier solution.
	public static boolean canWinBetter(String s) {
		char[] cs = s.toCharArray();
		return canWin(cs, cs.length);
	}

	private static boolean canWin(char[] cs, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (cs[i] == '+' && cs[i + 1] == '+') {
				cs[i] = '-';
				cs[i + 1] = '-';
				boolean res = canWin(cs, n);
				cs[i] = '+';
				cs[i + 1] = '+';
				if (!res) return true;
			}
		}
		return false;
	}
}
