package BitManipulation;

public class BitwiseAndNumbers {

    public static void main(String[] args) {
        int m = 3; //0b101
        int n = 7; //0b111
        System.out.println(bitwiseAndOfNumberRanges(m, n));
        //The first difference is after 0b1, so we count till where the digits are common, and then left shift those many
        //places to give the common answer.
    }

    public static int bitwiseAndOfNumberRanges(int m, int n) {
        int i = 0;
        for (; m != n; ++i) {
            m >>>= 1;
            n >>>= 1;
        }
        return n << i;
    }
}

//Brian Kerninghan Algorithm
/*
 * public static int bitwiseAndOfNumberRanges(int m, int n) {
 *     while(n > m) {
 * 	       n &= n-1;
 * 	   }
 * return n;
 * }
 * 
 * */
