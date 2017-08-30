package Strings;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println("The excel sheet column number is := " + new ExcelSheetColumnNumber().titleToNumber("ACZ"));
	}

	public int titleToNumber(String s) {
		if(s == null || s.length() == 0) return 0;

		int base = 26;
		int length = s.length();
		int number = 0;

		for(int i = 0; i < length; ++i) {
			number += Math.pow(base, (length - 1 - i)) * (s.charAt(i) - 'A' + 1);
		}
		return number;
	}
}
