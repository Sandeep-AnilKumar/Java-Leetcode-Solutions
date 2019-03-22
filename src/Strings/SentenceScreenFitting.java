package Strings;

public class SentenceScreenFitting {
	public static void main(String[] args) {
		SentenceScreenFitting sentenceScreenFitting = new SentenceScreenFitting();
		int rows = 3;
		int cols = 6;
		String[] sentence = {"a", "bcd", "e"};
		System.out.println("The number of sentences that can be fit are := " + sentenceScreenFitting.wordsTyping(sentence,
				rows, cols));
	}

	public int wordsTyping(String[] sentence, int rows, int cols) {
		String s = String.join(" ", sentence) + " ";
		int start = 0, l = s.length();
		for (int i = 0; i < rows; i++) {
			start += cols;
			if (s.charAt(start % l) == ' ') {
				start++;
			} else {
				while (start > 0 && s.charAt((start - 1) % l) != ' ') {
					start--;
				}
			}
		}

		return start / s.length();
	}
}
