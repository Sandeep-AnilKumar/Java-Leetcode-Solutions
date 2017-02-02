package BitManipulation;

public class HammingDistance {

    public static void main(String[] args) {
        int x = -1;
        int y = 4;
        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        String strX = "";
        String strY = "";
        if(x >= 0) {
            strX = toBinary(x);
        }
        else {
            strX = Integer.toBinaryString(x);
        }
        if(y >= 0) {
            strY = toBinary(y);
        }
        else {
            strY = Integer.toBinaryString(y);
        }

        int count = 0;
        for(int i = 0; i < 32; ++i) {
            if(strX.charAt(i) != strY.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static String toBinary(int x) {
        StringBuffer sb = new StringBuffer();
        int count = 0;

        int temp = x;
        while(temp > 0) {
            count++;
            sb.append(temp % 2);
            temp >>= 1;
        }

        count = 32 - count;
        while(count-- > 0) {
            sb.append('0');
        }

        return sb.reverse().toString();
    }

    //A better solution.

    public static int hammingDistanceBetter(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }
}
