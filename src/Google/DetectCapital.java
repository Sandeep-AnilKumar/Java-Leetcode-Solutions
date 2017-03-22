package Google;

public class DetectCapital {

	public static void main(String[] args) {
		DetectCapital d = new DetectCapital();

		String word = "USA";
		System.out.println(d.detectCapitalUse(word));

		word = "Flag";
		System.out.println(d.detectCapitalUse(word));

		word = "leetcode";
		System.out.println(d.detectCapitalUse(word));

		word = "FlaG";
		System.out.println(d.detectCapitalUse(word));
	}

	public boolean detectCapitalUse(String word) {
		int length = word.length();
		int asc = 0;
		int count = 0;
		boolean first = false;

		for(int i = 0; i < length; ++i) {
			asc = (int) word.charAt(i);
			if(asc >= 65 && asc <= 90) {
				first = i == 0 ? true : false; 
				count += 1;
			}
		}

		if(count == 0 || length - count == 0 || first) {
			return true;
		}
		return false;
	}
}
