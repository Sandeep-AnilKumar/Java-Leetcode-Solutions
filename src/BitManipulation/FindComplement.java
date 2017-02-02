package BitManipulation;

public class FindComplement {

    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }


    public static int findComplement(int num) {
        StringBuffer sb = new StringBuffer();

        while(num > 0) {
            if(num % 2 == 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            num >>= 1;
        }
        return Integer.parseInt(sb.reverse().toString(), 2);
    }

    //A much better solution.

    int findComplementBetter(int num) {
        int mask = num;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        return num ^ mask;
    }
}
