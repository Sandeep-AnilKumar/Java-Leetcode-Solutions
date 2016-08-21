package Arrays;

import java.util.LinkedList;
import java.util.List;

public class StringOutput {

	public static void main(String[] args) {
		String[] words = new String[]{"foo","bar","the"};
		List<String> result = findPerms(words);
		for(int i = 0; i <= words.length; ++i) {
			result.remove(0);
		}

		String test = "barfoothefoobarman";
		List<Integer> indexes = new LinkedList<Integer>();

		for(String word : result) {
			int index = test.indexOf(word);
			if(index != -1) {
				indexes.add(index);
				System.out.println("'" + word + "' --> " + index);
			}
		}
	}

	public static List<String> findPerms(String[] words) {
		if(words == null || words.length == 0) {
			return null;
		}

		List<String> result = new LinkedList<String>();
		result.add("");
		int length = words.length;
		int size = result.size();

		for(int i = 0; i < size; ++i) {
			String prev = result.get(i);
			for(int j = 0; j < length; j++) {
				if(!prev.equals(words[j]) && !prev.contains(words[j])) {
					result.add(words[j] + prev);
				}
				size = result.size();
			}
		}
		return result;
	}
}
