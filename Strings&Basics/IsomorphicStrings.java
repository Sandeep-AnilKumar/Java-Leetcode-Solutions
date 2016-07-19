package String;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("1221","4848"));

	}

	public static boolean isIsomorphic(String s, String t) 
	{
		if(s == null && s.length() == 0 && t == null && t.length() == 0)
			return true;

		Map<Character, Integer> mapS = new TreeMap<Character, Integer>();
		Map<Character, Integer> mapT = new TreeMap<Character, Integer>();

		for(int i = 0; i < s.length(); i++)
		{
			if(!mapS.containsKey(s.charAt(i)))
				mapS.put(s.charAt(i), 1);
			else
				mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1);

			if(!mapT.containsKey(t.charAt(i)))
				mapT.put(t.charAt(i), 1);
			else
				mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1);
		}

		for(int i = 0; i < s.length(); i++)
		{
			if(mapS.get(s.charAt(i)) != mapT.get(t.charAt(i)))
				return false;
		}

		return true;
	}

}
