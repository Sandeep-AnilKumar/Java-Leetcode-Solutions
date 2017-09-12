package Arrays;

public class Remove9 {

	public static void main(String[] args) {
		Remove9 Get = new Remove9();
		int n = 899999;
		System.out.println("The integer at n = " + n + " is := " + Get.newIntegerBetter(n));
	}

	//Will be TLE for very large values.
	public int newInteger(int n) {
		if(n <= 0) return 0;

		int cur = 1;
		for(int i = 1; i < n; ++i) {
			if(!valid(cur)) {
				--i;
			}
			cur++;
		}
		while(!valid(cur)) {
			cur++;
		}
		return cur;
	}

	public boolean valid(int num) {
		String n = String.valueOf(num);
		if(n.contains("9")) return false;
		return true;
	}

	public int newIntegerBetter(int n) {
		int ans = 0;
		int base = 1;

		while (n > 0){
			ans += n % 9 * base;
			n /= 9;
			base *= 10;
		}
		return ans;
	}
}
