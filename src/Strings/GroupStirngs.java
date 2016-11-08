package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupStirngs {

    public static void main(String[] args) {
        String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z", "cb", "am"};
        System.out.println("Grouped Strings are := " + groupStrings(strings));
    }

    public static List<List<String>> groupStrings(String[] strings) {
        if(strings == null || strings.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        String temp = "";
        int value = 0;
        for(String s : strings) {
            temp = "";
            for(char c : s.toCharArray()) {
                value = (c - s.charAt(0) + 26) % 26;
                temp = temp + "," + value;
            }
            if(!map.containsKey(temp)) {
                list = new ArrayList<>();
                map.put(temp, list);
            }
            map.get(temp).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
