package String;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		isAnagram("sort","tors");
	}

	public static boolean isAnagram(String s, String t) {
		if(s == null && s.length() == 0 && t == null && t.length() == 0)
			return true;

		if(s.length() != t.length())
			return false;

		Map<Character,Integer> sMap = new HashMap<Character, Integer>();
		Map<Character, Integer> tMap = new HashMap<Character, Integer>();

		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if(!sMap.containsKey(c))
			{
				sMap.put(c,1);
				continue;
			}
			sMap.put(c,sMap.get(c)+1);
		}

		for(int i = 0; i < t.length(); i++)
		{
			char c = t.charAt(i);
			if(!tMap.containsKey(c))
			{
				tMap.put(c,1);
				continue;
			}
			tMap.put(c,tMap.get(c)+1);
		}

		for(int i = 0; i < s.length(); i++)
		{
			if(tMap.get(s.charAt(i)) != sMap.get(s.charAt(i)))
				return false;
		}
		return true;
	}
}
