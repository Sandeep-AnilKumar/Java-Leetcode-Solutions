package String;

public class MinimumWindow_Possible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String findMinimumWindow(String s, String t) {
		if(s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
			return "";
		}

		int sLength = s.length();
		int tLength = t.length();

		int satisfy[] = new int[256];

		for(int i = 0; i < tLength; i++) {
			satisfy[t.charAt(i)]++;
		}

		int count = 0;
		int minLength = Integer.MAX_VALUE;
		int minIndex = 0;

		for(int right = 0, j = 0; j < sLength; j++) {
			satisfy[s.charAt(j)]--;

			if(satisfy[s.charAt(j)] >= 0) {
				count++;
			}

			while(count == tLength) {
				if(j - right + 1 < minLength) {
					minLength = j - right + 1;
					minIndex = right;
				}

				satisfy[s.charAt(right)]++;
				if(satisfy[s.charAt(right)] > 0) {
					count--;
				}
				right++;
			}	
		}

		if(minLength == Integer.MAX_VALUE) {
			return "";
		}
		return s.substring(minIndex, minLength);
	}

}
