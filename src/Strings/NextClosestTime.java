package Strings;

import java.util.Arrays;

/**
 * @author sandeepa
 */

public class NextClosestTime {

	public static void main(String[] args) {
		NextClosestTime next = new NextClosestTime();
		String time = "23:59";
		System.out.println("The next closest time to '" + time + "' using the same digits is := " + next.nextClosestTime(time));

		time = "13:55";
		System.out.println("The next closest time to '" + time + "' using the same digits is := " + next.nextClosestTime(time));

		time = "19:34";
		System.out.println("The next closest time to '" + time + "' using the same digits is := " + next.nextClosestTime(time));
	}

	public String nextClosestTime(String time) {
		int[] digits = getDigits(time);
		int length = digits.length;
		int[] sorted = Arrays.copyOf(digits, length);
		Arrays.sort(sorted);
		int next = 0;

		for(int i = length - 1; i >= 0; --i) {
			next = nextHighest(sorted, digits[i]);

			if(next > digits[i]) {
				digits[i] = next;
				if(isValid(digits)) {
					break;
				} else {
					digits[i] = sorted[0];
				}
			} else {
				digits[i] = sorted[0];
			}
		}

		return String.format("%02d:%02d", digits[0] * 10 + digits[1], digits[2] * 10 + digits[3]);
	}

	public int[] getDigits(String time) {
		String[] parts = time.split(":");
		int[] digits = new int[4];
		int index = 0;
		int cur = 0;

		for(String s : parts) {
			cur = Integer.parseInt(s);
			digits[index++] = cur / 10;
			digits[index++] = cur % 10;
		}

		return digits;
	}

	public int nextHighest(int[] sorted, int cur) {
		for(int num : sorted) {
			if(num > cur) {
				return num;
			}
		}

		return cur;
	}

	public boolean isValid(int[] digits) {
		if(digits[0] * 10 + digits[1] < 24 && digits[2] * 10 + digits[3] < 60) {
			return true;
		}

		return false;
	}
}
