package Google;

public class PlusOne {
	public static void main(String[] args) {
		int[] digits = {9};
		int[] result = plusOne(digits);
		for(int i : result) {
			System.out.println(i + " ");
		}
	}
	public static int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return new int[0];
		}

		int sum = 0;
		int carry = 0;
		int length = digits.length;
		for(int i = length - 1; i >= 0; --i) {
			sum = i == length - 1 ? carry + digits[i] + 1 : carry + digits[i];
			carry = sum / 10;
			digits[i] = sum % 10;
		}
		if(carry > 0) {
			int[] result = new int[length + 1];
			for(int i = length - 1; i >= 0; --i) {
				result[i + 1] = digits[i];
			}
			result[0] = carry;
			return result;
		}
		return digits;
	}
}
