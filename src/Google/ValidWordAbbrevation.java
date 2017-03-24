package Google;

public class ValidWordAbbrevation {

	public static void main(String[] args) {
		String word = "internationalization";
		String abbr = "i12i4o3";
		System.out.println("Is valid word abbrevation? := " + validWordAbbreviation(word, abbr));
	}

	//might not work for the last abbreviation character if it is a number.
	public static boolean validWordAbbreviation(String word, String abbr) {
		int wLength = word.length();
		int aLength = abbr.length();
		int temp = 0;
		StringBuilder sb = new StringBuilder();
		char a;

		for(int i = 0, j = 0; i < wLength && j < aLength; ++j) {
			a = abbr.charAt(j);
			temp = (int) a;
			if(temp >= 97 && temp <= 122) {
				i = sb.toString() != null && sb.toString().length() != 0 ? i + Integer.parseInt(sb.toString()): i;
				if(i >= wLength || a != word.charAt(i)) {
					return false;
				}
				sb = new StringBuilder();
				++i;
			} else {
				sb.append(a);
			}
		}
		return true;
	}
}