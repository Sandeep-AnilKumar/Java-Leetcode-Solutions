package Google;

public class ValidWordAbbrevation {

	public static void main(String[] args) {
		String word = "internationalization";
		String abbr = "i12i4on";
		System.out.println("Is valid word abbrevation? := " + validWordAbbreviation(word, abbr));
	}

	//might not work for some cases.
	public static boolean validWordAbbreviation(String word, String abbr) {
		if(abbr.length() > word.length()) {
			return false;
		}
		int wLength = word.length();
		int aLength = abbr.length();
		int temp = 0;
		StringBuilder sb = new StringBuilder();
		char a;
		String prev = "";

		for(int i = 0, j = 0; i < wLength && j < aLength; ++j) {
			a = abbr.charAt(j);
			temp = (int) a;
			if(temp >= 97 && temp <= 122) {
				prev = sb.toString();
				i = prev != null && prev.length() != 0 ? i + Integer.parseInt(prev) : i;
				if(i >= wLength || a != word.charAt(i)) {
					return false;
				}
				sb = new StringBuilder();
				++i;
			} else if(j != aLength - 1){
				if(a - '0' == 0 && sb.toString().length() == 0) {
					return false;
				}
				sb.append(a);
			} else {
				if(a - '0' == 0 && sb.toString().length() == 0) {
					return false;
				}
				sb.append(a);
				prev = sb.toString();
				if(wLength - i == Integer.parseInt(prev)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	//will not map the number of times a character occurs.
	public static boolean validWordAbbreviationBetter(String word, String abbr) {
		int temp = 0, total = 0;
		int[] count = new int[26];
		StringBuilder sb = new StringBuilder();
		String prev = "";

		for(char c : word.toCharArray()) {
			count[c - 'a']++;
		}

		for(char c : abbr.toCharArray()) {
			temp = (int) c;

			if(temp >= 97 && temp <= 122) {
				prev = sb.toString();
				if(prev != null && prev.length() != 0) {
					sb = new StringBuilder();
					total += Integer.parseInt(prev);
				}
				count[c - 'a']--;
			} else {
				sb.append(c);
			}
		}

		prev = sb.toString();
		if(prev != null && prev.length() != 0) {
			total += Integer.parseInt(prev);
		}

		for(int i = 0; i < 26; ++i) {
			total -= count[i];
		}

		return total == 0;
	}

	//most elegant.

	public static boolean validWordAbbreviationBest(String word, String abbr) {
		if(word == null || abbr == null || abbr.length() > word.length()) {
			return false;
		}
		int num = 0;
		int idx = 0;

		for(char c: abbr.toCharArray()){
			if(c == '0' && num == 0) {
				return false;
			}
			if(c >= '0' && c <= '9'){
				num = num*10 + (c-'0');
			} else {
				idx += num;
				if(idx >= word.length() || c != word.charAt(idx)) {
					return false;
				}
				num = 0;
				idx++;
			}
		}
		return idx+num == word.length();
	}
}