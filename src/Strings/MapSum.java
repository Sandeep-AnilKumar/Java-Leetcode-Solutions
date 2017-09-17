package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapSum {

	public static void main(String[] args) {
		MapSum mp = new MapSum();
		mp.insert("a", 2);
		System.out.println(mp.sum("ap"));
		mp.insert("a", 4);
		mp.insert("b", 2);
		System.out.println(mp.sum("a"));
	}

	Map<String, Integer> map;
	Set<String> keys;
	public MapSum() {
		map = new HashMap<>();
		keys = new HashSet<>();
	}

	public void insert(String key, int val) {
		if(key == null || key.length() == 0) return;

		StringBuffer sb = new StringBuffer();
		String cur = "";

		if(keys.contains(key)) {
			for(char c: key.toCharArray()) {
				sb.append(c);
				cur = sb.toString();
				map.put(cur, val);
			}
		} else {
			for(char c: key.toCharArray()) {
				sb.append(c);
				cur = sb.toString();
				map.put(cur, map.getOrDefault(sb.toString(), 0) + val);
			}
		}
		keys.add(key);
		return;
	}

	public int sum(String prefix) {
		if(!map.containsKey(prefix)) return 0;
		return map.get(prefix);
	}
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
