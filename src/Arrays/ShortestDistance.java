package Arrays;

public class ShortestDistance {

	public static void main(String[] args) {
		String[] words = {"a", "b"};
		System.out.println(shortestDistance(words, "a", "b"));
	}

	public static int shortestDistance(String[] words, String word1, String word2) {
		int i1 = -1, i2 = -1;
		int min = Integer.MAX_VALUE;
		int length = words.length;
		for(int i = 0; i < length; ++i) {
			if(words[i].equals(word1)) {
				i1 = i;
			} else if(words[i].equals(word2)) {
				i2 = i;
			} else {
				continue;
			}

			if(i1 != -1 && i2 != -1) {
				min = Math.min(min, Math.abs(i1 - i2));
			}
		}
		return min;
	}
}