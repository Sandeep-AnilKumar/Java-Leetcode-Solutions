package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransition {
	public static void main(String[] args) {
		PyramidTransition pyramidTransition = new PyramidTransition();
		String bottom = "XXYX";
		List<String> allowed = Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ", "YZX");
		System.out.println("Can a pyramid be constructed? := " + pyramidTransition.pyramidTransition(bottom, allowed));
	}

	public boolean pyramidTransition(String bottom, List<String> allowed) {
		if (allowed == null || allowed.size() == 0) return false;
		List<String> stack = new ArrayList<>();
		stack.add(bottom);
		Map<String, List<String>> map = new HashMap<>();
		String temp = "";

		for (String s : allowed) {
			temp = s.substring(0, 2);
			map.putIfAbsent(temp, new ArrayList<>());
			map.get(temp).add(s);
		}

		int target = bottom.length();
		return buildPyramid(stack, 0, 0, map, target);
	}

	private boolean buildPyramid(List<String> s, int cur, int index,
								 Map<String, List<String>> map, int t) {
		if (s.size() == t) return true;
		String c = s.get(cur);

		if (index == c.length() - 1) return buildPyramid(s, cur + 1, 0, map, t);

		c = c.substring(index, index + 2);
		String temp = "";
		boolean res = false;

		if (map.containsKey(c)) {
			for (String next : map.get(c)) {
				if (s.size() < cur + 2) s.add("");

				temp = s.get(cur + 1);
				s.remove(cur + 1);
				s.add(temp + "" + next.substring(next.length() - 1));

				res = buildPyramid(s, cur, index + 1, map, t);

				temp = s.get(cur + 1);
				s.remove(cur + 1);

				if (temp.length() > 1) s.add(temp.substring(0, temp.length() - 1));

				if (res) break;
			}
		}
		return res;
	}
}
