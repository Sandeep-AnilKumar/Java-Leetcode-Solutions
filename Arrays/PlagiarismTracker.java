package Arrays;

import java.util.HashMap;
import java.util.Map;

public class PlagiarismTracker {

	public static void main(String[] args) {
		String code1[] = {"for(some_condition && a < b) {", "a + b;}"};
		String code2[] = {"for(some_condition && g < summand_b) {", "g + summand_b;}"};

		System.out.println(checkForPlaigarism(code1, code2));
	}

	public static boolean checkForPlaigarism(String[] code1, String[] code2) {

		if(code1 == null || code2 == null || code1.length == 0 || code2.length == 0)
			return false;

		int lenght1 = code1.length;
		int length2 = code2.length;

		String temp1, temp2;
		StringBuffer s1, s2;
		char c1, c2;
		Map<String, String> match = new HashMap<String, String>();


		for(int i = 0, j = 0; i < lenght1 && j < length2; i++, j++) {
			temp1 = code1[i];
			temp2 = code2[j];

			int tempLength1 = temp1.length();
			int tempLenght2 = temp2.length();

			for(int k = 0, l = 0; k < tempLength1 && l < tempLenght2; k++, l++) {
				c1 = temp1.charAt(k);
				c2 = temp2.charAt(l);

				if(Character.isJavaIdentifierPart(c1) && Character.isJavaIdentifierPart(c2) && c1 == c2) {
					continue;
				}
				else if(Character.isJavaIdentifierPart(c1) && Character.isJavaIdentifierPart(c2) && c1 != c2) {
					s1 = new StringBuffer();
					s2 = new StringBuffer();
					while((c1 = temp1.charAt(k)) != (c2 = temp2.charAt(l))) {
						if(Character.isJavaIdentifierPart(c1)) {
							k++;
							s1.append(c1);
						}

						if(Character.isJavaIdentifierPart(c2)){
							l++;
							s2.append(c2);
						}
					}

						if(match.containsKey(s1.toString())){
							if(match.get(s1.toString()).equals(s2.toString())) {
								continue;
							}
							else {
								return false;
							}
						}
						else {
							match.put(s1.toString(), s2.toString());
						}
					}
				else {
					continue;
				}
			}
		}
		return true;
	}
}
