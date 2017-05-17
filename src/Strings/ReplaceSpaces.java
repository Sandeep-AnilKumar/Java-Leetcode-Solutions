package Strings;

public class ReplaceSpaces {

	public static void main(String[] args) {
		char[] c = {'M','r',' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};
		System.out.println("The replaced string is := ");
		c = replaceSpaces(c);
		for(char ch: c) {
			System.out.print(ch);
		}
	}

	public static char[] replaceSpaces(char[] c) {
		if(c == null || c.length == 0) {
			return c;
		}

		int length = c.length;
		int index = length - 1;
		while(c[index] == ' ') {
			--index;
		}

		for(int i = index, j = length - 1; i >= 0 && j >= 0; --i, --j) {
			if(c[i] != ' ') {
				c[j] = c[i];
			} else {
				c[j--] = '0';
				c[j--] = '2';
				c[j] = '%';
			}
		}
		return c;
	}
}
