package Arrays;

/*Given a non-negative integer n, count all numbers with unique digits, x, where 0 = x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 = x < 100, excluding [11,22,33,44,55,66,77,88,99])
This problem can also be solved using a dynamic programming approach and some knowledge of combinatorics.
Let f(k) = count of numbers with unique digits with length equals k.
f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0].*/

public class NumbersWithUniqueDigits {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("The number of unique digits in 10 power " + n + " is :" + countNumbersWithUniqueDigits(n));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if(n == 0 || n > 10) {
            return 1;
        }
        if(n == 1) {
            return 10;
        }

        int total = 10;
        int base = 9;
        int i = 0;
        while(n > 1) {
            base = base * (9 - i++);
            total += base;
            n--;
        }
        return total;
    }
}
