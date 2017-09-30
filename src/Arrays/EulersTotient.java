package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeepa
 */

public class EulersTotient {

	public static void main(String[] args) {
		int n = 50;
		int numerator = 270;
		int denominator = 393;
		EulersTotient func = new EulersTotient();
		System.out.println("The number of positive integers less than or equal to " + n + " that are relatively prime are := " + func.fi(n));
		System.out.println("The number of divisors of " + n + " are := " + func.numDivisors(n));
		System.out.println("The sum of divisors of " + n + " are := " + func.sumDivisors(n));
		System.out.println("All prime factors of " + n + " are := " + func.primeFactors(n));
		System.out.println("The simplified fraction of " + numerator + "/" + denominator + " are := " + func.simplifyFraction(numerator, denominator));
		System.out.println("The number of primes from 1 to " + n + " are := "+ func.primes(n));
		System.out.println("Is " + n + " prime := "+ func.isPrime(n));
	}

	public int fi(int n) {          
		int result = n;          
		for(int i = 2; i * i <= n; i++) {            
			if (n % i == 0) result -= result / i;            
			while (n % i == 0) n /= i;          
		}          
		if (n > 1) result -= result / n;          
		return result;        
	}

	public int numDivisors(int n) {
		int count = 0;
		for(int i = 1; i * i <= n; ++i) {
			if(n % i == 0) {
				if(n / i != i) {
					count++;
				}
				count++;
			}
		}
		return count;
	}

	public int sumDivisors(int n) {
		int sum = 0;
		for(int i = 1; i * i <= n; ++i) {
			if(n % i == 0) {
				if(n / i != i) {
					sum += n / i;
				}
				sum += i;
			}
		}
		return sum;
	}

	public List<Integer> primeFactors(int n) {
		List<Integer> factors = new ArrayList<>();

		for(int i = 2; i * i <= n; ++i) {
			if(n % i == 0) {
				while(n % i == 0) {
					factors.add(i);
					n /= i;
				}
			}
		}

		if(n != 1) {
			factors.add(n);
		}
		return factors;
	}

	public List<Integer> simplifyFraction(int numerator, int denominator) {
		int min = Math.min(numerator, denominator);
		List<Integer> fraction = new ArrayList<>();
		for(int i = 2; i <= min; ++i) {
			if(numerator % i == 0 && denominator % i == 0) {
				while(numerator % i == 0 && denominator % i == 0) {
					numerator /= i;
					denominator /= i;
				}
				min = Math.min(numerator, denominator);
			}
		}
		fraction.add(numerator);
		fraction.add(denominator);
		return fraction;
	}

	public int primes(int n) {
		if(n == 1) return 0;
		boolean[] notPrimes = new boolean[n + 1];
		int count = n - 1;
		int m = (int) Math.sqrt(n);

		for(int i = 2; i <= m; ++i) {
			if(!notPrimes[i]) {
				for(long k = ((long)i * i); k <= n; k += i) {
					if(!notPrimes[(int) k]) {
						count--;
						notPrimes[(int) k] = true;
					}
				}
			}
		}
		return count;
	}

	public boolean isPrime (int n) {
		if (n <= 1) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		int m = (int) Math.sqrt(n);

		for (int i = 3; i <= m; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
}
