package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BullsAndCows {

	public static void main(String[] args) {
		String secret = "1807";
		String guess = "7810";
		System.out.println(getBullsAndCows(secret, guess));
	}

	public static String getBullsAndCows(String secret, String guess) {
		int length = secret.length();
		int tempSecret = 0;
		int tempGuess = 0;
		int bulls = 0;
		int cows = 0;
		//char secretArray[] = secret.toCharArray();
		//Set<Integer> secretSet = new HashSet<Integer>();
		//int arrayLength = secretArray.length;
		//boolean isPresent[] = new boolean[10];
		//for(int i = 0; i < arrayLength; i++) {
		//secretSet.add(secret.charAt(i) - '0');
		//}
		Object obj;

		List<Integer> arrayList = new LinkedList<Integer>();
		for(int i = 0; i < length; i++) {
			arrayList.add(secret.charAt(i) - '0');
		}

		for(int i = 0; i < length; i++) {
			tempSecret = secret.charAt(i) - '0';
			tempGuess = guess.charAt(i) - '0';

			if(tempSecret == tempGuess) {
				obj = tempGuess;
				arrayList.remove(tempGuess);
				bulls++;

			}
		}

		for(int i = 0; i < length; i++) {
			tempSecret = secret.charAt(i) - '0';
			tempGuess = guess.charAt(i) - '0';
			if(arrayList.contains(tempGuess)) {
				obj = tempGuess;
				arrayList.remove(obj);
				cows++;
			}
		}
		return (bulls+"A"+cows+"B");
	}
}
