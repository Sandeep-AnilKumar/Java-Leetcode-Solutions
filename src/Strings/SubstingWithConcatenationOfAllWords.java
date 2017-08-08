package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstingWithConcatenationOfAllWords {

	public static void main(String[] args) {
		SubstingWithConcatenationOfAllWords sc = new SubstingWithConcatenationOfAllWords();
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar", "man"};
		System.out.println(sc.findSubstring(s, words));
	}
	
	//Good solution, but will fail TLE kind of inputs.
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> indices = new ArrayList<>();
		if(s == null || s.length() == 0 || words == null || words.length == 0 || s.length() < words[0].length()) {
			return indices;
		}

		List<List<String>> perms = new ArrayList<>();
		getPerms(s, words, 0, words.length -1, perms);
		StringBuffer sb = new StringBuffer();
		boolean notPresent = false;
		System.out.println(perms);

		for(List<String> perm: perms) {
			sb = new StringBuffer();
			notPresent = false;
			for(String p: perm) {
				sb.append(p);
				if(!s.contains(sb.toString())) {
					notPresent = true;
					break;
				}
			}

			if(!notPresent) {
				indices.add(s.indexOf(sb.toString()));
			}
		}
		return indices;
	}

	public void getPerms(String s, String[] words, int start, int end, List<List<String>> perms) {
		if(start == end) {
			perms.add(new ArrayList<>(Arrays.asList(words)));
			return;
		}

		StringBuffer sb = new StringBuffer();
		for(int i = 0; i <= start; ++i) {
			sb.append(words[i]);
		}

		if(s.contains(sb.toString())) {
			for(int i = start; i <= end; ++i) {
				swap(words, i, start);
				getPerms(s, words, start + 1, end, perms);
				swap(words, i, start);
			}
		}
		return;
	}

	public void swap(String[] words, int i, int j) {
		if(i != j) {
			String temp = words[i];
			words[i] = words[j];
			words[j] = temp;
		}
		return;
	}
}
