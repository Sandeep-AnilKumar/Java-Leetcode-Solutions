package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepa
 */

public class Codec {

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for(String str : strs) {
			sb.append(str.length() + "/#/" + str);
		}

		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> strs = new ArrayList<>();
		int size = 0;
		int index = 0;
		while(s != null && s.length() > 0) {
			index = s.indexOf("/#/");
			size = Integer.parseInt(s.substring(0, index));
			strs.add(s.substring(index + 3, index + 3 + size));
			s = s.substring(index + 3 + size);
		}

		return strs;
	}

	public static void main(String[] args) {
		Codec codec = new Codec();
		List<String> strs = Arrays.asList("Hi How are you?0/2/#", "I am fine, thank you!");

		System.out.print("The encoded string is := ");
		String s = codec.encode(strs);
		System.out.println(s);

		System.out.println("The decoded string is := " + codec.decode(s));
	}
}
