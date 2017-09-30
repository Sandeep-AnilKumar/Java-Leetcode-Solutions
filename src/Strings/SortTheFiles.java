package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeepa
 */

public class SortTheFiles {

	public static void main(String[] args) {
		int n = 1000000;
		System.out.println("The sorted order of first 1000 files is := ");
		sort(n, new ArrayList<>());
	}

	public static void sort(int n, List<String> result) {
		for(int i = 1; i <= 9 && i <= n; ++i) {
			if(result.size() < 1000) {
				result.add("IMG" + String.valueOf(i) + ".jpg");
				putLex(i, n, result);
			}
		}

		for(String file: result) {
			System.out.println(file);
		}
		return;
	}

	public static void putLex(int cur, int n, List<String> result) {
		int next = 0;
		for(int i = 0; i <= 9; ++i) {
			next = cur * 10 + i;
			if(next <= n && result.size() < 1000) {
				result.add("IMG" + String.valueOf(next) + ".jpg");
				if(next * 10 <= n && result.size() < 1000) {
					putLex(next, n, result);
				}
			}
		}
	}
}
