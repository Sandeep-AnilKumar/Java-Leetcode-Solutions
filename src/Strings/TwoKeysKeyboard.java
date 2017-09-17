package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoKeysKeyboard {

	public static void main(String[] args) {
		TwoKeysKeyboard keyboard = new TwoKeysKeyboard();
		int n = 123;
		System.out.println("The number of steps required to print n := " + n + " is := " + keyboard.minStepsBetter(n));
	}

	//The logic is right, but the number of primes to have is unknown.
	public int minSteps(int n) {
		if(n == 1) return 0;
		Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));

		if(primes.contains(n)) return n;

		int steps = 0;
		while(n > 1) {
			for(int p: primes) {
				if(n % p == 0) {
					steps += p;
					n /= p;
					break;
				} 
			}
		}
		return steps;
	}

	public int minStepsBetter(int n) {
		int res = 0;
		for(int i = 2; i <= n; ++i){
			while(n % i == 0){
				res += i;
				n /= i;
			}
		}
		return res;
	}
}
