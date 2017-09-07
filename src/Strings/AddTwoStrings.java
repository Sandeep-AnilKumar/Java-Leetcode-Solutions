package Strings;

public class AddTwoStrings {

	public static void main(String[] args) {
		String num1 = "99";
		String num2 = "99";
		System.out.println("The sum of " + num1 + " and " + num2 + " is := " + new AddTwoStrings().addStrings(num1, num2));
	}

	public String addStrings(String num1, String num2) {
		if(num1 == null || num1.length() == 0) return num2;
		if(num2 == null || num2.length() == 0) return num1;

		StringBuffer sb = new StringBuffer();
		int carry = 0;
		int sum = 0;

		int num1Length = num1.length();
		int num2Length = num2.length();

		while(num1Length > 0 || num2Length > 0) {
			sum = carry;
			if(num1Length-- > 0) {
				sum += num1.charAt(num1Length) - '0';
			}

			if(num2Length-- > 0) {
				sum += num2.charAt(num2Length) - '0';
			}

			carry = sum / 10;
			sum %= 10;
			sb.append(sum);
		}

		if(carry > 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}
}
