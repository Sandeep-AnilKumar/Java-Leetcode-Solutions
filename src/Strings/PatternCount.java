package Strings;

import java.util.Scanner;

/**
 * @author sandeepa
 */

public class PatternCount {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String text = in.next();
		String pattern = in.next();

		char[] p = pattern.toCharArray();
		char[] t = text.toCharArray();

		int[] table = getTable(p);
		int count = KMP(t, p, table);
		System.out.println(count);
	}

	public static int[] getTable(char[] p) {
		if(p == null || p.length == 0) return new int[0];

		int length = p.length;
		int[] table = new int[length];

		int index = 0;
		for(int i = 1; i < length;) {
			if(p[i] == p[index]) {
				table[i++] = ++index;
			} else if(index != 0){
				index = table[index - 1];
			} else {
				table[i++] = 0;
			}
		}
		return table;
	}

	public static int KMP(char[] t, char[] p, int[] table) {
		if(p == null || p.length == 0 || t == null || t.length == 0) return 0;

		int i = 0;
		int j = 0;

		int length = t.length;
		int count = 0;
		while(i < length) {
			if(t[i] == p[j]) {
				i++;
				j++;
				if(j == p.length) {
					count++;
					j = table[j - 1];
				}
			} else if(j != 0) {
				j = table[j - 1];
			} else {
				i++;
			}
		}
		return count;
	}
}
