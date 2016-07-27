package Arrays;

public class IsPerfectSquare {

	public static void main(String[] args) {
		int num = 9;
		System.out.println("Is " + num + " a perfect square: - " + isPerfectSquare1(num));
	}

	public static boolean isPerfectSquare(int num) {
		long r = num;
		while (r*r > num)
			r = (r + num/r) / 2;
		return r*r == num;
	}

	public static boolean isPerfectSquare1(int num) {
		if(num < 1) return false;
		long low = 1;
		long high = num;
		long mid = 0;
		long temp = 0;

		while(low <= high) {
			mid = low + (high - low) / 2;
			temp = mid * mid;

			if(temp == num) {
				return true;
			}
			else if(temp < num) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return false;
	}

}
