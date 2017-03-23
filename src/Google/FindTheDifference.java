package Google;

public class FindTheDifference {

	public static void main(String[] args) {
		String s = "";
		String t = "a";
		System.out.println("The extra character is := " + findTheDifference(s, t));
	}

	//Can be done much efficiently using bit manipulation.
	public static char findTheDifference(String s, String t) {
		int[] count = new int[26];

		for(char c : t.toCharArray()) {
			count[c - 'a']++;
		}

		for(char c : s.toCharArray()) {
			count[c - 'a']--;
		}

		for(int i = 0; i < 26; ++i) {
			if(count[i] == 1) {
				return (char) (97 + i);
			}
		}
		return ' ';
	}
}
