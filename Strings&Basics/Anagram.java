package String;

/*
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
 * 
 * 
 */



import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Anagram {
	public static void main(String[] args) {
		String strs[] = {"post","stop","tops","loop"};
		List<String> anagramList = anagrams(strs);

		for(String aList : anagramList)
		{
			System.out.println(aList);
		}
	}
	public static List<String> anagrams(String[] strs) {

		HashMap<String,LinkedList<String>> dict = new HashMap<String,LinkedList<String>>();

		for(String s : strs)
		{
			char chars[] = s.toCharArray();
			Arrays.sort(chars);
			String sortedString = String.valueOf(chars);
			if(dict.containsKey(sortedString))
			{
				dict.get(sortedString).add(s);
			}
			else
			{
				LinkedList<String> listString = new LinkedList<String>();
				listString.add(s);
				dict.put(sortedString,listString);
			}
		}
		List<String> ret = new LinkedList<String>();
		for(LinkedList list : dict.values())
		{
			if(list.size()>1)
				ret.addAll(list);
		}
		return ret;
	}

}