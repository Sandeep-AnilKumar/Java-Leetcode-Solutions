package Arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CanIWin {

    public static void main(String[] args) {
        int maxChoosableInteger = 10;
        int desiredTotal = 20;
        System.out.println("Can player 1 win? := " + canIWinWorkingSolution(maxChoosableInteger, desiredTotal));
    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger < 0 || desiredTotal < 0 || ((maxChoosableInteger * (maxChoosableInteger + 1)) >>> 1) < desiredTotal) {
            return false;
        }

        Set<Integer> numbers = new TreeSet<>();
        for(int i = 1; i <= maxChoosableInteger; ++i) {
            numbers.add(i);
        }
        return canIWin(numbers, 0, desiredTotal, 1);
    }

    public static boolean canIWin(Set<Integer> numbers, int sum, int desiredTotal, int player) {
        if(sum == desiredTotal && player == 1) {
            return true;
        }

        if(player == 2 && numbers.contains(desiredTotal - sum) || sum >= desiredTotal) {
            return false;
        }

        if(player == 1 && numbers.contains(desiredTotal - sum)) {
            return true;
        }

        Set<Integer> current = new HashSet<>();
        boolean result = false;
        for(int i : numbers) {
            current = new HashSet<>(numbers);
            current.remove(i);
            if(player == 1) {
                result = canIWin(current, sum + i, desiredTotal, 2);
            } else {
                result = canIWin(current, sum + i, desiredTotal, 1);
            }
            if(result) {
                return result;
            }
        }
        return result;
    }

    public static boolean canIWinWorkingSolution(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        int to = (1 << maxChoosableInteger);
        boolean[] a = new boolean[(1 << maxChoosableInteger) + 13];
        for (int i = to - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < maxChoosableInteger; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += j + 1;
                }
            }
            if (sum >= desiredTotal) {
                a[i] = false;
            } else {
                for (int j = 0; j < maxChoosableInteger; j++) {
                    if ((i & (1 << j)) == 0) {
                        if (!a[i + (1 << j)]) {
                            a[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return a[0];
    }
}
