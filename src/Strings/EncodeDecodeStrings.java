package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {

	public static void main(String[] args) {
		EncodeDecodeStrings ed = new EncodeDecodeStrings();
		List<String> strs = Arrays.asList("hat", "has", "you", "*123*");
		String encode = ed.encode(strs);
		System.out.println("The encoded list string is := " + encode);

		List<String> decoded = ed.decode(encode);
		System.out.println("The decoded string list is " + decoded);
	}

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		if(strs == null || strs.size() == 0) {
			return "0/0";
		}

		int size = strs.size();
		StringBuffer sb = new StringBuffer();
		int count = 0;
		for(String s: strs) {
			count += s.length();
		}

		sb.append(count + "/" + size + "/");
		for(String s: strs) {
			sb.append(s.length() + "/" + s + "/");
		}
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		if(s == null || s.length() == 0 || s.equals("0/0")) {
			return new ArrayList<String>();
		}
		List<String> list = new ArrayList<>();
		int totalCount = 0;
		int curCount = 0;

		int length = s.length();
		char[] array = s.toCharArray();
		int num = 0;
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while(i < length && array[i] != '/') {
			num = num * 10 + array[i] - '0';
			i++;
		}
		totalCount = num;
		i++;
		num = 0;
		while(i < length && array[i] != '/') {
			num = num * 10 + array[i] - '0';
			i++;
		}
		i++;
		int parts = num;

		while(parts-- > 0) {
			num = 0;
			sb = new StringBuffer();
			while(i < length && array[i] != '/') {
				num = num * 10 + array[i] - '0';
				i++;
			}
			i++;
			curCount = num;
			while(i < length && curCount-- > 0) {
				sb.append(array[i++]);
			}
			i++;
			list.add(sb.toString());
		}

		curCount = 0;
		for(String l: list) {
			curCount += l.length();
		}

		if(curCount == totalCount) {
			return list;
		}
		return new ArrayList<>();
	}
}
