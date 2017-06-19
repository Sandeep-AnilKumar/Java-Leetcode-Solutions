package Strings;

import java.util.NoSuchElementException;

public class CompressesStringIterator {

	char curChar;
	char[] array;
	int curCount;
	int length;
	int curIndex;
	int nextIndex;

	public CompressesStringIterator(String s) {
		array = s.toCharArray();
		curCount = 0;
		curIndex = 0;
		length = s.length();
	}

	public boolean hasNext() {
		if(curIndex + nextIndex < length || curCount > 0) {
			return true;
		}
		return false;
	}

	public char next() {
		if(hasNext()) {
			if(curCount > 0) {
				curCount--;
				return curChar;
			}

			int num = 0;
			curIndex += nextIndex;
			int i = curIndex;
			nextIndex = 1;
			curChar = array[i++];
			while(i < length && !isAlpha(array[i])) {
				num = num * 10 + (array[i++] - '0');
				nextIndex++;
			}
			curCount = num;
			curCount--;
			if(curCount >= 0) {	
				return curChar;
			}
			return ' ';
		} else {
			throw new NoSuchElementException();
		}
	}

	public boolean isAlpha(char c) {
		int val = (int) c;
		if((val >= 65 && val <= 90) || (val >= 97 && val <= 122)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		CompressesStringIterator i = new CompressesStringIterator("G1o10g1l1e1r0");
		StringBuffer s = new StringBuffer();

		while(i.hasNext()) {
			s.append(i.next());
		}

		System.out.println(s.toString());
	}
}