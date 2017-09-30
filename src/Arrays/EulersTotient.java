package Arrays;

/**
 * @author sandeepa
 */

public class EulersTotient {

	public static void main(String[] args) {
		int n = 18;
		EulersTotient func = new EulersTotient();
		System.out.println("The number of positive integers less than or equal to " + n + " that are relatively prime are := " + func.fi(n));
		System.out.println("The number of divisors of " + n + " are := " + func.numDivisors(n));
	}

	public int fi(int n) {          
		int result = n;          
		for(int i=2;i*i <= n;i++) {            
			if (n % i == 0) result -= result / i;            
			while (n % i == 0) n /= i;          
		}          
		if (n > 1) result -= result / n;          
		return result;        
	}

	public int numDivisors(int n) {
		if(n == 1) return 1;
		int count = 1;
		int cur = 0;
		for(int i = 2; i <= n; ++i) {
			if(n % i == 0) {
				cur = 0;
				while(n % i == 0) {
					cur++;
					n /= i;
				}
				count *= (cur + 1);
			}
		}
		return count;
	}
}
