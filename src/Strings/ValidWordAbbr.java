package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sandeepa
 */

public class ValidWordAbbr {

	String[] abb;
	Map<String, Set<String>> count;
	int length;
	public ValidWordAbbr(String[] dictionary) {
		length = dictionary.length;
		abb = new String[length];
		count = new HashMap<>();
		Set<String> words = new HashSet<>();

		for(int i = 0; i < length; ++i) {
			abb[i] = abbreviate(dictionary[i]);
			words = count.containsKey(abb[i]) ? count.get(abb[i]) : new HashSet<>();
			words.add(dictionary[i]);
			count.put(abb[i], words);
		}
	}

	public boolean isUnique(String word) {
		String abb = abbreviate(word);
		if(!count.containsKey(abb) || (count.get(abb).contains(word) && (count.get(abb).size() == 1))) {
			return true;
		}

		return false;
	}

	public String abbreviate(String word) {
		if(word == null || word.length() <= 2) {
			return word;
		}

		int length = word.length();

		return word.charAt(0) + "" + (length - 2) + "" + word.charAt(length - 1);
	}

	public static void main(String[] args) {
		String[] dictionary = {"deer", "door", "cake", "cart"};
		ValidWordAbbr abbr = new ValidWordAbbr(dictionary);

		for(String word : dictionary) {
			System.out.println("Is the word abbr of '" + word + "' unique in dictionary? := " + abbr.isUnique(word));
		}

		System.out.println("Is the word abbr of 'doctor' unique in dictionary? := " + abbr.isUnique("doctor"));
		System.out.println("Is the word abbr of 'cane' unique in dictionary? := " + abbr.isUnique("cane"));
	}
}
