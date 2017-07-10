package Arrays;

public class LicenseKeyFormatting {

	public static void main(String[] args) {
		LicenseKeyFormatting lk = new LicenseKeyFormatting();
		System.out.println(lk.licenseKeyFormatting("a-aa-a", 1));
		System.out.println(lk.licenseKeyFormatting("24-A0R-74K-w6z", 4));
	}

	public String licenseKeyFormatting(String S, int K) {
		S = S.replaceAll("-", "");
		int length = S.length();
		char[] array = S.toCharArray();
		int cur = 0;
		int ascii = 0;
		String formatted = "";

		for(int i = length - 1; i >= 0; --i) {
			cur = 0;
			while(i >= 0 && cur++ < K) {
				if(!Character.isDigit(array[i])) {
					ascii = (int) array[i];
					if(ascii >= 97 && ascii <= 122) {
						ascii = ascii - 32;
						array[i] = (char) ascii;
					}
				}
				formatted = array[i--] + "" + formatted;
			}
			if(i >= 0) {
				formatted = "-" + formatted;
			}
			i++;
		}
		return formatted;
	}
}