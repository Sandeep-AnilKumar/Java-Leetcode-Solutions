package Arrays;

public class CountingBits {
	public static void main (String[] args) {
		int number = 9;
		int result[] = countBits(number);

		int i = 0;
		for(int num : result) {
			System.out.println(i + "->" + num);
		}
	}

	public static int[] countBits(int num) {
		if(num < 0) {
			return new int[0];
		}

		int power = 1;
		int result[] = new int[num + 1];

		for(int digit = 1; digit <= num; digit++) {
			if(power*2 == digit) {
				power *= 2;
			}

			result[digit] = result[digit - power] + 1;
		}

		return result;
	}
}