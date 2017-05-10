package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

	public static void main(String[] args) {
		String s = "leetCOdE";
		System.out.println("The string '" + s + "' after reversing the vowles is :=" + reverseVowels(s));
	}

	public static String reverseVowels(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}

		int start = 0;
		int end = s.length() - 1;
		int length = s.length();
		char[] chars = s.toCharArray();
		Character[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
		Set<Character> vowelSet = new HashSet<>(Arrays.asList(vowels));

		while(start < end) {
			while(start < length && !vowelSet.contains(chars[start])) start++;
			while(end >= 0 && !vowelSet.contains(chars[end])) end--;
			if(start < end) {
				chars[start] ^= chars[end];
				chars[end] ^= chars[start];
				chars[start] ^= chars[end];
			}
			start++;
			end--;
		}
		return new String(chars);
	}
}
