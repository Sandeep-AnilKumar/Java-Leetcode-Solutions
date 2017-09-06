package Strings;

public class CompressedStringIterator {
	private char[] chars;
	private int length;
	private int index;
	private int curCount;
	private char curChar;

	public CompressedStringIterator(String compressedString) {
		chars = compressedString.toCharArray();
		index = 0;
		length = chars.length;
		curCount = 0;
	}

	public char next() {
		if(curCount == 0) {
			int count = 0;
			if(index < length) {
				curChar = chars[index++];

				while(index < length && isDigit(chars[index])) {
					count = count * 10 + (chars[index++] - '0');
				}
				curCount = count;
				if(curCount > 0) {
					curCount--;
					return curChar;
				} else {
					return ' ';
				}

			} else {
				return ' ';
			}
		} else {
			curCount--;
			return curChar;
		}
	}

	public boolean hasNext() {
		return index <= length - 1 || curCount > 0;
	}

	public boolean isDigit(char c) {
		return c - '0' >= 0 && c - '0' <= 9;
	}

	public static void main(String[] args) {
		CompressedStringIterator iterator = new CompressedStringIterator("a10");
		System.out.println(iterator.next()); // return 'L'
		System.out.println(iterator.next()); // return 'e'
		System.out.println(iterator.next()); // return 'e'
		System.out.println(iterator.next()); // return 't'
		System.out.println(iterator.next()); // return 'C'
		System.out.println(iterator.next()); // return 'o'
		System.out.println(iterator.next()); // return 'd'
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 'e'
		System.out.println(iterator.hasNext()); // return false
		System.out.println(iterator.next()); // return ' '
	}
}
