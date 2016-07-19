package Arrays;

import java.util.ArrayList;
import java.util.List;

public class coprimes {

	public static void main(String[] args) {
		int n = 5;
		List<Integer> result = coprimes(n);

		int size = result.size();
		System.out.printf("The coprimes of %d are %n", n);

		for(int i = 0; i < size; i++) {
			System.out.println(result.get(i));
		} 

	}

	public static List<Integer> coprimes(int n) {

		if(n <= 1) {
			return null;
		}

		int result[] = new int[]{};

		boolean notPrime[] = new boolean[n];
		List<Integer> primes = new ArrayList<Integer>();

		for(int i = 2; i < n; i++) {

			if(!notPrime[i]) {
				primes.add(i);

				for(int k = 2*i; k < n; k += i) {
					notPrime[k] = true;
				}
			}
		}

		boolean coprimes[] = new boolean[n];
		int size = primes.size();

		List<Integer> resultPrimes = new ArrayList<Integer>();
		resultPrimes.add(1);

		for(int i = 0; i < size; i++) {

			int j = primes.get(i);

			if(gcd (j , n) != 1 && !coprimes[i]) {

				coprimes[j] = true;

				for(int k = 2*j; k < n ; k += j) {
					coprimes[k] = true;
				}
			}
		}

		for(int i = 2; i < n; i++) {
			if(!coprimes[i]) {
				resultPrimes.add(i);
			}
		}

		return resultPrimes;

	}

	public static int gcd(int a , int b) {

		if(a == 0)
			return b;

		return gcd(b%a, a);
	}

	public static String calue ( ) {
		return "NO";
	}


}
