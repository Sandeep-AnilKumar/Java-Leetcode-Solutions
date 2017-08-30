package Strings;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println("The excel sheet column title is := " + new ExcelSheetColumnTitle().convertToTitle(780) );
	}

	public String convertToTitle(int n) {
		StringBuffer sb = new StringBuffer();
		int base = 26;
		int rem = 0;

		while(n >= base) {
			rem = n % base;
			if(rem == 0) {
				sb.append('Z');
				n /= base;
				n -= 1;
			} else {
				sb.append((char) (64 + rem));
				n /= base;
			}
		}
		if(n != 0) sb.append((char) (64 + n));

		return sb.reverse().toString();
	}
}
