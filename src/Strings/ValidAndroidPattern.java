package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class ValidAndroidPattern {

	public static void main(String[] args) {
		String pattern = "14835926";
		System.out.println("Is '" + pattern + "' a valid android pattern? := " + new ValidAndroidPattern().isValidPattern(pattern));
	}

	public String isValidPattern(String pattern) {
		if(pattern == null || pattern.length() == 0) return "valid";

		int length = pattern.length();
		boolean[] visited = new boolean[10];
		int[] neighbor = {-1, 0, 2, 0, 3, 1, 3, 0, 2, 0};
		List<List<Integer>> neighbors = new ArrayList<>();

		neighbors.add(Arrays.asList(2, 4, 5, 6, 8));
		neighbors.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		neighbors.add(Arrays.asList(1, 3, 4, 5, 6, 7, 9));
		neighbors.add(Arrays.asList(1, 2, 3, 5, 7, 8, 9));

		int cur = 0, prev = pattern.charAt(0) - '0';
		visited[prev] = true;

		for(int i = 1; i < length; ++i) {
			cur = pattern.charAt(i) - '0';

			if(visited[cur] || !neighbors.get(neighbor[prev]).contains(cur)) return "invalid";
			visited[cur] = true;

			prev = cur;
		}
		return "valid";
	}
}
