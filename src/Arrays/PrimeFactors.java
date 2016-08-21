package Arrays;

import java.util.HashSet;
import java.util.Set;

public class PrimeFactors {

	public static void main(String[] args) {
		int number = 24;
		System.out.printf("The prime factors of %d : %s %n", number, factorsOf(number));

	}
	
	public static Set<Integer> factorsOf(int number)
	{
		Set<Integer> primeFactors = new HashSet<Integer>();
		int temp = number;
		
		for(int i = 2; i <= temp; i++)
		{
			if(temp % i == 0){
				primeFactors.add(i);
				temp /= i;
				i--;
			}
		}
		return primeFactors;
	}

}
