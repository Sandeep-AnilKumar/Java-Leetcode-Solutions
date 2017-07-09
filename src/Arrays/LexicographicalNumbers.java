package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

	public static void main(String[] args) {
		int n = 13;
		LexicographicalNumbers ln = new LexicographicalNumbers();
		System.out.println(ln.lexicalOrder(n));
	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> lex = new ArrayList<>();

		for(int m = 1; m <= n && m < 10; ++m) {
			lex.add(m);
			addNums(lex, m, n);
		}
		return lex;
	}

	public void addNums(List<Integer> lex, int cur, int n) {
		int temp = 0;
		for(int k = 0; k <= 9; ++k) {
			if(cur * 10 + k <= n) {
				temp = cur * 10 + k;
				lex.add(temp);
				addNums(lex, temp, n);
			} else {
				break;
			}
		}
		return;
	}
}
