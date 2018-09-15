package Strings;

public class ValidAnagram2 {
    public boolean isAnagram(String s, String t) {
        if (s == null) return t == null;
        if (t == null || t.length() != s.length()) return false;

        int[] count = new int[26];
        int diff = 0;
        int length = s.length();

        for (int i = 0; i < length; ++i) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
            if (count[s.charAt(i) - 'a'] == 0) {
                diff--;
            } else {
                diff++;
            }

            if (count[t.charAt(i) - 'a'] == 0) {
                diff--;
            } else {
                diff++;
            }
        }

        return diff == 0;
    }

    public static void main(String[] args) {
        String s = "yqhbicoumu";
        String t = "ouiuycbmqh";
        System.out.println("Are the anagrams valid? := " + new ValidAnagram2().isAnagram(s, t));
    }
}
