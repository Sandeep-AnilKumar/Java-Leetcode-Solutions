package Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubDomainHits {
	public static void main(String[] args) {
		SubDomainHits subDomainHits = new SubDomainHits();
		String[] c = {"9001 discuss.leetcode.com"};
		System.out.println(subDomainHits.subdomainVisits(c));
	}

	public List<String> subdomainVisits(String[] c) {
		Map<String, Integer> counts = new HashMap<>();
		int cdc = 0;
		String prev;
		String[] parts;
		for (String s : c) {
			prev = null;
			cdc = Integer.parseInt(s.split("\\s+")[0]);
			parts = s.split("\\s+")[1].split("\\.");

			for (int i = parts.length - 1; i >= 0; --i) {
				s = parts[i] + (prev == null ? "" : ("." + prev));
				counts.put(s, counts.getOrDefault(s, 0) + cdc);
				prev = s;
			}
		}
		
		return counts.entrySet().stream().map(e -> e.getValue() + " " + e.getKey()).collect(Collectors.toList());
	}
}
