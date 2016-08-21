package Arrays;

public class IsUglyNumber {

	public static void main(String[] args) {
		int num = 8;
		System.out.println(isUgly(num));
	}

	public static boolean isUgly(int num) {
		if(num <= 0) {
			return false;
		}
		if(num <= 2) {
			return true;
		}

		int temp = num;
		while(temp % 2 == 0) {
			temp >>>= 1;
		}
		while(temp % 3 == 0) {
			temp /= 3;
		}
		while(temp % 5 == 0) {
			temp /= 5;
		}
		return (temp == 1);
	}
}