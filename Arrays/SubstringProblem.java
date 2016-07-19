package Arrays;

public class SubstringProblem {

	public static void main(String[] args) {
		String s = "    ababababababab";
		String t = "  ab  ";

		int result = totalRounds(s,t);
		System.out.println(result);
	}

	public static int totalRounds(String s, String t) {

		s = s.trim();
		t = t.trim();

		if(s == null || s.length() == 0 || t == null || t.length() == 0) {
			return 0;
		}

		int rounds = 0;
		int index = 0;

		int sLength = s.length();
		int tLength = t.length();


		if(s.contains(t)) {

			rounds++;

			index = s.indexOf(t);
			StringBuilder result = new StringBuilder();

			for(int i = 0; i < sLength; i++) {
				if(index != 0 && i >= index && i <= tLength) {
					continue;
				}

				if(index == 0) {
					if(i >= index && i < tLength) {
						continue;
					}
				}

				result.append(s.charAt(i));
			}

			if(result != null && result.length() != 0) {
				s = result.toString();
				rounds += totalRounds(s, t);
			}

		}

		return rounds; 

	}

}
