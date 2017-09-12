package Strings;

public class StrangePrinter {

	public static void main(String[] args) {
		StrangePrinter Printer = new StrangePrinter();
		String s = "abababcbdad";
		System.out.println("The minimum number of times the printer has to move is := " + Printer.strangePrinterSolution(s));
	}

	//Not the right answer.
	public int strangePrinter(String s) {
		if(s == null || s.length() == 0) return 0;
		int length = s.length();
		int[] dp = new int[length + 1];
		dp[1] = 1;

		char[] chars = s.toCharArray();
		int[] seenAt = new int[26];
		seenAt[chars[0] - 'a'] = 1;
		char curChar;

		for(int i = 1; i < length; ++i) {
			curChar = chars[i];

			if(curChar == chars[i - 1]) {
				dp[i + 1] = dp[i];
			} else if(seenAt[curChar - 'a'] == 0 || (i - seenAt[curChar - 'a'] - 1 > 2)){
				dp[i + 1] = dp[i] + 1;
			} else {
				dp[i + 1] = Math.min(dp[i], dp[seenAt[curChar - 'a']]) + 1;
			}
			seenAt[curChar - 'a'] = i + 1;
		}
		return dp[length];
	}

	public int strangePrinterSolution(String s) {
		int n = s.length();
		if (n == 0) return 0;

		int[][] dp = new int[101][101];
		for (int i = 0; i < n; i++) dp[i][i] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				dp[j][j + i] = i + 1;
				for (int k = j + 1; k <= j + i; k++) {
					int temp = dp[j][k - 1] + dp[k][j + i];
					if (s.charAt(k - 1) == s.charAt(j + i)) temp--;
					dp[j][j + i] = Math.min(dp[j][j + i], temp);
				}
			}
		}
		return dp[0][n - 1];
	}
}
