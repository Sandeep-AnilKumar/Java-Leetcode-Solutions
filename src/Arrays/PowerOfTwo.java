package Arrays;

public class PowerOfTwo {

	public static void main(String[] args) {
		int num = 6;
		System.out.println(isPowerOfTwo(num));
	}

	public static boolean isPowerOfTwo(int num) {
		if(num <= 0) {
			return false;
		}
		return ((num & (num-1)) == 0); 
	}
}
