package Strings;

/**
 * @author sandeepa
 */

public class LicenseKeyFormatting {

	public static void main(String[] args) {
		LicenseKeyFormatting formatting = new LicenseKeyFormatting();
		String S = "-----5F3Z-2e-9-w-223-";
		int K = 4;
		System.out.println("The formatted license key is := " + formatting.licenseKeyFormatting(S, K));
	}

	public String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder();
		int length = S.length();
		char c;

		for(int index = 0; index < length; ++index) {
			c = S.charAt(index);
			if(c != '-') {
				sb.append(parse(c));
			}
		}

		length = sb.length();
		for(int index = length - 1 - K; index >= 0; index = index - K) {
			sb.insert(index + 1, "-");
		}

		return sb.toString();
	}

	public char parse(char c) {
		int val = (int) c;

		if(val >= 97 && val <= 122) {
			c = (char) (val - 32);
		}

		return c;
	}
}
