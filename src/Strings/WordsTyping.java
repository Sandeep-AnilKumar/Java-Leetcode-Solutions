package Strings;

/**
 * @author sandeepa
 */

public class WordsTyping {

	public static void main(String[] args) {
		WordsTyping typing = new WordsTyping();
		int rows = 4;
		int cols = 5;

		String[] sentence = {"I", "had", "apple", "pie"};
		System.out.println("The number of times the given sentence will appear on the screen is := " + typing.wordsTypingBetter(sentence, rows, cols));
	}

	//Time limit exceeded
	public int wordsTyping(String[] sentence, int rows, int cols) {
		int length = sentence.length;
		int count = 0;
		int index = 0;

		for(int r = 1; r <= rows; ++r) {
			for(int c = 1; c <= cols; ++c) {
				if(cols - c + 1 >= sentence[index].length()) {
					c += sentence[index++].length();
					if(index == length) {
						count++;
						index = 0;
					}
				} else {
					break;
				}
			}
		}

		return count;
	}

	//Better solution
	public int wordsTypingBetter(String[] sentence, int rows, int cols) {
		String s = String.join(" ", sentence) + " ";
		int start = 0, l = s.length();
		for (int i = 0; i < rows; i++) {
			start += cols;
			if (s.charAt(start % l) == ' ') {
				start++;
			} else {
				while (start > 0 && s.charAt((start-1) % l) != ' ') {
					start--;
				}
			}
		}

		return start / s.length();
	}
}
