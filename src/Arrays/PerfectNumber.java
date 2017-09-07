package Arrays;

public class PerfectNumber {

	public static void main(String[] args) {
		PerfectNumber number = new PerfectNumber();
		int num = 28;
		System.out.println("Is " + num + " a perfect number? := " + number.checkPerfectNumber(num));
	}

	public boolean checkPerfectNumber(int num) {
		if (num <= 0) {
			return false;
		}
		int sum = 0;
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				sum += i;
				if (i * i != num) {
					sum += num / i;
				}

			}
		}
		return sum - num == num;
	}
}
