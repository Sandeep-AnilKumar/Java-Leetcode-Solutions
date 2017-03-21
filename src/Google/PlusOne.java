package Google;

public class PlusOne {
	public static void main(String[] args) {
		int[] digits = {9};
		int[] result = plusOne(digits);
		for(int i : result) {
			System.out.println(i + " ");
		}
	}

	//Is a little complicated. O(2n)
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

	//A much better approach.
	public static int[] plusOneBetter(int[] digits) {

		int n = digits.length;
		for(int i=n-1; i>=0; i--) {
			if(digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		int[] newNumber = new int [n+1];
		newNumber[0] = 1;

		return newNumber;
	}
}
