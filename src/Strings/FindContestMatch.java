package Strings;

import java.util.ArrayList;
import java.util.List;

public class FindContestMatch {

	public static void main(String[] args) {
		FindContestMatch fcm = new FindContestMatch();
		int n = 8;
		System.out.println("The contest matches are := " + fcm.findContestMatch(n));
	}

	public String findContestMatch(int n) {
		if(n < 2) {
			return " ";
		}

		List<String> prev = new ArrayList<>();
		for(int i = 1; i <= n; ++i) {
			prev.add(String.valueOf(i));
		}

		int k = (int) Math.sqrt(n);
		List<String> cur = new ArrayList<>();
		int size = 0;

		while(k-- > 0) {
			cur = new ArrayList<>();
			size = prev.size();

			for(int i = 0; i < size / 2; ++i) {
				cur.add("(" + prev.get(i) + "," + prev.get(size - i - 1) + ")");
			}
			prev = new ArrayList<>(cur);
		}
		return prev.get(0);
	}
}
