package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LogSystem {
	Map<String, List<Integer>> yMap;
	Map<String, List<Integer>> mMap;
	Map<String, List<Integer>> dMap;
	Map<String, List<Integer>> hMap;
	Map<String, List<Integer>> mmMap;
	Map<String, List<Integer>> sMap;


	public LogSystem() {
		yMap = new TreeMap<>();
		mMap = new TreeMap<>();
		dMap = new TreeMap<>();
		hMap = new TreeMap<>();
		mmMap = new TreeMap<>();
		sMap = new TreeMap<>();
	}
	public static void main(String[] args) {
		LogSystem ls = new LogSystem();
		ls.put(1,"2017:01:01:23:59:59");
		ls.put(2,"2017:01:02:23:59:59");
		ls.put(3, "2016:01:01:00:00:00");
		System.out.println(ls.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"));
		System.out.println(ls.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"));
		System.out.println(ls.retrieve("2017:01:01:23:59:59","2017:01:02:23:59:59","Minute"));
	}

	public void put(int id, String timestamp) {
		if(timestamp == null || timestamp.length() == 0) {
			return;
		}

		String[] parts = timestamp.split(":");
		String year = parts[0];
		String month = parts[1];
		String day = parts[2];
		String hour = parts[3];
		String minute = parts[4];
		String second = parts[5];

		addMap(year, yMap, id);
		addMap(year + "" + month, mMap, id);
		addMap(year + "" + month + "" + day, dMap, id);
		addMap(year + "" + month + "" + day + "" + hour, hMap, id);
		addMap(year + "" + month + "" + day + "" + hour + "" + minute, mmMap, id);
		addMap(year + "" + month + "" + day + "" + hour + "" + minute + "" + second, sMap, id);
		return;
	}

	public void addMap(String cur, Map<String, List<Integer>> map, int id) {
		List<Integer> list = new LinkedList<>();
		if(!map.containsKey(cur)) {
			list = new LinkedList<>();
		} else {
			list = map.get(cur);
		}
		list.add(id);
		map.put(cur, list);
		return;
	}

	public List<Integer> retrieve(String s, String e, String gra) {
		List<Integer> result = new ArrayList<>();

		String[] parts = s.split(":");
		String year = parts[0];
		String month = parts[1];
		String day = parts[2];
		String hour = parts[3];
		String minute = parts[4];
		String second = parts[5];
		String start = "";
		String end = "";
		Map<String, List<Integer>> map = new TreeMap<>();
		String[] eParts = e.split(":");
		String eYear = eParts[0];
		String eMonth = eParts[1];
		String eDay = eParts[2];
		String eHour = eParts[3];
		String eMinute = eParts[4];
		String eSecond = eParts[5];

		if(gra.equals("Year")) {
			start = year;
			map = yMap;
			end = eYear;
		} else if(gra.equals("Month")) {
			start = year + "" + month;
			map = mMap;
			end = eYear + "" + eMonth;
		} else if(gra.equals("Day")) {
			start = year + "" + month + "" + day;
			map = dMap;
			end = eYear + "" + eMonth + "" + eDay;
		} else if(gra.equals("Hour")) {
			start = year + "" + month + "" + day + "" + hour;
			map = hMap;
			end = eYear + "" + eMonth + "" + eDay + "" + eHour;
		} else if(gra.equals("Minute")) {
			start = year + "" + month + "" + day + "" + hour + "" + minute;
			map = mmMap;
			end = eYear + "" + eMonth + "" + eDay + "" + eHour + "" + eMinute;
		} else if(gra.equals("Second")) {
			start = year + "" + month + "" + day + "" + hour + "" + minute + "" + second;
			map = sMap;
			end = eYear + "" + eMonth + "" + eDay + "" + eHour + "" + eMinute + "" + eSecond;
		}

		Set<String> keys = map.keySet();
		long k = 0;
		long sk = Long.parseLong(start);
		long ek = Long.parseLong(end);
		for(String key : keys) {
			k = Long.parseLong(key);
			if(k >= sk && k <= ek) {
				result.addAll(map.get(key));
			}
		}
		return result;
	}
}