package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringsToAnagrams {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the two strings");
        String first = br.readLine();
        String second = br.readLine();
        System.out.println("Number of characters to remove to make both Strings Anagrams is: " + 
                convertToAnagrams(first, second));
    }

    public static int convertToAnagrams(String first, String second) {
        if(first == null || first.length() == 0) {
            if(second == null || second.length() == 0) {
                return 0;
            } else {
                return second.length();
            }
        } else if(second == null || second.length() == 0) {
            return first.length();
        }

        int count = 0;
        int[] alphaCount = new int[26];

        for(char c : first.toCharArray()) {
            alphaCount[c - 'a']++;
        }

        for(char c : second.toCharArray()) {
            alphaCount[c - 'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(alphaCount[i] != 0) {
                count += Math.abs(alphaCount[i]);
            }
        }
        return count;
    }
}
