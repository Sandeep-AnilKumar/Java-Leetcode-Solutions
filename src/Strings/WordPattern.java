package Strings;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("aba", "dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String str)
    {
        if(pattern == null && pattern.length() == 0 && str == null && str.length() == 0)
            return true;

        if(pattern == null || str == null)
            return false;

        str = str.trim();
        String parts[] = str.split("\\s+");

        if(parts.length != pattern.length())
            return false;

        int n = pattern.length();
        Map<Character, String> mapP = new HashMap<Character, String>();

        for(int i = 0; i < n; i++)
        {
            if(mapP.containsKey(pattern.charAt(i)) && !mapP.get(pattern.charAt(i)).equals(parts[i]) || (mapP.containsValue(parts[i])))
                return false;

            else
            {
                mapP.put(pattern.charAt(i),parts[i]);
            }
        }

        return true;

    }
}