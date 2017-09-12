package Arrays;

public class Remove9 {

	public static void main(String[] args) {
		Remove9 Get = new Remove9();
		int n = 82;
		System.out.println("The integer at n = " + n + " is := " + Get.newIntegerAnotherBest(n));
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

	public int newIntegerBest(int n) {
		int[] dp = new int[10];
		if(n<=8) return n;
		dp[1]=9;
		for(int i=2;i<=9;i++){
			dp[i]=9*dp[i-1];
		}

		int sum=0;
		for(int i=9;i>=1;i--){
			int count = n/dp[i];
			sum=sum*10+count;
			n-=count*dp[i];

		}
		sum=sum*10+n;
		return sum;
	}

	public int newIntegerAnotherBest(int n) {
		long[] helper = new long[10];
		long count = 1;
		long m = 10;
		helper[0] = 1;
		for (int i = 1; i < 10; i++) {
			helper[i] = m - count;
			count = m + count * 9;
			m *= 10;
		}

		count = 0;
		for (int i = 9; i >= 1; i--) {
			if (n >= helper[i]) {
				int temp = n / (int) helper[i];
				n = n - temp * (int) helper[i];
				count = temp + count;
			}
			count = count * 10;
		}
		count = count + n;
		return (int) count;
	}
}
