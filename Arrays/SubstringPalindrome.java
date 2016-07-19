package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubstringPalindrome {

	public static void main(String[] args) {
		palindromes("aabaa");
	}

	public static Map<String,Integer> palindromes(final String input) {

		final Map<String,Integer> result = new HashMap<String,Integer>();

		for (int i = 0; i < input.length(); i++) {
			int j = i+1;
			int k = i;
			while (i >= 0 && j < input.length() && input.charAt(i) == input.charAt(j)) {
				if(!result.containsKey(input.substring(i,j+1)))
				{
					result.put(input.substring(i,j+1),1);
					String c = ""+ input.charAt(i);
					result.put(c, 1);
				}
				i--; j++;
			} 
			i = k;
		}
		return result;

		/*public static void expandPalindromes(final Map<String,Integer> result, final String s, int i, int j) {
		}
	}*/
	}
}
